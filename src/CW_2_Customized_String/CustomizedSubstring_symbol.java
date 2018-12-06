package CW_2_Customized_String;

public class CustomizedSubstring_symbol {

    public static String substringBySymbol(String string, String symbol){
        //String substring=null;
        String substring = string.substring(string.indexOf(symbol)+1, string.indexOf(symbol));
        return substring;
    }

    public static void main(String[] args) {

        String substring = substringBySymbol("cnsadk jnjd scn", " ");
        System.out.println(substring);
    }
}
