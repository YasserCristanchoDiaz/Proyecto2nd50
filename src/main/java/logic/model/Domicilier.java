package logic.model;

public class Domicilier extends Person {
    private int id;
    private double salary;
    private int nOrders;
    private boolean bono;

    public Domicilier(String name, String lastName, int numberPhone, int id) {
        super(name, lastName, numberPhone);
        this.id = id;
        salary = 0;
        nOrders = 0;
        bono = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getnOrders() {
        return nOrders;
    }

    public boolean isBono() {
        return bono;
    }

    public void setBono(boolean bono) {
        this.bono = bono;
    }

    public void addOrder(double discOrder) {
        salary += discOrder;
        nOrders++;
    }

    public void newWorkingDay() {
        salary = 0;
        nOrders = 0;
        bono = false;
    }

    @Override
    public String toString() {
        return "Domicilier{" +
                "name=" + getName() +
                ",lastName=" + getLastName() +
                ",numberPhone=" + getNumberPhone() +
                ",id=" + id +
                ", salary=" + salary +
                ", nOrders=" + nOrders +
                ", bono=" + bono +
                '}';
    }


}
