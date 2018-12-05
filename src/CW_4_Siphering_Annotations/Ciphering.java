package CW_4_Siphering_Annotations;

import java.util.Arrays;

/**
 * Created by okten26 on 12/5/18.
 */
public class Ciphering {

    public static int[] cipher(String string, int pin){

        char[] chars = string.toCharArray();

        int[] cipheredChars = new int[chars.length];

        for (int i = 0; i < cipheredChars.length; i++) {
            cipheredChars[i] = (int)chars[i]*pin;

        }
        return cipheredChars;
    }



    public static String decipherByWordAndPin(String key, int pin, int[] code){

        String string="";

        if(key.equals("Hello")){
            for (int i = 0; i < code.length; i++) {
                string+= (char)(code[i]/pin);

            }
        }
        else {
            System.out.println("Wrong key!!!");
            return null;
        }
        return string;
    }

    public static String decipherByNumber(int pin, int[] code){

        String string="";

            for (int i = 0; i < code.length; i++) {
                string += (char) (code[i] / pin);

            }
        return string;
    }

    public static void main(String[] args) {

        int[] arr = cipher("world", 455);

        System.out.println(Arrays.toString(arr));

        String word = decipherByWordAndPin("Hello", 455, arr);

        System.out.println(word);

        String word1 = decipherByWordAndPin("Abracadabra", 455, arr);

        String word2 = decipherByNumber(455, arr);

        System.out.println(word2);

        String word4 = decipherByNumber(15, arr);

        System.out.println(word4);
    }
}
