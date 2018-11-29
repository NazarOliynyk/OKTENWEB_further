package Lecture1;

import java.io.*;

/**
 * Created by user on 29.11.18.
 */
public class IO_Object_to_file {

    public static void main(String[] args) {
        User1 user1 = new User1();
        user1.setId(1);
        user1.setName("vasya");

        File file = new File(System.getProperty("user.dir")+File.separator+"myFileObject.txt");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //type OOS to write object into file

        try{

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(user1);
            objectOutputStream.close();

        }catch (IOException e) {
            e.printStackTrace();
        }

        //type OIS to write object into file

        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));

            try {
                User1 o = (User1) objectInputStream.readObject();
                System.out.println(o.getId()+", "+o.getName());
            }catch (ClassNotFoundException e){
                e.printStackTrace();
            }

            objectInputStream.close();
        } catch (IOException e){
            e.printStackTrace();
        }
}

static class User1 implements Serializable{ // this interface does nothing but informs that object goes to DB

    private  int id;
    private String name;

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

        User1 user1 = (User1) o;

        if (id != user1.id) return false;
        return name != null ? name.equals(user1.name) : user1.name == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
}