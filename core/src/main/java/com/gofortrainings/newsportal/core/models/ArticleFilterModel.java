package com.gofortrainings.newsportal.core.models;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.day.cq.tagging.Tag;
import com.day.cq.tagging.TagManager;
import com.gofortrainings.newsportal.core.util.NewsportalUtil;

@Model(adaptables = {Resource.class,SlingHttpServletRequest.class},
        defaultInjectionStrategy =DefaultInjectionStrategy.OPTIONAL)
public class ArticleFilterModel {
	@ValueMapValue
	private String articleTag;

	@SlingObject
	ResourceResolver resolver;

	List<ArticleDetailsModel> articleList;

	private String title;

	@PostConstruct
	public void init() {
		if (articleTag != null) {
			TagManager tagManager = resolver.adaptTo(TagManager.class);
			Tag articleTagObj = tagManager.resolve(articleTag);
			title = articleTagObj.getTitle();
			articleList = NewsportalUtil.getArticleList(articleTagObj.find(), resolver);
		}
	}

	public List<ArticleDetailsModel> getArticleList() {
		return articleList;
	}

	public String getArticleTag() {
		return articleTag;
	}

	public String getTitle() {
		return title;
	}
}
