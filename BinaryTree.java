package AS2;

//class to create nodes
class BTnode {
Object key;
BTnode left, right;

public BTnode(Object item) {
key = item;
left = right = null;
}
}

class BinaryTree {
BTnode root;

// Traverse tree
public void traverseTree_compute(BTnode node, stack BTtree) {
 if (node != null) {
   
   BTtree.push(node.key);
   traverseTree_compute(node.left,BTtree);
   traverseTree_compute(node.right,BTtree);
   
 }
}
public void traverseTree_express(BTnode node) {
	
	if (node != null) {
		   if (node.left != null) {
		     System.out.print('(');
		   }
		   
		   
		   
		   traverseTree_express(node.left);
		   System.out.print( node.key);
		   traverseTree_express(node.right);
		   
		   
		   
		   if (node.right != null) {
			     System.out.print(')');
			   }
		 }
}


}
