/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Otto
 */
@Entity
@Table(name = "media")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Media.findAll", query = "SELECT m FROM Media m")
    , @NamedQuery(name = "Media.findByMediaID", query = "SELECT m FROM Media m WHERE m.mediaID = :mediaID")
    , @NamedQuery(name = "Media.findByUrl", query = "SELECT m FROM Media m WHERE m.url = :url")
    , @NamedQuery(name = "Media.findByMediatype", query = "SELECT m FROM Media m WHERE m.mediatype = :mediatype")})
public class Media implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MediaID")
    private Integer mediaID;
    @Size(max = 1000)
    @Column(name = "URL")
    private String url;
    @Size(max = 25)
    @Column(name = "Media_type")
    private String mediatype;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "PATH")
    private String path;
    @OneToMany(mappedBy = "media")
    private Collection<CommentHasMedia> commentHasMediaCollection;
    @OneToMany(mappedBy = "medPost")
    private Collection<PostHasMedia> postHasMediaCollection;

    public Media() {
    }

    public Media(Integer mediaID) {
        this.mediaID = mediaID;
    }

    public Media(Integer mediaID, String path) {
        this.mediaID = mediaID;
        this.path = path;
    }

    public Integer getMediaID() {
        return mediaID;
    }

    public void setMediaID(Integer mediaID) {
        this.mediaID = mediaID;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMediatype() {
        return mediatype;
    }

    public void setMediatype(String mediatype) {
        this.mediatype = mediatype;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @XmlTransient
    public Collection<CommentHasMedia> getCommentHasMediaCollection() {
        return commentHasMediaCollection;
    }

    public void setCommentHasMediaCollection(Collection<CommentHasMedia> commentHasMediaCollection) {
        this.commentHasMediaCollection = commentHasMediaCollection;
    }

    @XmlTransient
    public Collection<PostHasMedia> getPostHasMediaCollection() {
        return postHasMediaCollection;
    }

    public void setPostHasMediaCollection(Collection<PostHasMedia> postHasMediaCollection) {
        this.postHasMediaCollection = postHasMediaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mediaID != null ? mediaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Media)) {
            return false;
        }
        Media other = (Media) object;
        if ((this.mediaID == null && other.mediaID != null) || (this.mediaID != null && !this.mediaID.equals(other.mediaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Media[ mediaID=" + mediaID + " ]";
    }
    
}
