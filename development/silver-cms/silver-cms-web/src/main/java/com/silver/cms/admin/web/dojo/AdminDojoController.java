package com.silver.cms.admin.web.dojo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/dojo")
public class AdminDojoController {
	@RequestMapping("index")    
    public String index() {
        return "admin/dojo/index";
    }
}
