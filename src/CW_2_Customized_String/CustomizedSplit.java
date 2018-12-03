package CW_2_Customized_String;

import java.util.Arrays;

public class CustomizedSplit {

    public static String[] splitCustom(String string, char divider){

        char [] chars = string.toCharArray();

        int length =0;
        for (int i = 0; i < chars.length; i++) {
            if((int)chars[i]==(int)divider){
                length++;
            }
        }

        int[] numbersSubarr = new int[length];
        int с=0;
        for (int i = 0; i < chars.length; i++) {
            if ((int)chars[i]==(int)divider){
                numbersSubarr[с]=i;
                с++;
            }
        }

        String [] strings = new String[length+1];
        for (int i = 0; i < strings.length; i++) {
            strings[i]=fillString(chars, numbersSubarr, i);
        }


        return strings;
    }

    public static String fillString(char[] chars, int[] subArr, int number){
        String string="";
        if(number==0){
            for (int i = 0; i < subArr[number]; i++) {
                string+=chars[i];
            }
        }
        else if (number==subArr.length){
            for (int i = subArr[number-1]; i < chars.length; i++) {
                string+=chars[i];
            }
        }else {
            for (int i = subArr[number-1]; i < subArr[number]; i++) {
                string+=chars[i];
            }
        }

        return string;
    }

    public static void main(String[] args) {

        String[] strings = splitCustom("Hello world from Okteweb", ' ');
        System.out.println(Arrays.toString(strings));

        String [] strings1 = splitCustom("ajvnkmjnck$kmvkmo;iwo-ik@mcmxaksadmacsk", 'm');
        System.out.println(Arrays.toString(strings1));
    }
}
