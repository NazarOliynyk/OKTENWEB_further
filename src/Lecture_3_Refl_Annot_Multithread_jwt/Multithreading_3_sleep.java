package Lecture_3_Refl_Annot_Multithread_jwt;

public class Multithreading_3_sleep {

    public static void main(String[] args) throws InterruptedException{

        System.out.println("start");
        Thread.sleep(2000); // works on our psvm
        System.out.println("end");

        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getId());
        System.out.println(Thread.currentThread().getPriority()); // default 5

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName("JHBSAHJB");
                System.out.println(Thread.currentThread().getName());
            }
        });
        thread2.start();
    }
}
