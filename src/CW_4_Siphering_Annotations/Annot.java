package CW_4_Siphering_Annotations;

import java.lang.reflect.Field;


/**
 * Created by okten26 on 12/5/18.
 */


class Person{

    @CheckAvailable(message="Ahtung!!", defaultValue = "_change it_")
   private String nickname;
    @CheckAvailable(message="Ahtung!!", defaultValue = "_change it_")
   private String surname;

    public Person() {
    }

    public Person(String nickname, String surname) {
        this.nickname = nickname;
        this.surname = surname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (nickname != null ? !nickname.equals(person.nickname) : person.nickname != null) return false;
        return surname != null ? surname.equals(person.surname) : person.surname == null;
    }

    @Override
    public int hashCode() {
        int result = nickname != null ? nickname.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "nickname='" + nickname + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}

public class Annot {

    public static void main(String[] args) {

        Person person = new Person("Sd@d fj&uh", "A!sd*f");

        System.out.println(person);
        System.out.println("----handler works -------");

        try {
            handler(person);
        }catch (IllegalAccessException e){
            System.out.println(e);
        }

        System.out.println("----after handling -------");
        System.out.println(person);
    }


    public static void handler(Person person) throws IllegalAccessException{

        Class<? extends Person> mirror = person.getClass();

        Field [] fields = mirror.getDeclaredFields();


        for (Field field : fields) {

            field.setAccessible(true);

            if(field.isAnnotationPresent(CheckAvailable.class)){


                 String string= (String) field.get(person);


                if(string.contains("!")||string.contains("@")||string.contains("#")
                        ||string.contains("$")||string.contains("%")||string.contains("&")||
                        string.contains("*")||string.contains("(")||string.contains(")")){

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
