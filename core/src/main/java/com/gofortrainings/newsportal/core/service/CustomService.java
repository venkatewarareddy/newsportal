package com.gofortrainings.newsportal.core.service;



import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.gofortrainings.newsportal.core.Config.CustomConf;

@Component(immediate = true, service = CustomService.class)
@Designate(ocd = CustomConf.class)
public class CustomService {
	private static final Logger logger = LoggerFactory.getLogger(CustomService.class);
	
	CustomConf customConf;
    private  String monthName;
    private  String dateNumber;
   
	@Activate
	public void active(CustomConf customConf) {
		
		     this.customConf = customConf;
	     logger.info("month name is:"+customConf.jani()); 
	          monthName=customConf.jani();
	     
	     logger.info(" date of birthday :"+customConf.date());
	           dateNumber=customConf.date();
	           
	}

	public String jani() {
		
		return monthName;
	}

	public String date() {
		
		return dateNumber;
	}
	
	
}
