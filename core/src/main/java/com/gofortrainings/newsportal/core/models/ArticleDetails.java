package com.gofortrainings.newsportal.core.models;
import java.util.List;
import javax.annotation.PostConstruct;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Required;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = { Resource.class } ,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL) 
public class ArticleDetails {
   
	@ValueMapValue
   // @Default(values="this is ArticleTitle")
	private String articleTitle;
    @ValueMapValue
	private String articleDecs;
    @ValueMapValue
	private String articleImg;
   // @ValueMapValue(name="sling:resourceType")
	//private String slingresourceType;
   // private String extendsTitle;
    
    @ChildResource
    List<SocialLinkModel> socialLink;
	public String getArticleTitle() {
		return articleTitle;
	}
	public String getArticleDecs() {
		return articleDecs;
	}
	public String getArticleImg() {
		return articleImg;
	}
	public List<SocialLinkModel> getSocialLink() {
		return socialLink;
	}

	
}
