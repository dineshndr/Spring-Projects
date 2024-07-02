import java.util.ArrayList;
import java.util.List;

public class Employee {

    public String firstname;

    public int salary;

    public List<String> projects = new ArrayList<>();

    @Override
    public String toString() {
        return "Employee{" +
                "firstname='" + firstname + '\'' +
                ", salary=" + salary +
                ", projects=" + projects +
                '}';
    }

    public Employee(String firstname, int salary, List<String> projects) {
        this.firstname = firstname;
        this.salary = salary;
        this.projects = projects;
    }

    public Employee() {
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public List<String> getProjects() {
        return projects;
    }

    public void setProjects(List<String> projects) {
        this.projects = projects;
    }
}