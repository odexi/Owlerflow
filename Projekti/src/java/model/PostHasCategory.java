/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Otto
 */
@Entity
@Table(name = "post_has_category")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PostHasCategory.findAll", query = "SELECT p FROM PostHasCategory p")
    , @NamedQuery(name = "PostHasCategory.findByPosthascategory", query = "SELECT p FROM PostHasCategory p WHERE p.posthascategory = :posthascategory")})
public class PostHasCategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "posthascategory")
    private Integer posthascategory;
    @JoinColumn(name = "Category", referencedColumnName = "CatID")
    @ManyToOne
    private Category category;
    @JoinColumn(name = "Post", referencedColumnName = "PostID")
    @ManyToOne
    private UserPost post;

    public PostHasCategory() {
    }

    public PostHasCategory(Integer posthascategory) {
        this.posthascategory = posthascategory;
    }

    public Integer getPosthascategory() {
        return posthascategory;
    }

    public void setPosthascategory(Integer posthascategory) {
        this.posthascategory = posthascategory;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public UserPost getPost() {
        return post;
    }

    public void setPost(UserPost post) {
        this.post = post;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (posthascategory != null ? posthascategory.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PostHasCategory)) {
            return false;
        }
        PostHasCategory other = (PostHasCategory) object;
        if ((this.posthascategory == null && other.posthascategory != null) || (this.posthascategory != null && !this.posthascategory.equals(other.posthascategory))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.PostHasCategory[ posthascategory=" + posthascategory + " ]";
    }
    
}
