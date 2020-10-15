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


}
