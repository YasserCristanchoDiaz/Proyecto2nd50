package logic.model;

public class Client extends Person {
    private String address;

    public Client(String name, String lastName, int numberPhone, String address) {
        super(name, lastName, numberPhone);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name=" + getName() +
                ",lastName=" + getLastName() +
                ",numberPhone=" + getNumberPhone() +
                ",address='" + address + '\'' +
                '}';
    }

}
