package com.aemgeeks.core.models;

import java.util.Date;

import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.Via;

@Model(adaptables = Resource.class)
public class TouchMultiFieldBean {
	
	@Optional
    @Inject
	private String pagePath;
	
	@Optional
    @Inject
	private String titleItem;	
	
	  
	public String getTitleItem() {
	return titleItem;
	}
	public void setTitleItem(String titleItem) {
	this.titleItem = titleItem;
	}
	public String getPagePath() {
		return pagePath;
	}
	public void setPagePath(String pagePath) {
		this.pagePath = pagePath;
	}

}
