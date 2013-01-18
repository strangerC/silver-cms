package com.silver.cms.dao.impl;

import com.silver.cms.dao.WebResourceJpaDao;
import com.silver.cms.entity.WebResource;
import com.silver.seed.dao.jpa.BaseJpaDao;
import java.util.Collection;
import javax.persistence.Persistence;

/**
 *
 * @author Liaojian
 */
public class WebResourceJpaDaoImpl extends BaseJpaDao<WebResource, Long> implements 
        WebResourceJpaDao {
    public WebResourceJpaDaoImpl() {
        super(Persistence.createEntityManagerFactory("silverCMSPU"));
    }

    @Override
    public Collection<WebResource> retrieveAll() {
        return getEntityManager().createNamedQuery("WebResource.findAll", 
                WebResource.class).getResultList();
    }

    @Override
    public long count() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
