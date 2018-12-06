package Lecture_3_Refl_Annot_Multithread_jwt;

public class Multithreading_1 {

    public static void main(String[] args) {

        System.out.println("start");

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("point");

            }
        });

        thread.start(); // without this point does not work at all
        // anyway point prints after end because it takes some time to create a new thread
        System.out.println("end");
    }
}
