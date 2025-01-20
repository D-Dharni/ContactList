public class Teacher extends Person{
    private int salary;

    public Teacher (String firstName, String lastName, String phoneNumber, int salary) {
        super(firstName, lastName, phoneNumber);
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String toString() {
        return super.toString() + " Salary: " + salary;
    }
}
