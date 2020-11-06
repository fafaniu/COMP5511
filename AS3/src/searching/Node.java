package searching;



class TreeNode {
	String key;
	int index;
	TreeNode left, right;
	public TreeNode(String item, int num) {
		key = item;
		index=num;
		left = right = null;
	}
	public TreeNode() {
		key=null;
		index=0;
		left = right = null;
	}
}

class HashNode{
	int  key;
	int index;
	HashNode next;
	public HashNode(int item, int num) {
		key=item;
		index=num;
		next =null;
	}
}