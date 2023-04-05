package com.gofortrainings.newsportal.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables=Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class OtherFruits {

@ValueMapValue
private String others;
@ValueMapValue
private String othersimage;
public String getOthers() {
	return others;
}
public String getOthersimage() {
	return othersimage;
}

}
