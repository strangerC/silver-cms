package com.silver.cms.entity;

import com.silver.seed.entity.Entity;
import java.sql.Timestamp;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@javax.persistence.Entity
@Table(name = "ARTICLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Article.findAll", query = "SELECT a FROM Article a"),
    @NamedQuery(name = "Article.findById", query = "SELECT a FROM Article a WHERE a.id = :id"),
    @NamedQuery(name = "Article.findByTitle", query = "SELECT a FROM Article a WHERE a.title = :title"),
    @NamedQuery(name = "Article.findByContent", query = "SELECT a FROM Article a WHERE a.content = :content")})
public class Article implements Entity {

    private static final long serialVersionUID = 2800965128899866522L;
    /**
     * 主键ID
     */
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    /**
     * 文档状态
     */
    private Short status;
    /**
     * 创建时间
     */
    private Timestamp created;
    /**
     * 创建的用户Id
     */
    private Long createdBy;
    /**
     * 最近一次修改时间
     */
    private Timestamp modified;
    /**
     * 最近一次修改的用户Id
     */
    private Long modifiedBy;
    /**
     * 标题
     */
    @Column(name = "TITLE")
    private String title;
    /**
     * 简介
     */
    private String summary;
    /**
     * 文档内容
     */
    @Column(name = "CONTENT")
    private String content;
    /**
     * url
     */
    private String url;
    /**
     * 点击率
     */
    private Long hits;

    @Override
    public Long getId() {
        return id;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getModified() {
        return modified;
    }

    public void setModified(Timestamp modified) {
        this.modified = modified;
    }

    public Long getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Long modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getHits() {
        return hits;
    }

    public void setHits(Long hits) {
        this.hits = hits;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
        if (!(object instanceof Article)) {
            return false;
        }
        Article other = (Article) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.silver.cms.entity.Article[ id=" + id + " ]";
    }
}
