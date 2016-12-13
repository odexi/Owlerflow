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
@Table(name = "post_has_media")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PostHasMedia.findAll", query = "SELECT p FROM PostHasMedia p")
    , @NamedQuery(name = "PostHasMedia.findByPosthasmedia", query = "SELECT p FROM PostHasMedia p WHERE p.posthasmedia = :posthasmedia")})
public class PostHasMedia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "posthasmedia")
    private Integer posthasmedia;
    @JoinColumn(name = "MedPost", referencedColumnName = "MediaID")
    @ManyToOne
    private Media medPost;
    @JoinColumn(name = "PostMed", referencedColumnName = "PostID")
    @ManyToOne
    private UserPost postMed;

    public PostHasMedia() {
    }

    public PostHasMedia(Integer posthasmedia) {
        this.posthasmedia = posthasmedia;
    }

    public Integer getPosthasmedia() {
        return posthasmedia;
    }

    public void setPosthasmedia(Integer posthasmedia) {
        this.posthasmedia = posthasmedia;
    }

    public Media getMedPost() {
        return medPost;
    }

    public void setMedPost(Media medPost) {
        this.medPost = medPost;
    }

    public UserPost getPostMed() {
        return postMed;
    }

    public void setPostMed(UserPost postMed) {
        this.postMed = postMed;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (posthasmedia != null ? posthasmedia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PostHasMedia)) {
            return false;
        }
        PostHasMedia other = (PostHasMedia) object;
        if ((this.posthasmedia == null && other.posthasmedia != null) || (this.posthasmedia != null && !this.posthasmedia.equals(other.posthasmedia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.PostHasMedia[ posthasmedia=" + posthasmedia + " ]";
    }
    
}
