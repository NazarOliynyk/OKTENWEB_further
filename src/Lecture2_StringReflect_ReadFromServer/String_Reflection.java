package Lecture2_StringReflect_ReadFromServer;

import java.util.Arrays;

/**
 * Created by user on 30.11.18.
 */
public class String_Reflection {

    public static void main(String[] args) {

        String s1= "oktenweb";
        String s2= "oktenweb";
        String s3= new String("oktenweb");
        System.out.println("s1==s2 - " +(s1==s2)); // true
        System.out.println("s1==s3 - " +(s1==s3)); // false
        // == compares the equivalence in links
        System.out.println("s1.equals(s3) - "+s1.equals(s3)); // true

        // String - array of chars
        char[] chars = s1.toCharArray();
        System.out.println("Arrays.toString(chars)-  "+Arrays.toString(chars));// [o, k, t, e, n, w, e, b]

        // this is used to compare passwords:
        System.out.println(s1.toUpperCase()); // does not change the initial String
        System.out.println("PaSSworD".toLowerCase());

        System.out.println(s1.startsWith("ok")); // true
        System.out.println(s1.startsWith("o")); // true
        System.out.println(s1.startsWith("ow")); // false
        System.out.println(s1.endsWith("b"));  // true
        System.out.println(s1.endsWith("ob"));  // false

        System.out.println(s1.contains("web")); // true
        System.out.println(s1.contains("f")); // false

        System.out.println(s1.indexOf("e")); // the place in an array - 3
        System.out.println(s1.indexOf("e", 5)); // the place in an array - 6, starting from 4
        System.out.println(s1.lastIndexOf("e")); // the place in array - 6 from the end of an array
        System.out.println(s1.lastIndexOf("e", 4)); // the place in array - 3, from the end starting from 4

        System.out.println("------------------------------");

        String users = "1 serj 21;2 vasia 32;3 petya 33";
        String [] usersArray = users.split(";");
        System.out.println(Arrays.toString(usersArray)); // [1 serj 21,  2 vasia 32, 3 petya 33]
        for (String s : usersArray) {
            // Alt+Enter - check regex
            String [] uData = s.split(" ");
            System.out.println(Arrays.toString(uData));
            User user = new User();
            user.setId(Integer.parseInt(uData[0]));
            user.setName(uData[1]);
            user.setAge(Integer.parseInt(uData[2]));
            System.out.println(user);
        }

        System.out.println("------------------------------");

        System.out.println(s1.isEmpty()); // false
        System.out.println(" ".isEmpty()); // false - space has asky-code
        System.out.println("".isEmpty()); // true

        //System.out.println(null.isEmpty());

        System.out.println("------------------------------");

        System.out.println("s1.substring(2, 6) - "+s1.substring(2, 6)); // tenw 2-inclusive, 6-exclusive
        System.out.println("s1.charAt(5) - "+s1.charAt(5)); // w  -  the symbol which number is 5
        System.out.println(Arrays.toString(s1.getBytes())); // [111, 107, 116, 101, 110, 119, 101, 98]

        System.out.println("------------------------------");

        System.out.println(s1.replace("e", "!!!")); // okt!!!nw!!!b   changes certain letter or letters

    }
}
