package Lecture1;

import java.io.File;
import java.util.Properties;

/**
 * Created by user on 28.11.18.
 */
public class IO_FromPcSystem {
    public static void main(String[] args) {
//        String javaHome = System.getProperty("PATH");
//        System.out.println(javaHome);

        Properties properties = System.getProperties();
        for (Object o : properties.keySet()) {
            System.out.println(o);
        }
        System.out.println("----------------------------");

        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("user.home"));

        System.out.println("----------------------------");

        File userDir = new File(System.getProperty("user.home"));
        System.out.println("userDir.isDirectory() "+userDir.isDirectory());
        System.out.println("userDir.isFile() "+userDir.isFile());

        System.out.println("----------------------------");

        File [] listFiles = userDir.listFiles();
        for (File listFile : listFiles) {
            if(listFile.isFile()){
                System.out.println("file - "+listFile.getName());
            }else {
                System.out.println("dir - "+listFile.getName());
            }
        }

        System.out.println("----------------------------");

        File debug = new File(System.getProperty("daemonprocess.txt"));
        System.out.println("debug.getAbsolutePath() -"+debug.getAbsolutePath());
    }
}
