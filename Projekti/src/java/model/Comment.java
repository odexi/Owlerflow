/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Otto
 */
@Entity
@Table(name = "comment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comment.findAll", query = "SELECT c FROM Comment c")
    , @NamedQuery(name = "Comment.findByComID", query = "SELECT c FROM Comment c WHERE c.comID = :comID")
    , @NamedQuery(name = "Comment.findByCommenttimestamp", query = "SELECT c FROM Comment c WHERE c.commenttimestamp = :commenttimestamp")
    , @NamedQuery(name = "Comment.findByLikecount", query = "SELECT c FROM Comment c WHERE c.likecount = :likecount")})
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ComID")
    private Integer comID;
    @Lob
    @Size(max = 65535)
    @Column(name = "Content")
    private String content;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Comment_timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date commenttimestamp;
    @Column(name = "Likecount")
    private Integer likecount;
    @OneToMany(mappedBy = "comment")
    private Collection<CommentHasMedia> commentHasMediaCollection;
    @JoinColumn(name = "postid", referencedColumnName = "PostID")
    @ManyToOne(optional = false)
    private UserPost postid;
    @JoinColumn(name = "Com_UserID", referencedColumnName = "ID")
    @ManyToOne
    private User comUserID;

    public Comment() {
    }

    public Comment(Integer comID) {
        this.comID = comID;
    }

    public Comment(Integer comID, Date commenttimestamp) {
        this.comID = comID;
        this.commenttimestamp = commenttimestamp;
    }

    public Integer getComID() {
        return comID;
    }

    public void setComID(Integer comID) {
        this.comID = comID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCommenttimestamp() {
        return commenttimestamp;
    }

    public void setCommenttimestamp(Date commenttimestamp) {
        this.commenttimestamp = commenttimestamp;
    }

    public Integer getLikecount() {
        return likecount;
    }

    public void setLikecount(Integer likecount) {
        this.likecount = likecount;
    }

    @XmlTransient
    public Collection<CommentHasMedia> getCommentHasMediaCollection() {
        return commentHasMediaCollection;
    }

    public void setCommentHasMediaCollection(Collection<CommentHasMedia> commentHasMediaCollection) {
        this.commentHasMediaCollection = commentHasMediaCollection;
    }

    public UserPost getPostid() {
        return postid;
    }

    public void setPostid(UserPost postid) {
        this.postid = postid;
    }

    public User getComUserID() {
        return comUserID;
    }

    public void setComUserID(User comUserID) {
        this.comUserID = comUserID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (comID != null ? comID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comment)) {
            return false;
        }
        Comment other = (Comment) object;
        if ((this.comID == null && other.comID != null) || (this.comID != null && !this.comID.equals(other.comID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Comment[ comID=" + comID + " ]";
    }
    
}
