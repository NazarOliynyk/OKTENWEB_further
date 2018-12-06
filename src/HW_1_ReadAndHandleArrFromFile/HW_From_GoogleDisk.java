package HW_1_ReadAndHandleArrFromFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HW_From_GoogleDisk {

   static File file = new File("HW_From_GoogleDisk.txt");

    public static String fileReader(File file) throws FileNotFoundException, IOException{

        FileInputStream fileInputStream =
                new FileInputStream(file);
        byte[] bytes = new byte[fileInputStream.available()];
                        fileInputStream.read(bytes);
                        fileInputStream.close();
        return new String(bytes);
    }

    public static ArrayList<Subscriber> buildStaff(String string){

        ArrayList<Subscriber> subscribers = new ArrayList<>();
        String[] subsData = string.split(";");
        System.out.println(Arrays.toString(subsData));
        for (int i = 0; i < subsData.length; i++) {
            Subscriber subscriber = new Subscriber();
            String [] data = subsData[i].split(" ");
//            subscriber.builder()
//                    .id(Integer.parseInt(data[0]))
//                    .name(data[1])
//                    .surname(data[2])
//                    .icq(data[3])
//                    .email(data[4])
//                    .married(Boolean.getBoolean(data[5]))
//                    .build();
            subscriber.setId(Integer.parseInt(data[0]));
            subscriber.setName(data[1]);
            subscriber.setSurname(data[2]);
            subscriber.setIcq(data[3]);
            subscriber.setEmail(data[4]);
            subscriber.setMarried(Boolean.getBoolean(data[5]));
            subscribers.add(subscriber);
            System.out.println("data[0] "+data[0]+"data[1] "+data[1]);
        }

        return subscribers;
    }


    public static void main(String[] args) {

        ArrayList<Subscriber> subscribers = new ArrayList<>();

        try {
            System.out.println(fileReader(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            subscribers= buildStaff(fileReader(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
       // subscribers.stream().forEach(subscriber1 -> System.out.println(subscriber1));

        for (Subscriber subscriber : subscribers) {
            System.out.println(subscriber);
        }
        System.out.println("-------------------------------------------");
       // subscribers.stream().sorted().forEach(subscriber -> System.out.println(subscriber));

        Stream<Subscriber> stream = subscribers.stream();

        Stream<Subscriber> sortedStream = stream.sorted(new Comparator<Subscriber>() {
            @Override
            public int compare(Subscriber o1, Subscriber o2) {
                return o1.getSurname().compareTo(o2.getSurname());
            }
        });
        List<Subscriber> sorted = sortedStream.collect(Collectors.toList());

        System.out.println("-------------------------------------------");
        for (Subscriber subscriber : sorted) {
            System.out.println(subscriber);
        }
        System.out.println("-------------------------------------------");

        for (Subscriber subscriber : subscribers) {
            if(subscriber.getEmail().contains("gmail.com")){
                System.out.println("with gmail boxes: "+subscriber);
            }
        }
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder

    static class Subscriber implements Comparable<Subscriber>{

        private int id;
        private String name;
        private String surname;
        private String icq;
        private String email;
        private boolean married;

        @Override
        public int compareTo(Subscriber o) {
            return this.id-o.id;
        }
    }

}
