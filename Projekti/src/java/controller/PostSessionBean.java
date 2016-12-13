/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Date;
import model.UserPost;
import model.User;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Category;
import model.Comment;
import model.Media;
import model.PostHasCategory;
import model.PostHasMedia;

/**
 *
 * @author Valtteri
 */
@Stateless
@LocalBean
public class PostSessionBean {

    @PersistenceContext
    private EntityManager em;

    public UserPost insert(UserPost p) {
        em.persist(p);
        return p;
    }

    public List<UserPost> readAllPosts() {
        List<UserPost> uslist = em.createNamedQuery("UserPost.findAll").getResultList();
        if (uslist == null) {
            UserPost up = new UserPost(null); // <--- realy bad style of error prevention do not use if possible xD
            uslist.add(up);
            return uslist;
        } else {
            return uslist;
        }
    }

    public User readUserByID(int id) {
        //find command is used to find user by its primary key and parameter int id is user input
        User u = em.find(User.class, id);
        if (u == null) {
            u = new User(null);
            return u;
        } else {
            return u;
        }
    }

    public List<Category> readTagByName(String tag) {
        return em.createNamedQuery("Category.findByTag").setParameter("tag", tag).getResultList();

    }

    public PostHasCategory insert(PostHasCategory phc) {
        em.persist(phc);
        return phc;
    }

    public Media insert(Media m) {
        em.persist(m);
        return m;
    }
    
    public List<UserPost> getPostMedia(String title, Date date){
        return em.createQuery("SELECT u FROM UserPost u WHERE u.posttimestamp = :posttimestamp AND u.title = :title").setParameter("title", title).setParameter("posttimestamp", date).getResultList();
        
    }
     public PostHasMedia insert(PostHasMedia phm) {
        em.persist(phm);
        return phm;
    }
     
    public List<Media> getMediaPost(String url, String path){
        return em.createQuery("SELECT m FROM Media m WHERE m.url = :url AND m.path = :path").setParameter("url", url).setParameter("path", path).getResultList();
    }
    
    public List<PostHasMedia> getAllPostmedia(){
    	return em.createQuery("SELECT p FROM PostHasMedia p ORDER BY p.posthasmedia DESC").getResultList();
	}
    
    public Comment insert(Comment c){
        em.persist(c);
        return c;
    }
    
    public List<Comment> getCommentbyPostid(UserPost p){
        return em.createQuery("SELECT c FROM Comment c WHERE c.postid = :postid").setParameter("postid", p).getResultList();
    }
    

    
    public UserPost getUserPostById(int postid){
         return em.find(UserPost.class, postid);
        
    }
    
    public List<Comment> getAllComments(){
        return em.createNamedQuery("Comment.findAll").getResultList();
    }
}
