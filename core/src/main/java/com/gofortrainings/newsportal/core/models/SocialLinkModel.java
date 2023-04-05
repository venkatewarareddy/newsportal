package com.gofortrainings.newsportal.core.models;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class SocialLinkModel {
	
	    @ValueMapValue
	    private String socialMedia;
	    @ValueMapValue
	    private String socialLinks;

	    
	    public String getSocialMedia() {
	        return socialMedia;
	    }

	    public String getSocialLinks() {
	        return socialLinks;
	    }

	}



