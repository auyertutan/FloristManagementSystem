package Model;

public class StockNode {
	
	String name;
	int count;
	StockNode nextStockNode;
	
	
	public StockNode(String name, int count, StockNode nextStockNode) {
		this.name = name;
		this.count = count;
		this.nextStockNode = nextStockNode;
	}
	
	public StockNode() {
		name = null;
		nextStockNode = null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public StockNode getNextStockNode() {
		return nextStockNode;
	}

	public void setNextStockNode(StockNode nextStockNode) {
		this.nextStockNode = nextStockNode;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getCount() {
		return count;
	}
}
