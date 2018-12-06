package Lecture_3_Refl_Annot_Multithread_jwt;



import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by user on 05.12.18.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,
        ElementType.TYPE,
        ElementType.PARAMETER}) // TYPE - for classes, FIELD - for fields, PARAMETR - for variables

public @interface ValidateId {

    String message();   // could be String message() defauld " ERROR";
    int defaultId();    //          int defaultId() default 999;
}


