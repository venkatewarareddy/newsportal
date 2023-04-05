package com.gofortrainings.newsportal.core.servlets;

import javax.servlet.Servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;

@Component(immediate=true,service =Servlet.class )
@SlingServletResourceTypes(resourceTypes="newsportal/componenets/page",extensions="txt",methods=HttpConstants.METHOD_GET)
public class FirstServlet extends SlingAllMethodsServlet{
	
@Override
protected void doGet(SlingHttpServletRequest request,SlingHttpServletResponse response) 

	throws ServletException,IOException{
		response.getWriter().write("From the get server name is :"+ request.getServerName()+" and server port is :"+request.getServerPort());
	}
}


