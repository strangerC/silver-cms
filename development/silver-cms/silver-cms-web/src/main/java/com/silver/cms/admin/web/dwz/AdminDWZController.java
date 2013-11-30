package com.silver.cms.admin.web.dwz;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Liaojian
 */
@Controller
@RequestMapping("/admin/dwz")
public class AdminDWZController {
    
    @RequestMapping("index")    
    public String index() {
        return "admin/dwz/index";
    }
}
