package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Comment;
import model.PostHasCategory;
import model.PostHasMedia;
import model.User;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-08T14:10:34")
@StaticMetamodel(UserPost.class)
public class UserPost_ { 

    public static volatile SingularAttribute<UserPost, Date> posttimestamp;
    public static volatile SingularAttribute<UserPost, User> postUserID;
    public static volatile CollectionAttribute<UserPost, Comment> commentCollection;
    public static volatile CollectionAttribute<UserPost, PostHasMedia> postHasMediaCollection;
    public static volatile CollectionAttribute<UserPost, PostHasCategory> postHasCategoryCollection;
    public static volatile SingularAttribute<UserPost, Integer> postID;
    public static volatile SingularAttribute<UserPost, String> title;
    public static volatile SingularAttribute<UserPost, String> content;
    public static volatile SingularAttribute<UserPost, String> url;
    public static volatile SingularAttribute<UserPost, Integer> likes;

}