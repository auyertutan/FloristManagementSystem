package Model;

public class SelectedFlower {
    private Flower flower;
    private Integer count;

    public SelectedFlower(Flower flower) {
        this.flower = flower;
    }

    @Override
    public String toString() {
        return this.flower.getCount() + "x " + this.flower.getName() + " (" + this.flower.getPrice() + ")";
    }

    public Flower getFlower() {
        return flower;
    }
}
