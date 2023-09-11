package com.gofortrainings.newsportal.core.servlets;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ModifiableValueMap;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.ServletResolverConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.ServletException;
import java.io.IOException;

import javax.jcr.Node;
import javax.servlet.Servlet;
@Component(immediate=true,service=Servlet.class,
property= {Constants.SERVICE_DESCRIPTION +"=sample ajax call",
		   ServletResolverConstants.SLING_SERVLET_METHODS +"=POST",
		   ServletResolverConstants.SLING_SERVLET_RESOURCE_TYPES+ "=newsportal/components/fruits",
		   ServletResolverConstants.SLING_SERVLET_EXTENSIONS + "=json"})
		                                     
public class AjaxServlet extends SlingAllMethodsServlet {
private static final long serialVersionUid=1L;
private static final Logger log = LoggerFactory.getLogger(AjaxServlet.class);
@Override 
protected void doPost(  SlingHttpServletRequest request, SlingHttpServletResponse response)
throws ServletException,IOException{
	try {
	ResourceResolver resolver=request.getResourceResolver();
	Resource nodeRes=resolver.getResource("/content/ajaxcall");
	 Resource resource=request.getResource();
	 System.out.println(request.getParameter("text"));
	 String text = "some text";
	    response.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
	    response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
	    response.getWriter().write(text);       // Write response body.
	//JCR
	
	Node infoNode=nodeRes.adaptTo(Node.class);
	infoNode.getProperties("name");
	infoNode.setProperty("textNode","call");
	
	//set some property to node or save data
	//Sling
	ValueMap infoVM=nodeRes.getValueMap();
	infoVM.get("name", String.class);
	
	ModifiableValueMap map = nodeRes.adaptTo(ModifiableValueMap.class);
	map.put("modified", "value");
	
      nodeRes.getResourceResolver().commit();
	
	response.getWriter().write("Title =" +resource.adaptTo(ValueMap.class).get("jcr:title"));
	}
	catch(Exception e){
	log.info("There is an error in Newsportalajax call: " + e.getMessage());
	
}

}
}
