package com.silver.cms.common;

import com.silver.seed.configuration.PropertiesConfigurationFactory;
import org.apache.commons.configuration.Configuration;

/**
 *
 * @author Liaojian
 */
public final class Constants {
    public static final Configuration configuration = new PropertiesConfigurationFactory().create("cms.properties");  
    
    public static final String JSP_PATH = configuration.getString("jsp.path", "WEB-INF/pages/jsp/");
    public static final String ARTICLE_PAGE_PATH = configuration.getString("article.page.path", "WEB-INF/pages/jsp/article/");
    public static final String UPLOAD_FILE_PATH = configuration.getString("upload.file.pathh", "/temp/uploads");
    public static final String WEB_RESOURCE_FILE_PATH = configuration.getString("webResource.file.path", UPLOAD_FILE_PATH + "web-resource/");
        
}
