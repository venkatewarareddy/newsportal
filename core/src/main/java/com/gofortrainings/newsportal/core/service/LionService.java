package com.gofortrainings.newsportal.core.service;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(immediate=true,service=LionService.class)
@Designate(ocd=LionServiceConfig.class)
public class LionService {
private Logger logger =LoggerFactory.getLogger(LionService.class);
	
	@Reference
	private WildAnimalService wildAnimalService;
	LionServiceConfig lionServiceConfig;
	@Activate
	public void active( LionServiceConfig lionServiceConfig) {
		
		logger.info("Newspotal Bundle is Activated from Lion....");
		
		logger.info("Tiger config value : " + lionServiceConfig.food());
		
		logger.info("This is LionService :" + wildAnimalService.eat("meat"));
	}
	
}
