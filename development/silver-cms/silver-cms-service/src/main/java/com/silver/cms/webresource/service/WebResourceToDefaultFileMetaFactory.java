/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.silver.cms.webresource.service;

import com.silver.cms.webresource.entity.WebResource;
import com.silver.wheel.io.filemeta.DefaultFileMeta;
import com.silver.wheel.io.filemeta.factory.BaseFileMetaFactory;


/**
 *
 * @author Liaojian
 */
public class WebResourceToDefaultFileMetaFactory extends BaseFileMetaFactory<DefaultFileMeta, WebResource> {

    @Override
    protected DefaultFileMeta prepareFileMeta(DefaultFileMeta fileMeta, WebResource resource) {
        
        
        return fileMeta;
    }    
}
