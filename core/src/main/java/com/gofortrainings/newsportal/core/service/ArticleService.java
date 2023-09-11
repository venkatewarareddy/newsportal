package com.gofortrainings.newsportal.core.service;

import java.util.List;
import com.gofortrainings.newsportal.core.models.ArticleDetailsModel;

public interface ArticleService {

	public String getArticles();
  
  public List<ArticleDetailsModel>getRecentArticles();
  
}
