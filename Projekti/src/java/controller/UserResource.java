/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.User;
import java.util.List;
import javax.ejb.EJB;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Valtteri
 */
@Path("User")

public class UserResource {

    @Context
    private UriInfo context;

    //creates ejb for your own sessionbean so that this file can use information from sessionbean.
    @EJB // <-- important!!!!
    private UserSessionBean bean;

    /**
     * Creates a new instance of UserResource
     */
    public UserResource() {
    }

    /**
     * Retrieves representation of an instance of Controller.UserResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        List<User> ulst = bean.readAllUsers();
        // user found and returning json data about login priviliges and activity        
        JsonArrayBuilder builder = Json.createArrayBuilder();
        for (User u : ulst) {
            JsonObjectBuilder job = Json.createObjectBuilder();
            job.add("ID", u.getId());
            job.add("username", u.getUsername());

            JsonObject userValue = job.build();
            builder.add(userValue);
        }
        JsonArray userA = builder.build();

        return userA.toString();

    }

    @Path("valid")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String checkUser(@FormParam("username") String username, @FormParam("password") String password) {

        List<User> user = bean.readUserByNamePass(username, password);
        JsonArrayBuilder userpass = Json.createArrayBuilder();
            for (User u : user) {
            JsonObjectBuilder job = Json.createObjectBuilder();
            job.add("id", u.getId());
            job.add("username", u.getUsername());
            
            
            JsonObject userValue = job.build();
            userpass.add(userValue);
        }
            JsonArray finduser = userpass.build();
            
        //add objects that contains user information to json object style 
       
            return finduser.toString();
        
    }
    
    @GET
    @Path("allusers")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUsers() {

        return bean.getAllUsers();
    }
    
    @GET
    @Path("check")
    @Produces(MediaType.TEXT_PLAIN)
    public boolean getUserExist(@QueryParam("name") String name) {
        System.out.println("controller.UserResource.getUserExist() what? " + name);
        return bean.doesUsernameExist(name);
    }

    @POST 
    @Path("adduser")
    @Produces(MediaType.APPLICATION_JSON)
    public User postJson(@FormParam("name") String name, @FormParam("passwd") String passwd, @FormParam("email") String email) {

        return bean.insert(new User(name, passwd, email));

    }
    
}
