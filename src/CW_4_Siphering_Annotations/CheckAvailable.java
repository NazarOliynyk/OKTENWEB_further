package CW_4_Siphering_Annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by okten26 on 12/5/18.
 */


@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,
        ElementType.TYPE,
        ElementType.PARAMETER})

public @interface CheckAvailable {

    String message();
    String defaultValue();

}
