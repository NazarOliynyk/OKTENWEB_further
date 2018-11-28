package IO_CollectionHandling;

/**
 * Created by user on 28.11.18.
 */
public class Worker {

    private int id;
    private String name;
    private double monthlyPayment;

    public Worker() {
    }

    public Worker(int id, String name, double monthlyPayment) {
        this.id = id;
        this.name = name;
        this.monthlyPayment = monthlyPayment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Worker worker = (Worker) o;

        if (id != worker.id) return false;
        if (Double.compare(worker.monthlyPayment, monthlyPayment) != 0) return false;
        return name != null ? name.equals(worker.name) : worker.name == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        temp = Double.doubleToLongBits(monthlyPayment);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", monthlyPayment=" + monthlyPayment +
                '}';
    }
}
