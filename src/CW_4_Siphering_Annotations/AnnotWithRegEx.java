package CW_4_Siphering_Annotations;

import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by okten26 on 12/5/18.
 */


public class AnnotWithRegEx {

    public static void main(String[] args) {
        Person person = new Person("Nana#uy&", "Petrenko");

        try {
            handler(person);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        System.out.println(person);
    }

    public static void handler(Person person) throws IllegalAccessException{

        Class<? extends Person> mirror = person.getClass();

        Field [] fields = mirror.getDeclaredFields();


        for (Field field : fields) {

            field.setAccessible(true);

            if(field.isAnnotationPresent(CheckAvailable.class)){


                String string= (String) field.get(person);

                Pattern pattern = Pattern.compile("[!, @, #, $, %, ^, &, *, (, )]");
                Matcher matcher = pattern.matcher(string);

                if(matcher.find()){

                    CheckAvailable checkAvailable = field.getAnnotation(CheckAvailable.class);

                    String s = checkAvailable.message();

                    System.out.println(s);

                    String defaultId = checkAvailable.defaultValue();

                    field.set(person, defaultId);
                }
            }
        }
    }
}
