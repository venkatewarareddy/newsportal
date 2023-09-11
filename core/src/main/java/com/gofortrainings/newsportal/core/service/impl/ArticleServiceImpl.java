package com.gofortrainings.newsportal.core.service.impl;

import java.util.Iterator;
import java.util.List;

import javax.jcr.query.Query;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.osgi.service.component.annotations.Reference;

import com.gofortrainings.newsportal.core.models.ArticleDetailsModel;
import com.gofortrainings.newsportal.core.service.ArticleService;
import com.gofortrainings.newsportal.core.service.NPUtilService;
import com.gofortrainings.newsportal.core.util.NewsportalUtil;

public class ArticleServiceImpl implements ArticleService {

	@Reference
	NPUtilService npUtilService;
	@Override
	public String getArticles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticleDetailsModel> getRecentArticles() {
		 try(ResourceResolver resolver=npUtilService.getResourceResolver()){
			 String query="SELECT * FROM [cq:PageContent] AS s WHERE ISDESCENDANTNODE([/content/newsportal]) and  s.[cq:template]='/conf/newsportal/settings/wcm/templates/page-content' order by s.[jcr:created] desc option(limit 5)";
			Iterator<Resource> result=resolver.findResources(query, Query.JCR_SQL2);
			return NewsportalUtil.getArticleList(result, resolver);
		 }	
	}
}