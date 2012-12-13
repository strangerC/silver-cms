package com.silver.cms.admin.webresource.web;

import com.silver.cms.common.Constants;
import com.silver.cms.dao.WebResourceJpaDAO;
import com.silver.cms.dao.exceptions.PreexistingEntityException;
import com.silver.cms.entity.WebResource;
import com.silver.seed.file.meta.SimpleFileMeta;
import com.silver.seed.file.meta.factory.DirectoryStyle;
import com.silver.seed.file.meta.factory.SavedNameStyle;
import com.silver.seed.file.meta.factory.SimpleFileMetaFactory;
import com.silver.seed.file.service.SimpleFileService;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 * 网络资源控制类
 * @author liaojian
 */
@Controller
@RequestMapping("/webresource")
public class WebResourceController {
    /**
     * 列出所有网络资源
     * @return 
     */
    @RequestMapping("list")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView();
        
        WebResourceJpaDAO dao = new WebResourceJpaDAO();
        
        List<WebResource> webResources = dao.findWebResourceEntities();
        
        
        mv.setViewName("webresource/list");
        return mv;
    }
    /**
     * 上传资源
     * @return 
     */
    @RequestMapping(value="uploadResource", method = RequestMethod.POST)
    public ModelAndView handleUploadResource(@RequestParam("uploadFilePath") MultipartFile fileUpload) throws IOException {
        byte[] bytes = null;
        //上传资源文件
        if(fileUpload != null && !fileUpload.isEmpty()) {            
            bytes = fileUpload.getBytes();
            File fileLocal = new File(Constants.UPLOAD_FILE_PATH + fileUpload.getOriginalFilename());
            FileOutputStream os = new FileOutputStream(fileLocal);
            os.write(bytes);
            os.close();
        }
        
        SimpleFileMeta simpleFileMeta = new SimpleFileMetaFactory(
                DirectoryStyle.DATE, SavedNameStyle.UUID, null).create(fileUpload.getOriginalFilename());
        new SimpleFileService().writeToFile(bytes, simpleFileMeta);
        //将资源文件信息记录到数据库中
        WebResource resource = new WebResource();
        resource.setType("file");
        resource.setName("test");        
        
        WebResourceJpaDAO dao = new WebResourceJpaDAO();
        try {
            dao.create(resource);
        } catch (PreexistingEntityException ex) {
            Logger.getLogger(WebResourceController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(WebResourceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ModelAndView mv = new ModelAndView();        
        mv.setViewName("webresource/list");
        return mv;        
    }
}
