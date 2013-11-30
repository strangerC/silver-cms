/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.silver.cms.template.showcase.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Liaojian
 */
@Controller
@RequestMapping(value = "/template")
public class TemplateController {
    @RequestMapping(value = "edit")
    public String edit() {
        return "template/edit";
    }
}
