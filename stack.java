
public class stack {
		Node header;
		int elementCount;
		int size;
		
		public stack(int Size) {
			header = null;
			elementCount=0;
			this.size=Size;
		}
		
		public void setHeader(String first) {
			header = new Node(first);
			elementCount++;
	
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
		
		public void push(String value) {
			if (this.isFull()) {
				throw new RuntimeException("Stack is full");
				
			}
			else {
				if (this.isEmpty()) {
			
					this.setHeader(value);
				}
				else {
				header= new Node(value,header);
				elementCount++;
				}
		}
		}
		
		public String  pop() {
			if (this.isEmpty()) {
				throw new RuntimeException("Stack is empty");
			}
			else {
				String out=header.getElement();
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
		
		
		