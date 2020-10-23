package AS2;



public class BT_evaluation {
	
	public static void main(String argv[]) {
		stack BT= new stack(10);
		stack oprand= new stack(3);
		BinaryTree tree = new BinaryTree();

		 // create nodes of the tree
		tree.root = new BTnode('+');
		tree.root.left = new BTnode('*');
		tree.root.right = new BTnode('*');
		tree.root.left.left = new BTnode(2);
		tree.root.left.right= new BTnode('-');
		tree.root.right.left= new BTnode(3);
		tree.root.right.right=new BTnode(2);
		tree.root.left.right.left= new BTnode(5);
		tree.root.left.right.right= new BTnode(1);
		System.out.print("The tree is expressed as: ");
		tree.traverseTree_express(tree.root);
		System.out.print("\n");
		tree.traverseTree_compute(tree.root, BT);
		while (BT.isEmpty()==false) {
			Object out=BT.pop();
			
			if (out instanceof Integer) {
				oprand.push(out);
			}
			else if ((char)out=='+') {
				Object temp= oprand.pop();
				int a =Integer.valueOf(temp.toString());
				temp= oprand.pop();
				int b =Integer.valueOf(temp.toString());
				
				int result=a+b;
				oprand.push(result);
				
				System.out.println(a+" + "+b +" = "+ result);
			}
			else if ((char)out=='-') {
				Object temp= oprand.pop();
				int a =Integer.valueOf(temp.toString());
				temp= oprand.pop();
				int b =Integer.valueOf(temp.toString());
				int result=a-b;
				oprand.push(result);
				System.out.println(a+" - "+b +" = "+ result);
			}
			else  {
				Object temp= oprand.pop();
				int a =Integer.valueOf(temp.toString());
				temp= oprand.pop();
				int b =Integer.valueOf(temp.toString());
				int result=a*b;
				oprand.push(result);
				System.out.println(a+" * "+b +" = "+ result);
			}
		}
		System.out.println("result is "+ oprand.pop());
	}
}
