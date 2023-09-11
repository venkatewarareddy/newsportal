package com.gofortrainings.newsportal.core.models;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = { Resource.class, SlingHttpServletRequest.class })
public class ArticleListModel {
	@ValueMapValue
	private String[] articlePages;

	@SlingObject
	ResourceResolver resolver;

	List<ArticleDetailsModel> articleList;

	@PostConstruct
	public void init() {
		if (articlePages != null && articlePages.length > 0) {
			articleList=new ArrayList<>();
			for (String pagePath : articlePages) {
				Resource ArticleResource = resolver.getResource(
						pagePath + "/jcr:content/root/container/article_grid/left-container/article_details");
				if (ArticleResource != null) {
					ArticleDetailsModel articleModel = ArticleResource.adaptTo(ArticleDetailsModel.class);
					if (articleModel != null)
						articleList.add(articleModel);
				}

			}
		}
	}

	public String[] getArticlePages() {
		return articlePages;
	}

	public List<ArticleDetailsModel> getArticleList() {
		return articleList;
	}

}
