package CW_1_Computers;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by okten29 on 11/28/18.
 */
public class Main {

    static  String[] hdModels={"Seagate", "WD III", "Samsung", "Kingston", "Toshiba", "WD Red", "WD SATA", "HGST"};
   static String[] compModel={"Acer", "Apple", "HP", "Lenovo", "Dell", "Asus", "MSI", "Fujitsu", "Sony", "Samsung"};
   static Country[] countries = {Country.CHINA, Country.COREA, Country.INDIA, Country.USA};
   static Type[] types ={Type.HDD, Type.SSD};

    static Random random = new Random();

    public static ArrayList<Computer> addComputers(int quantity){
        ArrayList<Computer> computers = new ArrayList<>();


        for (int i = 0; i < quantity; i++) {

            Computer computer = new Computer(compModel[random.nextInt(10)],
                    random.nextInt(18)+2000, random.nextInt(4)*2+2, (random.nextInt(10)+10)*1000,
                    new HardDrive(hdModels[random.nextInt(8)], types[random.nextInt(2)],
                    random.nextInt(16)*100+100, countries[random.nextInt(4)]),
                    new Processor((random.nextInt(3)+1)*2, random.nextInt(4)+1, countries[random.nextInt(4)]));
            computers.add(computer);
         }

        return computers;
    }

    public static void main(String[] args) {

        ArrayList<Computer> computers = addComputers(20);

        for (Computer computer : computers) {
            System.out.println(computer);
        }
    }
}
