package com.gofortrainings.newsportal.core.models;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.day.cq.tagging.Tag;
import com.day.cq.tagging.TagManager;

@Model(adaptables = { Resource.class, SlingHttpServletRequest.class })
public class NewsCategoryModel {
	@ValueMapValue
	private String categoryNewsTitle;
	@ValueMapValue
	@Default(values = "newsportal:categories")
	private String categoryTag;
	@SlingObject
	ResourceResolver resolver;

	Map<String, Long> categoryChildTag;

	@PostConstruct
	public void init() {
		categoryChildTag = new HashMap<>();
		TagManager tagManager = resolver.adaptTo(TagManager.class);
		Tag categoryTagObj = tagManager.resolve(categoryTag);
		Iterator<Tag> childTags = categoryTagObj.listChildren();
		while (childTags.hasNext()) {
			Tag tag = (Tag) childTags.next();
			categoryChildTag.put(tag.getTitle(), tag.getCount());
		}
	}

	public String getCategoryNewsTitle() {
		return categoryNewsTitle;
	}

	public Map<String, Long> getCategoryChildTag() {
		return categoryChildTag;
	}


}
