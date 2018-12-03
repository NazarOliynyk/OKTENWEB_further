package CW_2_Customized_String;

public class NumberOfCertainSymbols {

    public static int count(String string, char a) {
        int counter = 0;

        char[] chars = string.toCharArray();

        for (int j = 0; j < chars.length; j++) {

            if ((int)chars[j] == (int) a) {
                counter++;
            }
        }
        return counter;
    }
    public static void main(String[] args) {

        int c= count("Hello world from oktenweb", 'o');
        System.out.println(c);
        System.out.println(count("god bless quin and britain", 'i'));

    }
}
