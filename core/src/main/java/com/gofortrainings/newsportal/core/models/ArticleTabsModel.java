package com.gofortrainings.newsportal.core.models;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import com.day.cq.tagging.Tag;
import com.day.cq.tagging.TagManager;
import com.gofortrainings.newsportal.core.service.ArticleService;
import com.gofortrainings.newsportal.core.util.NewsportalUtil;

@Model(adaptables = { Resource.class,
		SlingHttpServletRequest.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ArticleTabsModel {

	@ValueMapValue
	@Default(values = "newsportal:featured")
	private String featuredTag;

	@ValueMapValue
	@Default(values = "newsportal:popular")
	private String popularTag;

	@SlingObject
	ResourceResolver reslover;
	@OSGiService
	ArticleService articleService;

	List<ArticleDetailsModel> featuredList;
	List<ArticleDetailsModel> popularList;
	List<ArticleDetailsModel> recentList;

	@PostConstruct
	public void init() {
		TagManager tagManager = reslover.adaptTo(TagManager.class);
		Tag featuredObjTag = tagManager.resolve(featuredTag);
		featuredList = NewsportalUtil.getArticleList(featuredObjTag.find(), reslover);

		Tag popularObjTag = tagManager.resolve(popularTag);
		popularList = NewsportalUtil.getArticleList(popularObjTag.find(), reslover);
		recentList = articleService.getRecentArticles();
	}

	public List<ArticleDetailsModel> getFeaturedList() {
		return featuredList;
	}

	public List<ArticleDetailsModel> getPopularList() {
		return popularList;
	}

	public List<ArticleDetailsModel> getRecentList() {
		return recentList;
	}

}