/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.User;
import model.UserPost;
import model.Category;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import javax.ws.rs.core.MediaType;
import model.Comment;
import model.PostHasMedia;

/**
 * REST Web Service
 *
 * @author Valtteri
 */
@Path("Post")

public class PostResource {

    @Context
    private UriInfo context;

    @EJB // <-- important!!!!
    private PostSessionBean bean;

    /**
     * Creates a new instance of PostResource
     */
    public PostResource() {
    }

    /**
     * Retrieves representation of an instance of Controller.PostResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        List<UserPost> uslist = bean.readAllPosts();
        // user found and returning json data about login priviliges and activity        
        JsonArrayBuilder builder = Json.createArrayBuilder();
        for (UserPost up : uslist) {
            JsonObjectBuilder jobberi = Json.createObjectBuilder();
            jobberi.add("Title", up.getTitle());
            jobberi.add("Content", up.getContent());

            JsonObject userValue = jobberi.build();
            builder.add(userValue);
        }

        JsonArray Userp = builder.build();

        return Userp.toString();
    }

    @Path("comment")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String addComment(@FormParam("comment") String comment, @FormParam("userid") int userid, @FormParam("postid") int postid) {

        Comment c = new Comment();

        User u = bean.readUserByID(userid);
        UserPost up = bean.getUserPostById(postid);
        Date t = new Date();
        c.setComUserID(u);
        c.setContent(comment);
        c.setPostid(up);
        c.setCommenttimestamp(t);
        c.setLikecount(0);
        bean.insert(c);
        
//        Date t = new Date();
//        UserPost p = new UserPost();
//        
//        p.setTitle(title);
//        p.setContent(content);
//        p.setPostUserID(u);
//        p.setLikes(0);
//        p.setUrl("single_post.html");
//        p.setPosttimestamp(t);
        //UserPost up = bean.insert(p);

        /*JsonObject jsono = Json.createObjectBuilder()
                .add("question", title)
                .add("content", content)
                .add("author", autid)
                .build();*/
        return "kokeilu";

    }

    @Path("test")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserPost> test() {
        List<UserPost> test = bean.readAllPosts();

        return test;
    }

    @Path("collection")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PostHasMedia> contentandmedia() {
        return bean.getAllPostmedia();
    }
    
    @Path("comments")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Comment> comments(){
        return bean.getAllComments();
    }

}
