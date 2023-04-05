package com.gofortrainings.newsportal.core.service;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gofortrainings.newsportal.core.Config.CustomConf;
import com.gofortrainings.newsportal.core.Config.FruitConf;
@Component(immediate=true,service=FruitService.class)
@Designate(ocd = FruitConf.class)
public class FruitService {
	private Logger logger =LoggerFactory.getLogger(LionService.class);
	private  String season;
    private  String name;
	private FruitConf fruitconf;
   
	@Activate
	public void active(FruitConf fruitconf) {
		this.fruitconf = fruitconf;
		logger.info("Newspotal Bundle is Activated from Fruit....");
		logger.info(" date of birthday :"+fruitconf.month());
		season =fruitconf.month();
		logger.info("month name is:"+fruitconf.name()); 
         name=fruitconf.name();
}
	public String month() {
		return season;
	}
	public String name() {
		return name;
	}

}
