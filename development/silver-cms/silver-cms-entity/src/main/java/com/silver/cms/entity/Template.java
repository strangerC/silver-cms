/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.silver.cms.entity;

import com.silver.seed.entity.Entity;
/**
 *
 * @author liaojian
 */
public class Template implements Entity{   
	private static final long serialVersionUID = 325286855801129341L;
	
	private Long id;
    private String title;
    private String content;   
        
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }
    
    
}
