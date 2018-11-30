package Company_Registration_InFile;

import java.util.ArrayList;

/**
 * Created by okten29 on 11/26/18.
 */
public class Department implements Comparable<Department>{

    String name;
    ArrayList<Worker> workers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(ArrayList<Worker> workers) {
        this.workers = workers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Department that = (Department) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return workers != null ? workers.equals(that.workers) : that.workers == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (workers != null ? workers.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", workers=" + workers +
                '}';
    }

    @Override
    public int compareTo(Department o) {
        return this.getName().compareTo(o.getName());
    }

}
