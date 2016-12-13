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
import javax.persistence.CascadeType;
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
@Table(name = "user_post")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserPost.findAll", query = "SELECT u FROM UserPost u")
    , @NamedQuery(name = "UserPost.findByPostID", query = "SELECT u FROM UserPost u WHERE u.postID = :postID")
    , @NamedQuery(name = "UserPost.findByPosttimestamp", query = "SELECT u FROM UserPost u WHERE u.posttimestamp = :posttimestamp")
    , @NamedQuery(name = "UserPost.findByTitle", query = "SELECT u FROM UserPost u WHERE u.title = :title")
    , @NamedQuery(name = "UserPost.findByLikes", query = "SELECT u FROM UserPost u WHERE u.likes = :likes")})
public class UserPost implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PostID")
    private Integer postID;
    @Lob
    @Size(max = 65535)
    @Column(name = "Content")
    private String content;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Post_timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date posttimestamp;
    @Size(max = 100)
    @Column(name = "Title")
    private String title;
    @Column(name = "Likes")
    private Integer likes;
    @Lob
    @Size(max = 65535)
    @Column(name = "url")
    private String url;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "postid")
    private Collection<Comment> commentCollection;
    @OneToMany(mappedBy = "post")
    private Collection<PostHasCategory> postHasCategoryCollection;
    @OneToMany(mappedBy = "postMed")
    private Collection<PostHasMedia> postHasMediaCollection;
    @JoinColumn(name = "Post_UserID", referencedColumnName = "ID")
    @ManyToOne
    private User postUserID;

    public UserPost() {
    }

    public UserPost(Integer postID) {
        this.postID = postID;
    }

    public UserPost(Integer postID, Date posttimestamp) {
        this.postID = postID;
        this.posttimestamp = posttimestamp;
    }

    public Integer getPostID() {
        return postID;
    }

    public void setPostID(Integer postID) {
        this.postID = postID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPosttimestamp() {
        return posttimestamp;
    }

    public void setPosttimestamp(Date posttimestamp) {
        this.posttimestamp = posttimestamp;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @XmlTransient
    public Collection<Comment> getCommentCollection() {
        return commentCollection;
    }

    public void setCommentCollection(Collection<Comment> commentCollection) {
        this.commentCollection = commentCollection;
    }

    @XmlTransient
    public Collection<PostHasCategory> getPostHasCategoryCollection() {
        return postHasCategoryCollection;
    }

    public void setPostHasCategoryCollection(Collection<PostHasCategory> postHasCategoryCollection) {
        this.postHasCategoryCollection = postHasCategoryCollection;
    }

    @XmlTransient
    public Collection<PostHasMedia> getPostHasMediaCollection() {
        return postHasMediaCollection;
    }

    public void setPostHasMediaCollection(Collection<PostHasMedia> postHasMediaCollection) {
        this.postHasMediaCollection = postHasMediaCollection;
    }

    public User getPostUserID() {
        return postUserID;
    }

    public void setPostUserID(User postUserID) {
        this.postUserID = postUserID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (postID != null ? postID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserPost)) {
            return false;
        }
        UserPost other = (UserPost) object;
        if ((this.postID == null && other.postID != null) || (this.postID != null && !this.postID.equals(other.postID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.UserPost[ postID=" + postID + " ]";
    }
    
}
