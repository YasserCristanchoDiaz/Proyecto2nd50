package logic.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Order {
    private int refOrder;
    private Client client;
    private Domicilier domicilier;
    private LocalDate dateOrder;
    private ArrayList<Product> productsClient;
    private double subTotal;
    private double dis_10;
    private double dis_20;
    private double total;
    private static double DISCOUNT_10 = 0.1;
    private static double DISCOUNT_20 = 0.2;

    public Order(int refOrder, Client client, Domicilier domicilier) {
        this.refOrder = refOrder;
        this.client = client;
        this.domicilier = domicilier;
        dateOrder = LocalDate.now();
        productsClient = new ArrayList<>();
    }

    public int getRefOrder() {
        return refOrder;
    }

    public void setRefOrder(int refOrder) {
        this.refOrder = refOrder;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Domicilier getDomicilier() {
        return domicilier;
    }

    public void setDomicilier(Domicilier domicilier) {
        this.domicilier = domicilier;
    }

    public LocalDate getDateOrder() {
        return dateOrder;
    }

    public ArrayList<Product> getProductsClient() {
        return (ArrayList<Product>) productsClient.clone();
    }

    public double getSubTotal() {
        subTotal = 0;
        for (int i = 0; i < productsClient.size(); i++) {
            subTotal += productsClient.get(i).costCant();
        }
        return subTotal;
    }

    public double getDis_10() {
        dis_10 = (subTotal * DISCOUNT_10);
        return dis_10;
    }

    public double getDis_20() {
        dis_20 = (subTotal * DISCOUNT_20);
        return dis_20;
    }

    public double getTotal() {
        total = ( getSubTotal() + getDis_10() + getDis_20() );
        return total;
    }

    public double gain() {
        return ( getTotal() + getDis_10() );
    }
}
