package searching;

public class test {
	public static void main(String argv[]) {
		String [] test= {"a,tom","b,bob","c,dog","d,cat","e,fish","f,bird","g,lily","i,kk","l,90"};
		BST tree = new BST();
		tree.establish(test);
		System.out.println(tree.root.left.key);
		System.out.println(tree.root.right.index);
	}
}
