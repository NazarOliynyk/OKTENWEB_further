package CW_2_Customized_String;

public class IgnoreCase {

    public static int getCode(char a){
        int code=0;
       if (Character.isUpperCase(a)){
           code=(int)Character.toLowerCase(a);
       }else {
           code=(int)a;
       }
        return code;
    }

    public static boolean equalsIgnoreCase(String s1, String s2){
        char [] c1= s1.toCharArray();
        char [] c2= s2.toCharArray();

        boolean result =false;

        if(c1.length!=c2.length){
            result= false;
        }else {
            int[] arr1 = new int[c1.length];
            int[] arr2 = new int[c2.length];

            for (int i = 0; i < arr1.length; i++) {
                arr1[i] = getCode(c1[i]);
            }

            for (int i = 0; i < arr2.length; i++) {
                arr2[i] = getCode(c2[i]);
            }

            for (int i = 0; i < arr1.length; i++) {
               if (arr1[i]==arr2[i]){
                   result= true;
               }else {
                   result= false;
               }

            }
        }
        return result;
    }
    public static void main(String[] args) {

        System.out.println(equalsIgnoreCase("OKTENWEB", "oktenweb"));

        System.out.println(equalsIgnoreCase("ascjbkj", "knmk"));

        System.out.println(equalsIgnoreCase("uitytr", "fdhhho"));
    }
}
