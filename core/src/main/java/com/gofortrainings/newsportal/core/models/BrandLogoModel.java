package com.gofortrainings.newsportal.core.models;

import javax.annotation.PostConstruct;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables=Resource.class,defaultInjectionStrategy=DefaultInjectionStrategy.OPTIONAL)
public class BrandLogoModel {

@ValueMapValue
private String logo;

@ValueMapValue
private String ads;

public String getLogo() {
	return logo;
}

public String getAds() {
	return ads;
}

@PostConstruct
protected void init() {

}
}
