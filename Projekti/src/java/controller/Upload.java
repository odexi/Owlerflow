/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Media;
import model.UserPost;
import model.Category;
import model.PostHasCategory;
import model.PostHasMedia;
import model.User;

/**
 *
 * @author Otto
 */
@WebServlet(urlPatterns = {"/upload"})
@MultipartConfig(location = "/var/www/html/project")
//"var/www/html/images")
public class Upload extends HttpServlet {
    
    @EJB // <-- important!!!!
    private PostSessionBean bean;

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //get form parameters from html page
        String title = request.getParameter("question-title");
        String content = request.getParameter("cont");
        String tag = request.getParameter("tag");
        int autid = Integer.parseInt(request.getParameter("autid"));
        String filename = request.getPart("temp").getSubmittedFileName();

        //get category with the tag name
        List<Category> c = bean.readTagByName(tag);

        //create new join in posthascategory
        PostHasCategory phc = new PostHasCategory();
        //set the category id from that category which tag we got from the form
        phc.setCategory(c.get(0));
        //get user that is logged in html page
        User u = bean.readUserByID(autid);
        //creates date that we use to set timestamps
        Date t = new Date();

        //creates new userpost and sets required fields on that and url is not working in our project and then we add it to database
        UserPost p = new UserPost();
        
        p.setTitle(title);
        p.setContent(content);
        p.setPostUserID(u);
        p.setLikes(0);
        p.setUrl("single_post.html");
        p.setPosttimestamp(t);
        bean.insert(p);

        //after creating userpost we can add the userpost to the join posthascategory table and insert join to the database
        phc.setPost(p);
        bean.insert(phc);

        //finds userpost with date and title and adds its id to the string
        List<UserPost> pos = bean.getPostMedia(title, t);
        String postID = "" + pos.get(0).getPostID();

        //creates media to the daattabaase 
        Media m = new Media();
        m.setPath(filename);
        m.setUrl("http://10.114.32.48/project/" + postID + "/");
        m.setMediatype("picture");
        
        bean.insert(m);
        
        List<Media> med = bean.getMediaPost("http://10.114.32.48/project/" + postID + "/", filename);
        
        PostHasMedia phm = new PostHasMedia();
        phm.setMedPost(med.get(0));
        phm.setPostMed(pos.get(0));
        
        bean.insert(phm);
        
        File test = new File("/var/www/html/project/" + postID);
        test.mkdirs();
        request.getPart("temp").write(postID + "/" + request.getPart("temp").getSubmittedFileName());
        String url = "//10.114.32.48/project/" + postID + "/" + request.getPart("temp").getSubmittedFileName();
        //bean.insert(new UserPost(Integer.SIZE, posttimestamp))
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title></title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Uploaded " + request.getPart("temp").getSubmittedFileName() + "</h1>");
            out.println("<h3><a href='index.html'>'Return to Home page'</a></h3>");
            //out.print("<img src=\"" + url + "\" alt=\"Image " + request.getPart("temp").getSubmittedFileName() + "\">");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }
    
}
