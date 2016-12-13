package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.PostHasCategory;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-08T14:10:34")
@StaticMetamodel(Category.class)
public class Category_ { 

    public static volatile SingularAttribute<Category, Integer> catID;
    public static volatile CollectionAttribute<Category, PostHasCategory> postHasCategoryCollection;
    public static volatile SingularAttribute<Category, String> tag;

}