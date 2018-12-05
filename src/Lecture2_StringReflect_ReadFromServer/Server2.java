//package Lecture2_StringReflect_ReadFromServer;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import org.json.JSONArray;
//import org.json.JSONObject;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//
//import java.net.MalformedURLException;
//import java.util.ArrayList;
//
//public class Server2 {
//    public static void main(String[] args) {
//
//        String string = new String();
//        try {
//            //URL url = new URL("https:///D:///JAVA/OKTENWEB_further/jsonForServer2.txt");
//            //URL url = new URL("https://www.wikipedia.org/");
//
//            File file = new File("jsonForServer2.txt");
//            FileInputStream fileInputStream = new FileInputStream(file);
//            int size = fileInputStream.available();
//            byte [] bytes = new byte[size];
//            fileInputStream.read(bytes);
//            fileInputStream.close();
//            string = new String(bytes);
//            //System.out.println(string);
//
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }catch (IOException e){
//
//        }
//        //Shift+Ctrl+Alt+S  - call project as structure
//        // JSON must be in [], not in {}
//
//        System.out.println(string);
//        System.out.println("------------------------------");
//        JSONArray jsonArray = new JSONArray(string);
//        System.out.println(jsonArray.length());
//        System.out.println(jsonArray.get(1));
//
//        System.out.println("------------------------------");
//        ArrayList<User> users = new ArrayList<>();
//
//        for (int i = 0; i < jsonArray.length(); i++) {
//            JSONObject o = (JSONObject)jsonArray.get(i);
//            System.out.println(o.get("name")+",  "+o.get("age"));
//            users.add(new User((String) o.get("name"), (int)o.get("age")));
//        }
//        System.out.println("------------------------------");
//        for (User user : users) {
//            System.out.println(user);
//        }
//       // users.stream().forEach(user -> System.out.println(user));
//    }
//
//    @Data
//    @Builder
//    @AllArgsConstructor
//   static class User{
//        String name;
//        int age;
//    }
//}
//
