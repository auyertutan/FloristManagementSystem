package Model;

public class ReportNode {
    int orderId;
    Sale sale;

    ReportNode leftChild;
    ReportNode rightChild;

    public ReportNode(int orderId, Sale sale) {
        this.orderId = orderId;
        this.sale = sale;
        leftChild = null;
        rightChild = null;
    }

    public Sale getSale() {
        return sale;
    }

    @Override
    public String toString() {
        return  sale + "has a unique id " +  orderId;
    }
}
