package test;

public class singly_list {
	Node header;
	int size;
	int count=0;
	public singly_list() {
		header=null;
		this.size=0;
	}
	public void input(int k) {
		if (this.size==0) {
			header =new Node(k);
		}
		header= new Node(k,header);
		this.size++;
	}
	public singly_list remove(singly_list k) {
		k.header = k.header.next;
		return k ;
	}
	public  static int count_It(singly_list k) {
		Node temp=k.header;
		while (temp.next != null) {
			System.out.println(temp.element);
			temp=temp.next;
			
			k.count++;
			
		}
		return k.count;
	}
	
	public static int count_Re(singly_list k) {
		
		
		if (k.header.next != null){
			return count_Re(k.remove(k))+1;
		}
		return 0;
	}
	
	public static void main(String argv[]) {
		singly_list a = new singly_list();
		for (int i=0; i<10 ; i++) {
			a.input(i);
		}
		System.out.println(count_Re(a));
	}
	
	
	
	}

