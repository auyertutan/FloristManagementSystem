package Model;

public class Flower {
    private String name;
    private Double price;
    private Integer Stock;
    private Integer count;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return Stock;
    }

    public void setStock(Integer stock) {
        Stock = stock;
    }

    @Override
    public String toString() {
        return this.getName() + "(" + this.getPrice() + ")";
    }

    public void decreaseStock(Integer stock) {
        this.setStock(this.getStock() - stock);
    }

    public void increaseStock(Integer stock) {
        this.setStock(this.getStock() + stock);
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
