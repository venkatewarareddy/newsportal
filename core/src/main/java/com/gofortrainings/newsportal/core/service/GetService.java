package com.gofortrainings.newsportal.core.service;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.sling.commons.json.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import java.io.IOException;
import java.net.URI;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

@Component(service=GetService.class,immediate =true)
public class GetService {
private static final Logger log=LoggerFactory.getLogger(GetService.class);
public JSONObject getResponse() throws ClientProtocolException,IOException{
	try {
		log. info("in service....");
		CloseableHttpClient httpclient=HttpClients.createDefault();
		HttpGet httpget = new HttpGet("https://dummy.restapiexample.com/api/v1/employees");
		HttpResponse httpresponse = httpclient.execute(httpget);
		String json = EntityUtils.toString(httpresponse.getEntity());		
		JSONObject myObject = new JSONObject(json);
		log.info("resp : " + myObject);
		return myObject;
	
	}catch(Exception e) {
		log.info("Error in getResponse:"+e.getMessage());
		return null;
	}
  }


}
