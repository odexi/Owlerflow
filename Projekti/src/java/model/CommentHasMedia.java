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
@Table(name = "comment_has_media")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CommentHasMedia.findAll", query = "SELECT c FROM CommentHasMedia c")
    , @NamedQuery(name = "CommentHasMedia.findByCommenthasmedia", query = "SELECT c FROM CommentHasMedia c WHERE c.commenthasmedia = :commenthasmedia")})
public class CommentHasMedia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "commenthasmedia")
    private Integer commenthasmedia;
    @JoinColumn(name = "Comment", referencedColumnName = "ComID")
    @ManyToOne
    private Comment comment;
    @JoinColumn(name = "Media", referencedColumnName = "MediaID")
    @ManyToOne
    private Media media;

    public CommentHasMedia() {
    }

    public CommentHasMedia(Integer commenthasmedia) {
        this.commenthasmedia = commenthasmedia;
    }

    public Integer getCommenthasmedia() {
        return commenthasmedia;
    }

    public void setCommenthasmedia(Integer commenthasmedia) {
        this.commenthasmedia = commenthasmedia;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (commenthasmedia != null ? commenthasmedia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CommentHasMedia)) {
            return false;
        }
        CommentHasMedia other = (CommentHasMedia) object;
        if ((this.commenthasmedia == null && other.commenthasmedia != null) || (this.commenthasmedia != null && !this.commenthasmedia.equals(other.commenthasmedia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.CommentHasMedia[ commenthasmedia=" + commenthasmedia + " ]";
    }
    
}
