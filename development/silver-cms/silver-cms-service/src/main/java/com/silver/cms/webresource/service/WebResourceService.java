package com.silver.cms.webresource.service;

import com.silver.cms.commons.CommonConstants;
import com.silver.cms.webresource.dao.WebResourceJpaDao;
import com.silver.cms.webresource.entity.WebResource;
import com.silver.wheel.io.FileUtils;
import com.silver.wheel.io.filemeta.DefaultFileMeta;
import com.silver.wheel.io.filemeta.factory.DefaultFileMetaFactory;
import com.silver.wheel.io.filemeta.factory.DirectoryStyle;
import com.silver.wheel.io.filemeta.factory.NameGeneratedStyle;
import com.silver.wheel.lang.exception.CodedRuntimeException;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 *
 * @author Liaojian
 */
@Service
public class WebResourceService {
    
    @Resource
    private WebResourceJpaDao webResourceJpaDao;
    
    
    /**
     * 存储网页资源，包括文件和数据库的存储。
     * @param originalFilename
     * @param remark
     * @param bytes
     * @param size
     * @return 
     */
    public WebResource storeWebResource(String originalFilename, String remark, byte[] bytes, long size) {
        DefaultFileMeta defaultFileMeta = new DefaultFileMetaFactory(
                DirectoryStyle.DATE, NameGeneratedStyle.UUID, CommonConstants.UPLOAD_FILE_PATH).create(originalFilename);
        
        try {
            FileUtils.write(bytes, new File(defaultFileMeta.getPath()));
        } catch (IOException ex) {
            throw new CodedRuntimeException(ex);
        }
        
        //将资源文件信息记录到数据库中
        WebResource resource = new WebResource();
        resource.setType(defaultFileMeta.getExtension());
        resource.setName(defaultFileMeta.getName());
        resource.setNameGenerated(defaultFileMeta.getNameGenerated());
        resource.setResourceSize(size);
        resource.setUploadTimestamp(new Timestamp(new Date().getTime()));
        resource.setRemark(remark);
        
        webResourceJpaDao.save(resource);
        
        return resource;
    }

    public WebResourceJpaDao getWebResourceJpaDao() {
        return webResourceJpaDao;
    }

    public void setWebResourceJpaDao(WebResourceJpaDao webResourceJpaDao) {
        this.webResourceJpaDao = webResourceJpaDao;
    }        
}
