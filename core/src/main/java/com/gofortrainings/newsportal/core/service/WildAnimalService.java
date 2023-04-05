package com.gofortrainings.newsportal.core.service;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(immediate=true,service=WildAnimalService.class)
public class WildAnimalService {
	private static final Logger logger=LoggerFactory.getLogger(WildAnimalService.class);
	
	@Activate
	public void active() {
		logger.info("Newspotal Bundle is Activate..");
		
	}
	@Modified
	public void modify() {
		logger.info("Newspotal Bundle is Modified..");
		
	}
	@Deactivate
	public void deactivate() {
		logger.info("Newspotal Bundle is Deactivate");
		}
	public String eat(String foodType) {
		return "WildAnimal is eating"+foodType;
	}

}
