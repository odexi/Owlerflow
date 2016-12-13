package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Category;
import model.UserPost;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-08T14:10:34")
@StaticMetamodel(PostHasCategory.class)
public class PostHasCategory_ { 

    public static volatile SingularAttribute<PostHasCategory, UserPost> post;
    public static volatile SingularAttribute<PostHasCategory, Integer> posthascategory;
    public static volatile SingularAttribute<PostHasCategory, Category> category;

}