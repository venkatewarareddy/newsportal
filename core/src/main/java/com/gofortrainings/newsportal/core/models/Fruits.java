package com.gofortrainings.newsportal.core.models;

import java.util.List;



import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import javax.annotation.PostConstruct;
import com.gofortrainings.newsportal.core.service.FruitService;

@Model(adaptables=Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class Fruits {
	@ValueMapValue
	private String title;
	
	@ValueMapValue
	private String description;
	@ValueMapValue 
	private String image;
	
	@ChildResource
	List<OtherFruits>diff;
	
	@OSGiService
	FruitService fruitService;
	private String data;
	private String message;
	
	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getImage() {
		return image;
	}

	public List<OtherFruits> getDiff() {
		return diff;
	}

	public String getData() {
		return data;
	}

	public String getMessage() {
		return message;
	}
	@PostConstruct
    public void init() {
	data=fruitService.month();
	message=fruitService.name();
	}
}
