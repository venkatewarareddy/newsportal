package com.gofortrainings.newsportal.core.models;

import javax.annotation.PostConstruct;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = { Resource.class,
		SlingHttpServletRequest.class }, 
     defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class TopBarModel {

	@ValueMapValue
	private String email;

	@ValueMapValue
	private String num;

	@ValueMapValue
	private String[] topNavPages;

	@PostConstruct
	public void init() {
		
	}
	public String[] getTopNavPages() {
		return topNavPages;
	}

	public String getEmail() {
		return email;
	}

	public String getNum() {
		return num;
	}
}