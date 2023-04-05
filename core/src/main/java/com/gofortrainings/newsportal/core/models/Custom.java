package com.gofortrainings.newsportal.core.models;

import java.util.List;
import javax.annotation.PostConstruct;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.gofortrainings.newsportal.core.service.CustomService;

@Model(adaptables= {Resource.class},defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Custom {
	
	final static  Logger logger = LoggerFactory.getLogger(Custom.class);
	
	@ValueMapValue
	private String customDescription;
	@ValueMapValue
	private String customTitle;
	@ValueMapValue
	private String customImg;
	@ValueMapValue
	private String dropdown;
	@ValueMapValue
	private String customcheck;
	
	@ChildResource
	List<SocialMedia>socialMedia;
	
	@OSGiService
	CustomService customService;
	
	private String maliT;
	private String maliS;
	
		
	
	public String getCustomDescription() {
		return customDescription;
	}
	
	public String getCustomTitle() {
		return customTitle;
	}

	public String getCustomImg() {
		return customImg;
	}

	public String getDropdown() {
		return dropdown;
	}

	public String getCustomcheck() {
		return customcheck;
	}

	public List<SocialMedia> getSocialMedia() {
		return socialMedia;
	}
	public String getMaliT() {
		return maliT;
	}

	public String getMaliS() {
		return maliS;
	}

		@PostConstruct
	    public void init() {
		maliT=customService.jani();
		maliS=customService.date();

	}


}
