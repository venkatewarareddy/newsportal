package com.gofortrainings.newsportal.core.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import com.gofortrainings.newsportal.core.models.ArticleDetailsModel;

public class NewsportalUtil {

	public static List<ArticleDetailsModel> getArticleList(Iterator<Resource> articleResourceList,
			ResourceResolver resolver) {
		List<ArticleDetailsModel>articleList = new ArrayList<>();
		while (articleResourceList.hasNext()) {
			Resource resource = (Resource) articleResourceList.next();
			Resource articleResource = resolver.getResource(
					resource.getPath() + "/root/container/article_grid/left-container/article_details");
			if (articleResource != null) {
				ArticleDetailsModel articleModel = articleResource.adaptTo(ArticleDetailsModel.class);
				if (articleModel != null)
					articleList.add(articleModel);
			}
		}
		return articleList;
	}
}
