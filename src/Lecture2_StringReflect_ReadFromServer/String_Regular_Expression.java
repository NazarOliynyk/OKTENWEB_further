package Lecture2_StringReflect_ReadFromServer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 30.11.18.
 */
public class String_Regular_Expression {

    public static void main(String[] args) {

        String phoneNumber1 = "+38(067)6752921";
        String phoneNumber2 = "+38(067)454-45-55";

        // Alt+Enter check regex

       Pattern pattern1= Pattern.compile("\\+\\d{2,3}\\(\\d{2,3}\\)\\d{7}"); //+381(67)6752921

        Pattern pattern2= Pattern.compile("\\+\\d{2,3}\\(\\d{2,3}\\)\\d{3}\\-?\\d{2}\\-?\\d{2}"); // +381(67)675-29-21 &  +381(67)6752921

        Matcher matcher1 = pattern1.matcher(phoneNumber1);

        Matcher matcher2 = pattern2.matcher(phoneNumber2);

        boolean find1 = matcher1.find();
        boolean find2 = matcher2.find();

        System.out.println(find1);
        System.out.println(find2);
    }
}
