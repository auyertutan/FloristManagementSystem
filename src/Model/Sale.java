package Model;

import java.util.Arrays;
import java.util.Date;

public class Sale {
    private Customer customer;
    private Flower[] flowers;
    private int orderId;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Flower[] getFlowers() {
        return flowers;
    }

    public void setFlowers(Flower[] flowers) {
        this.flowers = flowers;
    }

    @Override
    public String toString() {
        String flowersString = "";
        for (int i = 0; i < this.getFlowers().length; i ++) {
            Flower flower = this.getFlowers()[i];
            Double price = flower.getPrice() * flower.getCount();
            flowersString += flower.getCount() + "x " + flower.getName() + ", ";
        }
        return "#" + this.getOrderId() + " Flowers: " + flowersString + "Customer: " + customer.getName() + " / " + customer.getPhone() + " / " + customer.getAddress();
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId() {
        Date date = new Date();
        this.orderId = (int) (new Date().getTime()/1000);
    }
}
