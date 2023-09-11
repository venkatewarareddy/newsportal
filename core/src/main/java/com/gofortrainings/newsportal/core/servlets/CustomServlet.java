package com.gofortrainings.newsportal.core.servlets;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.jcr.Node;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ModifiableValueMap;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.osgi.service.component.annotations.Component;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Component(immediate=true,service =Servlet.class )
/*@SlingServletResourceTypes(resourceTypes="newsportal/componenets/helloworld",extensions="txt",
                           selectors="customs",
                           methods=HttpConstants.METHOD_GET)*/
@SlingServletPaths(value="/bin/newsportal/custome")

public class CustomServlet extends  SlingAllMethodsServlet {
	private static final Logger log = LoggerFactory.getLogger(CustomServlet.class);
	@Override
	protected void doGet(SlingHttpServletRequest request,SlingHttpServletResponse response) 

		throws ServletException,IOException{
		try {
			ResourceResolver resolver=request.getResourceResolver();
			Resource nodeRes=resolver.getResource("/content/customservlet");
			//JCR
			Node infoNode=nodeRes.adaptTo(Node.class);
		   infoNode.getProperties("name");
		   infoNode.setProperty("textNode","nodeval");
			
			//Sling
			ValueMap infoVM=nodeRes.getValueMap();
			infoVM.get("name", String.class);
			
		    ModifiableValueMap map = nodeRes.adaptTo(ModifiableValueMap.class);
			map.put("modified", "value");
			
			nodeRes.getResourceResolver().commit();
			
		    response.getWriter().write("from sling : " + infoVM.get("name",String.class));

		}catch(Exception e) {
			log.info("There is an error in NewsportalNodeRetrive : " + e.getMessage());
			
		}
		
		
		}


}//"From the get server name is :"+ request.getProperties("name").toString() );//+" and server port is :"+request.getPart());
//getServletName()
