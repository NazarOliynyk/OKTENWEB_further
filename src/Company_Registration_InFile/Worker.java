package Company_Registration_InFile;

/**
 * Created by okten29 on 11/26/18.
 */
public class Worker {

    String name;
    int qualification;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQualification() {
        return qualification;
    }

    public void setQualification(int qualification) {
        this.qualification = qualification;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Worker worker = (Worker) o;

        if (qualification != worker.qualification) return false;
        return name != null ? name.equals(worker.name) : worker.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + qualification;
        return result;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", qualification=" + qualification +
                '}';
    }
}
