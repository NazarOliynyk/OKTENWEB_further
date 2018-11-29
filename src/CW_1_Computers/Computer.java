package CW_1_Computers;

/**
 * Created by okten29 on 11/28/18.
 */
public class Computer {

    private String model;
    private int year;
    private int memoryVolume;
    private int price;

    HardDrive hardDrive;
    Processor processor;

    public Computer(String model, int year, int memoryVolume, int price, HardDrive hardDrive, Processor processor) {
        this.model = model;
        this.year = year;
        this.memoryVolume = memoryVolume;
        this.price = price;
        this.hardDrive = hardDrive;
        this.processor = processor;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMemoryVolume() {
        return memoryVolume;
    }

    public void setMemoryVolume(int memoryVolume) {
        this.memoryVolume = memoryVolume;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public HardDrive getHardDrive() {
        return hardDrive;
    }

    public void setHardDrive(HardDrive hardDrive) {
        this.hardDrive = hardDrive;
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Computer computer = (Computer) o;

        if (year != computer.year) return false;
        if (memoryVolume != computer.memoryVolume) return false;
        if (price != computer.price) return false;
        if (model != null ? !model.equals(computer.model) : computer.model != null) return false;
        if (hardDrive != null ? !hardDrive.equals(computer.hardDrive) : computer.hardDrive != null) return false;
        return processor != null ? processor.equals(computer.processor) : computer.processor == null;

    }

    @Override
    public int hashCode() {
        int result = model != null ? model.hashCode() : 0;
        result = 31 * result + year;
        result = 31 * result + memoryVolume;
        result = 31 * result + price;
        result = 31 * result + (hardDrive != null ? hardDrive.hashCode() : 0);
        result = 31 * result + (processor != null ? processor.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "model='" + model + '\'' +
                ", year=" + year +
                ", memoryVolume=" + memoryVolume +
                ", price=" + price +
                ", hardDrive=" + hardDrive +
                ", processor=" + processor +
                '}';
    }
}
