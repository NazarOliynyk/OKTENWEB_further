package Lecture1;

/**
 * Created by user on 28.11.18.
 */
public class ExceptionHandling {

    public static void asd1(int a, int b){
        System.out.println("Start");
        try{
            System.out.println(a/b);
        }catch (ArithmeticException e){
            System.out.println("error "+e);
        }catch (Exception  e1){
            System.out.println("error "+e1);
        }

        System.out.println("End of method");
    }

    public static void asd2(int a, int b) throws ArithmeticException{
        System.out.println(a/b);
        System.out.println("End of method");
    }

    public static void asd3(int a, int b) throws ArithmeticException{

        if (b==0){
            throw new ArithmeticException();
        }

        // many rows of code go here
        System.out.println(a/b);
        System.out.println("End of method");
    }

    public static void main(String[] args) {
        asd1(10, 0);

        try {
            asd2(10, 0);
        } catch (ArithmeticException e) {
            System.out.println("error "+e);
            e.printStackTrace();
        }catch (Exception  e1){
            System.out.println("error "+e1);
        }

        try {
            asd3(10, 0);
        } catch (ArithmeticException e) {
            System.out.println("error "+e);
            e.printStackTrace();
        }catch (Exception  e1){
            System.out.println("error "+e1);
        }
    }
}
