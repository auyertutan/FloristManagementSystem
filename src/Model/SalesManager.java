package Model;

import java.util.ArrayList;

public class SalesManager {
    private ArrayList<Sale> sales;

    public SalesManager() {
        this.sales = new ArrayList<Sale>();
    }

    public void addSale(Sale sale) {
        this.sales.add(this.sales.size(), sale);
    }

    public ArrayList<Sale> getSales() {
        return this.sales;
    }
}
