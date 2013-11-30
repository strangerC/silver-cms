/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.silver.cms.webresource.dao;

import com.silver.cms.webresource.exceptions.NonexistentEntityException;
import com.silver.cms.webresource.entity.WebResource;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;

/**
 *
 * @author liaojian
 */
public class WebResourceJpaDefaultDAO implements Serializable {
    
    public WebResourceJpaDefaultDAO() {
        this(null, Persistence.createEntityManagerFactory("silverCMSPU"));
    }
    
    public WebResourceJpaDefaultDAO(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(WebResource webResource) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(webResource);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(WebResource webResource) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            webResource = em.merge(webResource);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = webResource.getId();
                if (findWebResource(id) == null) {
                    throw new NonexistentEntityException("The webResource with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            WebResource webResource;
            try {
                webResource = em.getReference(WebResource.class, id);
                webResource.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The webResource with id " + id + " no longer exists.", enfe);
            }
            em.remove(webResource);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<WebResource> findWebResourceEntities() {
        return findWebResourceEntities(true, -1, -1);
    }

    public List<WebResource> findWebResourceEntities(int maxResults, int firstResult) {
        return findWebResourceEntities(false, maxResults, firstResult);
    }

    private List<WebResource> findWebResourceEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(WebResource.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public WebResource findWebResource(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(WebResource.class, id);
        } finally {
            em.close();
        }
    }

    public int getWebResourceCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<WebResource> rt = cq.from(WebResource.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
