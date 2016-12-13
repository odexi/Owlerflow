package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Comment;
import model.Media;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-08T14:10:34")
@StaticMetamodel(CommentHasMedia.class)
public class CommentHasMedia_ { 

    public static volatile SingularAttribute<CommentHasMedia, Integer> commenthasmedia;
    public static volatile SingularAttribute<CommentHasMedia, Comment> comment;
    public static volatile SingularAttribute<CommentHasMedia, Media> media;

}