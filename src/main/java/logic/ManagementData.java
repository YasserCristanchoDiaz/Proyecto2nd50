package logic;

import logic.model.Domicilier;
import logic.model.Order;
import logic.model.Product;
import persistence.FilePlain;

import java.time.LocalDate;
import java.util.ArrayList;

public class ManagementData {
    private ArrayList<Domicilier> domiciliers;
    private ArrayList<Product> products;
    private ArrayList<Order> orders;
    private ArrayList<Order> byDate;
    private FilePlain file;

    public ManagementData() {
        domiciliers = new ArrayList<>();
        products = new ArrayList<>();
        orders = new ArrayList<>();
        byDate = new ArrayList<>();
    }

    //--DOMICILIARIOS--------------------------------------------

    public ArrayList<Domicilier> getDomiciliers() {
        return (ArrayList<Domicilier>) domiciliers.clone();
    }

    public Domicilier findDomicilier(int id) {
        for (Domicilier d: domiciliers) {
            if ( d.getId() == id ) {
                return d;
            }
        }
        return null;
    }

    public boolean addDomicilier(Domicilier domicilier) {
        if( findDomicilier(domicilier.getId()) == null) {
            domiciliers.add(domicilier);
            return true;
        } else {
            return false;
        }
    }

    //--PRODUCTOS---------------------------------------------------------

    public ArrayList<Product> getProducts() {
        return (ArrayList<Product>) products.clone();
    }

    public Product findProduct(int reference) {
        for (Product p : products) {
            if (p.getReference() == reference) {
                return p;
            }
        }
        return null;
    }

    public boolean addProduct(Product product) {
        if ( findProduct(product.getReference()) == null ) {
            products.add(product);
            return true;
        } else {
            return false;
        }
    }

    //--ORDENES_DE_PEDIDO---------------------------------------------------

    public Order findOrder(int refOrder) {
        for ( Order ord : orders ) {
            if ( ord.getRefOrder() == refOrder ) {
                return ord;
            }
        }
        return null;
    }

    public boolean addOrder(Order order) {
        if ( findOrder(order.getRefOrder()) == null ) {
            orders.add(order);
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Order> getOrders() {
        return (ArrayList<Order>) orders.clone();
    }

    public ArrayList<Order> getByDate(LocalDate date) { //Para cuando se busca las ordenes de pedido segun la fecha
        for (Order ord : orders) {
            if ( ord.getDateOrder().equals( date ) ) {
                byDate.add(ord);
            }
        }
        return (ArrayList<Order>) byDate.clone();
    }

    public double gainByDate() {
        double totalGain = 0;
        for (Order ord : byDate) {
            totalGain += ord.gain();
        }
        return totalGain;
    }

}
