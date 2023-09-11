package com.gofortrainings.newsportal.core.models;

import javax.annotation.PostConstruct;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
@Model(adaptables=Resource.class,defaultInjectionStrategy=DefaultInjectionStrategy.OPTIONAL)
public class FooterListModel {
	
@ValueMapValue
private String title;

@ValueMapValue
private String text;

@ValueMapValue
private String includeSocialIcons;

@ValueMapValue
private String includeSubscribeForm;

@ValueMapValue
private String displayInline;

@ValueMapValue
private String[] navLinks;


@PostConstruct
public void init() {

}

public String getTitle() {
	return title;
}


public String getText() {
	return text;
}


public String getIncludeSocialIcons() {
	return includeSocialIcons;
}


public String getIncludeSubscribeForm() {
	return includeSubscribeForm;
}


public String getDisplayInline() {
	return displayInline;
}


public String[] getNavLinks() {
	return navLinks;
}
}
