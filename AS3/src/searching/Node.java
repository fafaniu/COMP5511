package searching;



class Node {
	String key;
	int index;
	Node left, right;
	public Node(String item, int num) {
	key = item;
	index=num;
	left = right = null;
	}
	public Node() {
		key=null;
		index=0;
		left = right = null;
	}
}
