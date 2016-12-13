package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.CommentHasMedia;
import model.PostHasMedia;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-08T14:10:34")
@StaticMetamodel(Media.class)
public class Media_ { 

    public static volatile SingularAttribute<Media, String> path;
    public static volatile CollectionAttribute<Media, CommentHasMedia> commentHasMediaCollection;
    public static volatile CollectionAttribute<Media, PostHasMedia> postHasMediaCollection;
    public static volatile SingularAttribute<Media, Integer> mediaID;
    public static volatile SingularAttribute<Media, String> mediatype;
    public static volatile SingularAttribute<Media, String> url;

}