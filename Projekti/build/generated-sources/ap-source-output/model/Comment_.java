package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.CommentHasMedia;
import model.User;
import model.UserPost;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-08T14:10:34")
@StaticMetamodel(Comment.class)
public class Comment_ { 

    public static volatile CollectionAttribute<Comment, CommentHasMedia> commentHasMediaCollection;
    public static volatile SingularAttribute<Comment, User> comUserID;
    public static volatile SingularAttribute<Comment, Date> commenttimestamp;
    public static volatile SingularAttribute<Comment, Integer> comID;
    public static volatile SingularAttribute<Comment, UserPost> postid;
    public static volatile SingularAttribute<Comment, Integer> likecount;
    public static volatile SingularAttribute<Comment, String> content;

}