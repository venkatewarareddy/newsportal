package com.gofortrainings.newsportal.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables=Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class SocialMedia {
	@ValueMapValue
	private String facebook;
	@ValueMapValue
	private String instagram;
	public String getFacebook() {
		return facebook;
	}
	public String getInstagram() {
		return instagram;
	}
}
