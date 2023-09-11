package com.gofortrainings.newsportal.core.models;

import javax.annotation.PostConstruct;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables= {Resource.class,SlingHttpServletRequest.class},
   defaultInjectionStrategy=DefaultInjectionStrategy.OPTIONAL)
public class SlidersModel {

	@ValueMapValue
	private String sliderTitle ;
	
	@ValueMapValue
	private String sliderImage ;
	
	@ValueMapValue
	private String pagePath ;
	
	public String getSliderTitle() {
		return sliderTitle;
	}

	public String getSliderImage() {
		return sliderImage;
	}

	public String getPagePath() {
		return pagePath;
	}

	@PostConstruct
	protected void init() {

	}
}
