package com.gofortrainings.newsportal.core.Config;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
@ObjectClassDefinition(name="FruitConfigration",description="This is helps in runtime values.")
public @interface FruitConf {
@AttributeDefinition(name="month",description = "monthname", required = true)
public  String month()default "march";
@AttributeDefinition(name="fruit",description = "fruitname", required = true)
public String name()default "12";
}
