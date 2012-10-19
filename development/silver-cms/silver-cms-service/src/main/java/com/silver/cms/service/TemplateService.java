/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.silver.cms.service;

import com.silver.cms.entity.Template;

import com.silver.cms.dao.TemplateDAO;

/**
 *
 * @author liaojian
 */
public class TemplateService {
    private TemplateDAO templateDAO;
            
    public void saveTemplate(Template template){
        getTemplateDAO().save(template);
    }

    /**
     * @return the templateDAO
     */
    public TemplateDAO getTemplateDAO() {
        return templateDAO;
    }

    /**
     * @param templateDAO the templateDAO to set
     */
    public void setTemplateDAO(TemplateDAO templateDAO) {
        this.templateDAO = templateDAO;
    }
}
