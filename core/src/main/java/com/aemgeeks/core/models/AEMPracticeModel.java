package com.aemgeeks.core.models;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.RequestAttribute;
import org.apache.sling.settings.SlingSettingsService;


@Model(adaptables = { SlingHttpServletRequest.class, Resource.class})
@Exporter(name = "jackson", extensions = "json")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AEMPracticeModel{

    private static final Logger LOGGER = LoggerFactory.getLogger(AEMPracticeModel.class);
	
	@OSGiService
	private SlingSettingsService slingSettingsService;
	
	@RequestAttribute
	@Default(values = "null")
	private String runmode;

	@Optional
    @Inject
    @Via("resource")
    private String title;
	
	@Optional
    @Inject
    @Via("resource")
    private String bkgimage;
	
	@Optional
    @Inject
    @Via("resource")
    private String dampath;
	
	private boolean author;
	
	/**
     * Tabs title multifield value.
     */
    @Optional
    @Inject
    @Via("resource")
    private List<TouchMultiFieldBean> navigationitem;

    /**
     * Init Method of Model.
     */
    @PostConstruct
    public final void init() {
		runmode = slingSettingsService.getRunModes().toString();
		if(runmode != null && runmode.contains("author")){
			author = true;
		}
    	LOGGER.info("ValueMap not found for resource {}", runmode);

    }    

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

	public String getBkgimage() {
		return bkgimage;
	}

	public void setBkgimage(String bkgimage) {
		this.bkgimage = bkgimage;
	}

	public String getDampath() {
		return dampath;
	}

	public void setDampath(String dampath) {
		this.dampath = dampath;
	}

	public List<TouchMultiFieldBean> getNavigationitem() {
		return navigationitem;
	}

	public void setNavigationitem(List<TouchMultiFieldBean> navigationitem) {
		this.navigationitem = navigationitem;
	}
	
	public String getRunmode() {
		return runmode;
	}
	
	public boolean getAuthor(){
		return author;
	}
	

    

}