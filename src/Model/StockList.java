package Model;

public class StockList {
	StockNode head;
	StockNode tail;

	public StockList() {

		head = tail = null;

	}

	//MARK: Add item to the beggining of Linked List.
	public void addItemToTheBeggining(String name, int count) {

		head = new StockNode(name, count, head);

	}	

	public boolean deleteItemFromTheBeggining() {

		if (head != null) {
			head = head.getNextStockNode();
			return true;
		}else {
			return false;
		}

	}

	//MARK: Add item end of the Linked List.
	public void addItem(String name, int count) {

		StockNode stockNode = new StockNode();
		stockNode.setName(name);
		stockNode.setCount(count);
		stockNode.setNextStockNode(null);

		if (isLinkedListEmpty()) {
			head = stockNode;

		}else{

			StockNode traverser = head;
			while (traverser.nextStockNode != null) {
				traverser = traverser.getNextStockNode();
			}
			traverser.setNextStockNode(stockNode);
		}

	}

	//MARK: Delete last item of Linked List.
	public boolean removeLastElement() {

		if(isLinkedListEmpty()) {
			
			System.out.println("This list is empty.");
			return false;
		
		}else{
			
			if(head == tail) {
				head = tail = null;
				
			}else {
				
				StockNode traverser = head;
				while(traverser.nextStockNode.getNextStockNode() != null) {
					traverser = traverser.getNextStockNode();
					tail = traverser;
				}
				traverser.nextStockNode = null;
				
				
			}
		}
		return true;
	}

	//MARK: Display all of the data in Linked List.
	public StockNode[] getAll() {

		StockNode traverser = head;
		StockNode[] nodes = new StockNode[this.getSize()];

		int i = 0;
		while(traverser != null) {
			nodes[i] = traverser;
			System.out.println(traverser.getName());
			traverser = traverser.getNextStockNode();
			i ++;
		}

		return nodes;
	}

	//MARK: Get item count from Linked List.
	public int getSize() {

		int count = 0;
		StockNode traverser = head;

		while(traverser != null) {
			count++;
			traverser = traverser.getNextStockNode();
		}
		System.out.println("Bu listede " + count + " adet eleman var.");
		return count;

	}

	//MARK: Display whether Linked List is empty or not.
	public boolean isLinkedListEmpty() {

		if (head == null) {
			return true;
		}else {
			return false;
		}

	}
}
