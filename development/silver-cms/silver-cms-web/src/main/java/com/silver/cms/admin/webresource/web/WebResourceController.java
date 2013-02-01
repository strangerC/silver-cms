package com.silver.cms.admin.webresource.web;

import com.silver.cms.common.Constants;
import com.silver.cms.dao.WebResourceJpaDao;
import com.silver.cms.entity.WebResource;
import com.silver.seed.file.meta.SimpleFileMeta;
import com.silver.seed.file.meta.factory.DirectoryStyle;
import com.silver.seed.file.meta.factory.SavedNameStyle;
import com.silver.seed.file.meta.factory.SimpleFileMetaFactory;
import com.silver.seed.file.service.SimpleFileService;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 * 网页资源控制类
 *
 * @author liaojian
 */
@Controller
@RequestMapping("/webresource")
public class WebResourceController {
    @Resource
    private WebResourceJpaDao webResourceJpaDao;          

    public WebResourceJpaDao getWebResourceJpaDao() {
        return webResourceJpaDao;
    }
    
    @Resource
    public void setWebResourceJpaDao(WebResourceJpaDao webResourceJpaDao) {
        this.webResourceJpaDao = webResourceJpaDao;
    }    
        
    /**
     * 列出所有网页资源
     *
     * @return
     */
    @RequestMapping("list")
    public ModelAndView list() {        
             
        
        List<WebResource> result = (List<WebResource>)webResourceJpaDao.findAll();
        
        ModelAndView mv = new ModelAndView();
        mv.setViewName("webresource/list");
        mv.addObject("webResourceList", result);
        
        return mv;
    }
    /**
     * 
     * @param id
     * @return 
     */
    @RequestMapping("{id}")    
    public ModelAndView retrieveWebResource(@PathVariable Long id) {            
        WebResource wr = webResourceJpaDao.findOne(id);
        
        ModelAndView mv = new ModelAndView();                        
        mv.setViewName("webresource/view");
        mv.addObject("webResource", wr);
        
        return mv;
    }
    
    @RequestMapping("delete")  
    public String deleteWebResources(@RequestParam("idSelected")Long[] ids) {        
        if(ids != null) {
            for(Long id : ids) {
                webResourceJpaDao.delete(id);
            }
        }
        return "forward:/webresource/list";
    }

    /**
     * 上传资源
     *
     * @return
     */
    @RequestMapping(value = "uploadResource", method = RequestMethod.POST)
    public ModelAndView handleUploadResource(@RequestParam("uploadFilePath") MultipartFile fileUpload) 
            throws IOException {
        byte[] bytes = null;
        //上传资源文件
        if (fileUpload != null && !fileUpload.isEmpty()) {
            bytes = fileUpload.getBytes();            
            //创建FileMeta文件，构造上传文件的元数据，根据元数据和资源文件内容保存
            SimpleFileMeta simpleFileMeta = new SimpleFileMetaFactory(
                    DirectoryStyle.DATE, SavedNameStyle.UUID, null).create(fileUpload.getOriginalFilename());
            simpleFileMeta.setPath(Constants.UPLOAD_FILE_PATH + simpleFileMeta.getPath());
            new SimpleFileService().writeToFile(bytes, simpleFileMeta);
            //将资源文件信息记录到数据库中
            WebResource resource = new WebResource();
            resource.setType("file");
            resource.setName("test");            
            
            webResourceJpaDao.save(resource);
            
        }
        ModelAndView mv = new ModelAndView();
        mv.setViewName("webresource/list");
        return mv;
    }        
}
