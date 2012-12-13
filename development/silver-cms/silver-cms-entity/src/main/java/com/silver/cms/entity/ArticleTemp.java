/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.silver.cms.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author CN085910
 */
@Entity
@Table(name = "ARTICLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ArticleTemp.findAll", query = "SELECT a FROM ArticleTemp a"),
    @NamedQuery(name = "ArticleTemp.findById", query = "SELECT a FROM ArticleTemp a WHERE a.id = :id"),
    @NamedQuery(name = "ArticleTemp.findByTitile", query = "SELECT a FROM ArticleTemp a WHERE a.titile = :titile"),
    @NamedQuery(name = "ArticleTemp.findByContent", query = "SELECT a FROM ArticleTemp a WHERE a.content = :content")})
public class ArticleTemp implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Column(name = "TITILE")
    private String titile;
    @Column(name = "CONTENT")
    private String content;

    public ArticleTemp() {
    }

    public ArticleTemp(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitile() {
        return titile;
    }

    public void setTitile(String titile) {
        this.titile = titile;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArticleTemp)) {
            return false;
        }
        ArticleTemp other = (ArticleTemp) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.silver.cms.entity.ArticleTemp[ id=" + id + " ]";
    }
    
}
