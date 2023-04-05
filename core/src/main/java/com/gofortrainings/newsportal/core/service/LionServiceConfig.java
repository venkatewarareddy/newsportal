package com.gofortrainings.newsportal.core.service;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name="LionServiceConfiguration",
description="this is provide run time values of lion service")
public @interface LionServiceConfig {
	@AttributeDefinition(name = "food", description = "What tiger eats", required = true)
	public String food() default "Test Meal";

}
