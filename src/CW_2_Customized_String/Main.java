package CW_2_Customized_String;

import java.util.Arrays;

/**
 * Created by okten26 on 12/3/18.
 */
public class Main {
    //public static char[] r
    // t
    public static  int length(char[] chars){
        int length = 0;
        for (char aChar : chars) {
            while (aChar!='\u0000'){
                length++;
            }
        }

        return length;
    }

    public static char [] piece (char[] chars, int a, int b){
        int length = b-a;
        char [] piece = new char[length];

        for (int i = 0; i < piece.length; i++) {

               piece[i]=chars[a];
           a++;

        }

        return piece;
    }

    public static String [] splitString(char[] chars){
        String [] arr = null;

        int length = 0;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i]==' '){
                length++;
            }

        }

        return arr;
    }

    private static int countSymbol(String string, char a){
        int i=0;

        char[] chars = string.toCharArray();

        for (int j = 0; j < chars.length; j++) {
            if (chars[i]==a){
                i=i+1;
            }

        }

        return i;
    }

    public static void main(String[] args) {

        System.out.println("sdfgbgkf");
        String string = "abcdefghklmnop";
        char[] chars = string.toCharArray();
        System.out.println(string);

      //  int length = length(chars);

        System.out.println("sdfgbgkf");
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);

        }

        char[] piece = piece(chars, 3, 6);
        System.out.println("Arrays.toString(piece) - "+Arrays.toString(piece));

        System.out.println("-------------------");

        char [] arr;
        arr ="Hello world from Oktenweb".toCharArray();
        System.out.println(Arrays.toString(arr));

        int length =0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==' '){
                length++;
            }

        }
        System.out.println("length - "+length);

        int[] numbersSubarr = new int[length];

        int sa=0;
        for (int i = 0; i < arr.length; i++) {
           if (arr[i]==' '){
               numbersSubarr[sa]=i;
               sa++;
           }

        }

        System.out.println(Arrays.toString(numbersSubarr));
        String [] strings = new String[length+1];
        for (int i = 0; i < strings.length; i++) {
            strings[i]="";

        }

//        int st = 0;
//        for (int i = 0; i < arr.length; i++) {
//            strings[st] =
//
//        }
        for (int i = 0; i < numbersSubarr[0]; i++) {
            strings[0]+=arr[i];

        }
        System.out.println("strings[0] - "+strings[0]);

        for (int i = numbersSubarr[0]; i < numbersSubarr[1]; i++) {
            strings[1]+=arr[i];

        }
        System.out.println(Arrays.toString(strings));

        System.out.println(arr.length);

        for (int i = numbersSubarr[1]; i < numbersSubarr[2]; i++) {
            strings[2]+=arr[i];

        }
        System.out.println(Arrays.toString(strings));

        for (int i = numbersSubarr[2]; i < arr.length; i++) {
            strings[3]+=arr[i];

        }
        System.out.println(Arrays.toString(strings));

        System.out.println(countSymbol("Hello world from Oktenweb", 'o'));

        int counter=0;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i]=='o'){
                counter=counter+1;
            }
        }



        System.out.println(counter);
    }
}
