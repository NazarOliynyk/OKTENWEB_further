package CW_3_Refl_Annot_Multithread_jwt;

import org.omg.Dynamic.Parameter;

import java.lang.reflect.Field;

/**
 * Created by user on 05.12.18.
 */

class Person{

    @ValidateId(message="Ahtung!!", defaultId = 999)
    private int id;
    private String name;

    public Person() {
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (id != person.id) return false;
        return name != null ? name.equals(person.name) : person.name == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}



public class Annotations {

    public static void main(String[] args) {

        Person person = new Person(-100, "Kokos");

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
            if(field.isAnnotationPresent(ValidateId.class)){
                System.out.println("Annotation is above field: "+ field.getName());
                if((int)field.get(person)<0){

                    ValidateId validateId = field.getAnnotation(ValidateId.class);

                    String s = validateId.message();

                    System.out.println(s);

                    int defaultId = validateId.defaultId();

                    field.set(person, defaultId);
                }
            }
        }
    }
}
