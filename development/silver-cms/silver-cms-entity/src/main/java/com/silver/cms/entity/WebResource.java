/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.silver.cms.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author liaojian
 */
@Entity
@Table(name = "web_resource")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WebResource.findAll", query = "SELECT w FROM WebResource w"),
    @NamedQuery(name = "WebResource.findById", query = "SELECT w FROM WebResource w WHERE w.id = :id"),
    @NamedQuery(name = "WebResource.findByName", query = "SELECT w FROM WebResource w WHERE w.name = :name"),
    @NamedQuery(name = "WebResource.findByType", query = "SELECT w FROM WebResource w WHERE w.type = :type")})
public class WebResource implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "TYPE")
    private String type;

    public WebResource() {
    }

    public WebResource(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        if (!(object instanceof WebResource)) {
            return false;
        }
        WebResource other = (WebResource) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.silver.cms.entity.WebResource[ id=" + id + " ]";
    }
    
}
