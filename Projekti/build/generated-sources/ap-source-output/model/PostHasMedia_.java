package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Media;
import model.UserPost;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-08T14:10:34")
@StaticMetamodel(PostHasMedia.class)
public class PostHasMedia_ { 

    public static volatile SingularAttribute<PostHasMedia, UserPost> postMed;
    public static volatile SingularAttribute<PostHasMedia, Media> medPost;
    public static volatile SingularAttribute<PostHasMedia, Integer> posthasmedia;

}