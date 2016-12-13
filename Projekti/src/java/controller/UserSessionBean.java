/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import model.User;
import model.UserPost;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Valtteri
 */
@Stateless
@LocalBean
public class UserSessionBean {

    @PersistenceContext
    private EntityManager em;

    public User insert(User u) {
        em.persist(u);
        return u;
    }

    //updates existing users columns if used in usersresource
    public void update(User u) {
        em.merge(u);

    }

    //creates list of all users with named query which is located in model.Users 
    public List<User> readAllUsers() {
        List<User> ulst = em.createNamedQuery("User.findAll").getResultList();
        if (ulst == null) {
            User u = new User(null); // <--- realy bad style of error prevention do not use if possible xD
            ulst.add(u);
            return ulst;
        } else {
            return ulst;
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

    //own created query and it uses parameter what user has put in input and query puts all of that users information in list.
    public List<User> readUserByUsername(String username) {
        List<User> ul = em.createNamedQuery("User.findByUsername").setParameter("username", username).getResultList();
        if (ul == null) {
            User u = new User(null);
            ul.add(u);
            return ul;
        } else {
            return ul;
        }
    }

    public List<User> readUserByNamePass(String username, String password) {
        return em.createQuery("SELECT u FROM User u WHERE u.username = :username AND u.passwd = :passwd").setParameter("passwd", password).setParameter("username", username).getResultList();
//        List<User> ul = em.createQuery("SELECT u FROM User u WHERE u.username = :username AND u.passwd = :passwd").setParameter("passwd", password).setParameter("username", username).getResultList();
//        if (ul == null) {
//            User u = new User(null);
//            ul.add(u);
//            return ul;
//        } else {
//            return ul;
//        }
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
     public boolean doesUsernameExist(String username) {

        return em.createNamedQuery("User.findByUsername").setParameter("username", username).getResultList().size() >= 1;
           
    }

    public List<User> getAllUsers() {
        //  em.flush();
        return em.createNamedQuery("User.findAll").getResultList();
    }
    
    
    
}
