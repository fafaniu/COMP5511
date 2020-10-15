package AS2;

public class Node {
		
		Object element;
		Node next;
		
		public Node(Object element){
			this(element,null);
		}
		
		
		public Node(Object element,Node n){
			this.element=element;
			next=n;
		}
		
	}

