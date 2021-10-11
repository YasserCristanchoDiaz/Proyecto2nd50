package logic.model;

public class Product {
    private int reference;
    private String description;
    private double value;
    private int cant;

    public Product(int reference, String description, double value) {
        this.reference = reference;
        this.description = description;
        this.value = value;
        cant = 1;
    }

    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public double costCant() {
        return value * cant;
    }

    @Override
    public String toString() {
        return "Product{" +
                "reference=" + reference +
                ", description='" + description + '\'' +
                ", value=" + value +
                ", cant=" + cant +
                ", costCant=" + costCant() +
                '}';
    }
}
