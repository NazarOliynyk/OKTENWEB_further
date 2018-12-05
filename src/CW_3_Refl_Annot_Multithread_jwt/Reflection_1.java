package CW_3_Refl_Annot_Multithread_jwt;

import org.omg.Dynamic.Parameter;

import java.lang.reflect.*;

/**
 * Created by user on 05.12.18.
 */
class User {

    private int id;
    private String name;

    public User() {
    }

    public User(int id, String name) {
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

        User user = (User) o;

        if (id != user.id) return false;
        return name != null ? name.equals(user.name) : user.name == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}


public class Reflection_1 {

    public static void main(String[] args) throws IllegalAccessException,
            NoSuchMethodException,
            InstantiationException,
            InvocationTargetException{

        User user = new User(1, "Vasya");

        // to create a reflection of a class
        Class<? extends User> mirror = user.getClass();

        Field[] declaredFieldsFields = mirror.getDeclaredFields();

        for (Field field : declaredFieldsFields) {
            System.out.println(field.getType() + " " + field.getName());
//            System.out.println(field.getType()+" "
//                    +field.getName()+" "
//                     +field.get(user)); // throws IllegalAccessException because of private fields

            field.setAccessible(true); // gives access to private fields
            System.out.println(field.getType() + " "
                    + field.getName() + " "
                    + field.get(user));

            if (field.getType().toString().equals("int")) {
                field.set(user, 1000);
            }
        }
            System.out.println("user after changing - "+user);

            // to create a reflection of an object

            Class<User> userClass = User.class;

             User defaultUser= userClass.getDeclaredConstructor().newInstance(); // with no param or with them
             User allArgsUser= userClass.getDeclaredConstructor(int.class, String.class)
                    .newInstance(999, "kokos");
            System.out.println(allArgsUser);

            // getting declared methods

        Method[] methods =  userClass.getDeclaredMethods();

        for (Method method : methods) {
            System.out.println(method.getName()+" "+
            method.getReturnType()+" "+
            method.getModifiers()); // should be getParametrCount(); !!
        }

        // all declared constructors
        System.out.println("------------constructors---------");
        Constructor<?>[] constructors = userClass.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {

            Type[] types = constructor.getParameterTypes();
           // Parameter[] parameters = constructor.getPapameters();
            // it shows in console - args0, args1 ...
            for (Type type: types) {
                System.out.println(type.toString());
            }
        }


    }
}
