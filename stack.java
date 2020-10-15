package AS2;

public class stack {
		Node header;
		int elementCount;
		int size;
		
		public stack(int Size) {
			header = null;
			elementCount=0;
			this.size=Size;
		}
		
		
		
		public boolean isFull() {
			if (elementCount == size) {
				return true;
			}
			return false;
		}
		
		public boolean isEmpty() {
			if (elementCount==0) {
				return true;
				
			}
			return false;
			
		}
		
		public void push(Object value) {
			if (this.isFull()) {
				throw new RuntimeException("Stack is full");
				
			}
			else {
				if (this.isEmpty()) {
			
					header= new Node(value);
					elementCount++;
				}
				else {
				header= new Node(value,header);
				elementCount++;
				}
		}
		}
		
		public Object  pop() {
			if (this.isEmpty()) {
				throw new RuntimeException("Stack is empty");
			}
			else {
				Object out=header.element;
				header=header.next;
				elementCount--;
				return out;
			}
		}
		
		public void print() {
			if (this.isEmpty()) {
				throw new RuntimeException("Stack is empty");
			}
			Node tempnode=header;
			
			while (tempnode.next != null) {
				System.out.print(tempnode.element + "\n");
				tempnode=tempnode.next;
			}
		}
}
		
		
		