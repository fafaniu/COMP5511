package searching;


class BST {
	private String[] input = null;
	TreeNode root = new TreeNode();
	int size=0;
//having ID in input string	
	private String read(String line) {
		int i=0;
		StringBuffer sb =new StringBuffer();
		while (line.charAt(i)!=','){
			sb.append(line.charAt(i));
			i++;
		}
		return sb.toString();
	}
	
	public int searching(String k) {
		TreeNode temp = root;
		while(true) {
			
		
			if (k.equals(temp.key)) {
				return temp.index;
			}
		
			else {
				if (k.compareTo(temp.key)<0) {
			
					if (temp.left==null) {
						return -1;

				
				}
				else{
					temp=temp.left;
				}	
			}
				if (k.compareTo(temp.key)>0) {
					if (temp.right==null) {
						return -1;
				
					}
				else{
					temp=temp.right;
				}	
			
			}
			}
		}
	}
	private void insert(TreeNode node,String k , int num) {
		
			
			
				if (k.compareTo(node.key)<0) {
					if (node.left==null) {
						node.left= new TreeNode(k,num);
						size++;
						
					}
					else{
						insert(node.left, k, num);
					}
				}
				if (k.compareTo(node.key)>0) {
					if (node.right==null) {
						node.right= new TreeNode(k,num);
						size++;
						
					}
					else{
						insert(node.right, k, num);;
					}
				if (k.equals(node.key)) {
					return;
				}
				
			}
	}
	
	public void establish(String[] a) {
		input = a;
		int mid=(input.length-1)/2;
		
		root.key=this.read(input[mid]);
		root.index=mid;
		size++;
		String insertion;
		int index;
		
		
		
		
		
		for (int height =1; height<Math.log(input.length)/Math.log(2); height++) {
			int k =1;
			for (int i=0;i<Math.pow(2, height);i++) {
				
				index=(int)((k/Math.pow(2, height+1))*(input.length));
				insertion=this.read(input[index]);
				this.insert(root,insertion, index);
				
				k+=2;
			}
			
			
		}
		
	}
	public String printout(int out, String[] a) {
		String result;
		if (out==-1) {
        	result="No record\n";
        	return result;
        }
        else {
        	result="Retrieving with the CGNDB ID, find records:\n"+a[out]+"\n";
        	return result;
        }
	}
	
	
}


