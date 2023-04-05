package com.gofortrainings.newsportal.core.Config;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name="CustomConfigration",description="this is helps in runtime values.")
public @interface CustomConf {
	@AttributeDefinition(name = "val", description = "values", required = true)
	public  String date() default "12";
	
	@AttributeDefinition(name = "jani", description = "What is current month", required = true)
	public String jani() default " Feb ";
	
	
	
}
