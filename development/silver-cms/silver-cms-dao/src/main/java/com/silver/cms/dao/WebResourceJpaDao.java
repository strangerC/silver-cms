/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.silver.cms.dao;

import com.silver.cms.entity.WebResource;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Liaojian
 */
public interface WebResourceJpaDao extends JpaRepository<WebResource, Long> {   
}
