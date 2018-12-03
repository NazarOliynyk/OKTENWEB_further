package CW_2_Customized_String;

public class CustomizedLength {

    public static int lengthOfArray(String string){
        String s = string+"#";
        char[] arr = s.toCharArray();
        int counter =0;
        while ((int) arr[counter]!=(int)'#'){
            counter++;
        }
        return counter;
    }

    public static void main(String[] args) {

        System.out.println(lengthOfArray("aSDN KMM kjsadk askm"));
    }
}
