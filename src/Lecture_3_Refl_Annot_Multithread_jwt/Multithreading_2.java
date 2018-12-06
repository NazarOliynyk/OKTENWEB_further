package Lecture_3_Refl_Annot_Multithread_jwt;

import java.util.Random;

public class Multithreading_2 {

    public static void checkTime(){
        long start = System.currentTimeMillis();

        int[] ints1= new int[1000000];
        for (int i = 0; i < ints1.length; i++) {
            ints1[i] = new Random().nextInt(100);
        }
        int[] ints2= new int[2000000];
        for (int i = 0; i < ints2.length; i++) {
            ints2[i] = new Random().nextInt(100);
        }
        int[] ints3= new int[3000000];
        for (int i = 0; i < ints3.length; i++) {
            ints3[i] = new Random().nextInt(100);
        }
        int[] ints4= new int[4000000];
        for (int i = 0; i < ints4.length; i++) {
            ints4[i] = new Random().nextInt(100);
        }

        long end = System.currentTimeMillis();

        System.out.println("end-start: "+ (end-start));


    }

    public static void main(String[] args) {
        //checkTime(); // it gives something around 13000


        // below described async way of 4 parallel threads
        Thread thread1 = new Thread(() -> {
            int[] ints1= new int[1000000];
            for (int i = 0; i < ints1.length; i++) {
                ints1[i] = new Random().nextInt(100);
            }
            System.out.println("end 1");
        });

        Thread thread2 = new Thread(() -> {
            int[] ints2= new int[2000000];
            for (int i = 0; i < ints2.length; i++) {
                ints2[i] = new Random().nextInt(100);
            }
            System.out.println("end 2");
        });

        Thread thread3 = new Thread(() -> {
            int[] ints3= new int[3000000];
            for (int i = 0; i < ints3.length; i++) {
                ints3[i] = new Random().nextInt(100);
            }
            System.out.println("end 3");
        });

        Thread thread4 = new Thread(() -> {
            int[] ints4= new int[4000000];
            for (int i = 0; i < ints4.length; i++) {
                ints4[i] = new Random().nextInt(100);
            }
            System.out.println("end 4");
        });

        // join() makes it sync

//        try {
//            thread1.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

            thread1.start();
            thread2.start();
            thread3.start();
            thread4.start(); // takes around 10000

        // not more than 4 threads per i core of your processor !!!
    }
}
