package Lecture1;

/**
 * Created by user on 28.11.18.
 */
public class AnonymousClasses {
    public static void main(String[] args) {

        SomeInterface someInterface = new SomeInterface() {
            @Override
            public void doSome() {
                System.out.println("Hello from doSome()");
            }
        };

       // SomeInterface lambdaVersion = ()->{System.out.println("Hello from doSome()"); }

        xxx(new SomeInterface() {
            @Override
            public void doSome() {
                System.out.println("Hello from doSome()");
            }
        });

       // xxx(()->{System.out.println("Hello from doSome()");});


    }

    public static void xxx(SomeInterface someInterface){
        someInterface.doSome();
    }
}

interface SomeInterface{

    void doSome();
}