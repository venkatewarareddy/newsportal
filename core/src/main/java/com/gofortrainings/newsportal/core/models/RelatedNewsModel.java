package com.gofortrainings.newsportal.core.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import com.day.cq.tagging.Tag;
import com.day.cq.tagging.TagManager;
import com.gofortrainings.newsportal.core.util.NewsportalUtil;

@Model(adaptables = { Resource.class,
		SlingHttpServletRequest.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class RelatedNewsModel {

	@ValueMapValue
	private String title;

	@ScriptVariable
	ValueMap pageProperties;

	@SlingObject
	ResourceResolver resolver;

	List<ArticleDetailsModel> articleList;

	@PostConstruct
	public void init() {
		String[] tags = pageProperties.get("cq:tags", String[].class);
		String categoryTag = getCategoryTag(tags);
		if (categoryTag != null) {
			TagManager tagManager = resolver.adaptTo(TagManager.class);
			Tag categoryTagObj = tagManager.resolve(categoryTag);
			Iterator<Resource> references = categoryTagObj.find();
		     articleList =NewsportalUtil.getArticleList(references, resolver);
		}
	}

	public String getCategoryTag(String[] tags) {
		for (String tag : tags) {
			if (tag.startsWith("newsportal:categories")) {
				return tag;
			}
		}
		return null;
	}

	public String getTitle() {
		return title;
	}

	public List<ArticleDetailsModel> getArticleList() {
		return articleList;
	}

}