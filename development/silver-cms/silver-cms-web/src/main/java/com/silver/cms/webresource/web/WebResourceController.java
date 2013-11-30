package com.silver.cms.webresource.web;


import com.silver.cms.webresource.dao.WebResourceJpaDao;
import com.silver.cms.webresource.entity.WebResource;
import com.silver.cms.webresource.service.WebResourceService;
import java.io.IOException;
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
    public static final String WEBRESOURCE_LIST_URL = "/webresource/list";
    
    @Resource
    private WebResourceJpaDao webResourceJpaDao;  
    @Resource
    private WebResourceService webResourceService;

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
    /**
     * 删除资源
     * @param ids
     * @return 
     */
    @RequestMapping("delete")  
    public String deleteWebResources(@RequestParam("idSelected")Long[] ids) {        
        if(ids != null) {
            for(Long id : ids) {
                webResourceJpaDao.delete(id);
            }
        }
        return "forward:" + WEBRESOURCE_LIST_URL;
    }

    /**
     * 上传资源
     *
     * @return
     */
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String handleUploadResource(@RequestParam("uploadFilePath") MultipartFile fileUpload, 
        @RequestParam("remark") String remark) 
            throws IOException {
        byte[] bytes = null;
        //上传资源文件
        if (fileUpload != null && !fileUpload.isEmpty()) {
            bytes = fileUpload.getBytes();            
            //创建FileMeta文件，构造上传文件的元数据，根据元数据和资源文件内容保存
            webResourceService.storeWebResource(
                    fileUpload.getOriginalFilename(), remark, bytes, fileUpload.getSize());
            
        }
        //跳转回资源列表
        return "forward:" + WEBRESOURCE_LIST_URL;
    }   
    
    @RequestMapping("modify")
    public String updateWebResource(Long id) {                
        return null;
    }
}
