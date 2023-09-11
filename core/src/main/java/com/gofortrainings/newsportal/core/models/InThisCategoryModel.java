package com.gofortrainings.newsportal.core.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.jcr.query.Query;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = {Resource.class ,SlingHttpServletRequest.class},defaultInjectionStrategy =DefaultInjectionStrategy.OPTIONAL )
public class InThisCategoryModel {

	@ValueMapValue
	private String title;
	
	@ScriptVariable
	ValueMap pageProperties;
	
	@SlingObject
	ResourceResolver resolver;
	
   List<ArticleDetailsModel>articleList;
	
	@PostConstruct
	public void init() {
		if (pageProperties != null) {
			articleList=new ArrayList<>();
			String[] tags = pageProperties.get("cq:tags", String[].class);
			String categoryTag = findCategoryTag(tags);
			String query = "SELECT * FROM [cq:Page] AS s WHERE ISDESCENDANTNODE([/content/newsportal])and s.[jcr:content/cq:tags]like '"
					+ categoryTag + "%'";
			Iterator<Resource> result = resolver.findResources(query, Query.JCR_SQL2);
			while (result.hasNext()) {
				Resource resource = (Resource) result.next();
				Resource articleResource = resolver.getResource(
						resource.getPath()+ "/jcr:content/root/container/article_grid/left-container/article_details");
				if (articleResource != null) {
					ArticleDetailsModel articleModel = articleResource.adaptTo(ArticleDetailsModel.class);
					if (articleModel != null)
						articleList.add(articleModel);
				}
			}
		}
	}

	private String findCategoryTag(String[] tags) {
		for (String tag : tags) {
			if (tag.startsWith("newsportal:categories")) {
				String[] tagItems = tag.split("/");
				if (tagItems.length >= 2) {
					return tagItems[0] + "/" + tagItems[1];
				}
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
