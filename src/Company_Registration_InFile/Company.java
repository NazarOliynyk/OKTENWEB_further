package Company_Registration_InFile;

import lombok.Data;

import java.util.TreeSet;

/**
 * Created by okten29 on 11/26/18.
 */

public class Company implements Comparable<Company>{

    String name;
    TreeSet<Department> departments;

    public Company() {
    }

    public Company(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TreeSet<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(TreeSet<Department> departments) {
        this.departments = departments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Company company = (Company) o;

        if (name != null ? !name.equals(company.name) : company.name != null) return false;
        return departments != null ? departments.equals(company.departments) : company.departments == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (departments != null ? departments.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", departments=" + departments +
                '}';
    }

    @Override
    public int compareTo(Company o) {
        return this.getName().compareTo(o.getName());
    }
}

