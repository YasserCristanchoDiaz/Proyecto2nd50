package logic.model;

public abstract class Person {
    private String name;
    private String lastName;
    private int numberPhone;

    public Person(String name, String lastName, int numberPhone) {
        this.name = name;
        this.lastName = lastName;
        this.numberPhone = numberPhone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(int numberPhone) {
        this.numberPhone = numberPhone;
    }
}
