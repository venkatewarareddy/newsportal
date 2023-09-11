package com.gofortrainings.newsportal.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = { Resource.class,
		SlingHttpServletRequest.class },defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ArticleDetailsModel {

	@ValueMapValue
	private String articleTitle;
	@ValueMapValue
	private String articleDecs;
	@ValueMapValue
	private String articleImg;
	@ValueMapValue
	private String articlePagePath;

	public String getArticleTitle() {
		return articleTitle;
	}

	public String getArticleDecs() {
		return articleDecs;
	}

	public String getArticleImg() {
		return articleImg;
	}

	public String getArticlePagePath() {
		return articlePagePath;
	}

}