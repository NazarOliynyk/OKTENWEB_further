package CW_4_Siphering_Annotations;

import java.util.Arrays;

/**
 * Created by okten26 on 12/5/18.
 */
public class Ciphering_1 {

    public static double[] cipher(String string, String code){

        char[] chars = string.toCharArray();

        char[] codeCh = code.toCharArray();

        int sum=0;

        for (char ch : codeCh) {
            sum+=(int)ch;
        }

        double pin = sum/codeCh.length;

        System.out.println("pin: "+pin);
        double[] cipheredChars = new double[chars.length];

        for (int i = 0; i < cipheredChars.length; i++) {
            cipheredChars[i] = (int)chars[i]*pin;

        }
        return cipheredChars;
    }
//
//    public static String decipher(int[] cipher, String code){
//
//
//    }

    public static void main(String[] args) {

        double[] cipher = cipher("Hello", "TryToGuessWhatItIs");

        System.out.println(Arrays.toString(cipher));
    }
}
