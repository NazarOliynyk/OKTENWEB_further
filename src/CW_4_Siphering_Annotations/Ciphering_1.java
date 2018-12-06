package CW_4_Siphering_Annotations;

import java.util.Arrays;

/**
 * Created by okten26 on 12/5/18.
 */
public class Ciphering_1 {

    public static double[] cipher(String string, String code){

        char[] chars = string.toCharArray();

        char[] codeCh = code.toCharArray();

        double sum=0;

        for (char ch : codeCh) {
            sum+=(double) ch;
        }

        double pin = sum/codeCh.length;
        System.out.println("sum - "+sum);
        System.out.println("codeCh.length - "+codeCh.length);
        System.out.println("pin: "+pin);
        double[] cipheredChars = new double[chars.length];

        for (int i = 0; i < cipheredChars.length; i++) {
            cipheredChars[i] = (double) chars[i]*pin;

        }
        return cipheredChars;
    }

    public static String decipher(double[] cipher, String code){

        String string="";
        char[] codeCh = code.toCharArray();
        double sum=0;

        for (char ch : codeCh) {
            sum+=(double) ch;
        }

        double pin = sum/codeCh.length;
        //System.out.println("sum - "+sum);
        //System.out.println("codeCh.length - "+codeCh.length);
        //System.out.println("pin: "+pin);

        for (int i = 0; i < cipher.length; i++) {
            string+=(char)(cipher[i]/pin);

        }

        return string;
    }

    public static void main(String[] args) {

        double[] cipher = cipher("Hello", "TryToGuessWhatItIs");

        System.out.println(Arrays.toString(cipher));

        String string = decipher(cipher, "TryToGuessWhatItIs");

        System.out.println("string - "+string);

        System.out.println(decipher(cipher, "jdnckskvm"));

    }
}
