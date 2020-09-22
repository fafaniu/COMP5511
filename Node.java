
public class Node {
		
		String element;
		Node next;
		
		public Node(String element){
			this(element,null);
		}
		
		
		public Node(String element,Node n){
			this.element=element;
			next=n;
		}
		
		public String getElement() {
			return element;
		}
		
	}

