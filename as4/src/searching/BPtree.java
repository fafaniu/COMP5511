package searching;


	class InternalNode{
	 	//key number
	 	public int num;
	 	//key 
	 	public int[] key;
		//children nodes
	 	public Object[] child;
	 	//parent nodes
	 	public InternalNode parent;
	 	
	 	public InternalNode(int k) {
	 		key=new int[k];
	 		child=new Object[k+1];
	 	}
	 	
	 }

	class LeafNode{
	 	//key number
	 	public int num;

	 	public int[] key;

	 	public int[] data;

	 	public InternalNode parent;
	 	//pointer to next leaf node
	 	public LeafNode nextLeaf;
	 	
	 	public LeafNode(int k) {
	 		key= new int[k];
	 		data=new int[k];
	 		for (int i=0;i<data.length;i++) {
	 			data[i]=-1;
	 		}
	 	}

	}	

	 class BPtree {
		int order;
		int max;
		int min;
		Object root;
		int size=0;
		public BPtree(int k){
			order=k;
			max=order;
			min=order/2+1;
		}
		
		private LeafNode locateData(Object root,int key,int data) {
	  	

	  	InternalNode iNode = null;
	  	LeafNode lNode = null;
	  	if(root instanceof InternalNode) {
	   		
	   		iNode = (InternalNode)root;
	   		//find key's location
	   		int locate = 0;
	   		for(; locate<iNode.num; locate++) {
	    			if(key < iNode.key[locate]) {
	     				break;
	    			}
	   		}
	   		return locateData(iNode.child[locate], key ,data);
	  	}else if(root instanceof LeafNode) {
	   	
	   		lNode = (LeafNode)root;
	   		//find data's location
	   		int locate = 0;
	   		for(; locate<lNode.num; locate++) {
	    			if(key < lNode.key[locate]) {
	    				break;
	    			}
	   		}
	        //insert new data
	   		for(int j=lNode.num-1; j>= locate; j--) {
	    			lNode.key[j+1] = lNode.key[j];
	    			lNode.data[j+1]=lNode.data[j];
	  		}
	   		
	   		lNode.key[locate] = key;
	   		lNode.data[locate]= data;
	   		lNode.num++;
	   		size++;
	   		return lNode;
	  	}
	  	return null;
	 }

		private void spiltIndexNode(InternalNode iNode) {
	   	int spiltLocate = iNode.num/2;
	   	int valueIndex = iNode.key[spiltLocate];
	   	InternalNode parent = iNode.parent;
	   	//splitting to root
	   	if(parent == null) {
	    		parent = new InternalNode(max+1);
	    		this.root = parent;
	    		//System.out.print("\t层数加一");
	   	}
	 
	   	InternalNode newInNode = new InternalNode(max+1);
	   	//original node have ceiling of order/2 keys
	   	int insert = 0;
	   	for(int i = spiltLocate+1; i < iNode.num; i++) {
	    		newInNode.key[insert] = iNode.key[i];
	    		iNode.key[i] = 0;
	    		newInNode.child[insert] = iNode.child[i];
	    		iNode.child[i] = null;
	    	
	    		if(newInNode.child[insert] instanceof LeafNode) {
	     			LeafNode midNode = (LeafNode)newInNode.child[insert];
	     			midNode.parent = newInNode;
	    		}else {
	     			InternalNode midNode = (InternalNode)newInNode.child[insert];
	     			midNode.parent = newInNode;
	    		}
	    		insert++;
	   	}
	   	newInNode.child[insert] = iNode.child[iNode.num];
	   	if(newInNode.child[insert] instanceof LeafNode) {
	    		LeafNode midNode = (LeafNode)newInNode.child[insert];
	    		midNode.parent = newInNode;
	   	}else {
	    		InternalNode midNode = (InternalNode)newInNode.child[insert];
	    		midNode.parent = newInNode;
	   	}
	   	iNode.child[iNode.num] = null;
	   	//delete key which is increased to parent
	   	iNode.key[spiltLocate] = 0;
	   	newInNode.num = insert;
	   	iNode.num = spiltLocate;
	   	newInNode.parent = parent;
	   	iNode.parent = parent;
	   	//locate in parent node
	   	int parLocate = 0;
	   	for(; parLocate < parent.num; parLocate++) {
	   		 if(valueIndex < parent.key[parLocate]) {
	     			break;
	    		}
	   	}
	   	//adjust parent node
	   	for(int i = parent.num-1; i >= parLocate; i--) {
	    		parent.key[i+1] = parent.key[i];
	    		parent.child[i+2] = parent.child[i+1];
	   	}

	   	parent.key[parLocate] = valueIndex;
	   	parent.child[parLocate] = iNode;
	   	parent.child[parLocate+1] = newInNode;
	   	parent.num++;
	  	//exam overflow of parent node
	  	if(parent.num > max) {
	   		//System.out.print("\t再次分裂");
	   		spiltIndexNode(parent);
	  	}
	  }
	private void spiltLeafNode(LeafNode lNode) {
	  	int spiltLocate = (int) Math.ceil((lNode.num/2));
	  	int valueIndex = lNode.key[spiltLocate];
	  	InternalNode parent = lNode.parent;
	  	//height+1
	  	if(parent == null) {
	   		parent = new InternalNode(max+1);
	   		this.root = parent;
	   		//System.out.print("\t层数加一");
	  	}
	  	//splitting node into 2 nodes
	  	LeafNode newlNode = new LeafNode(max+1);
	  	int insert = 0;
	  	for(int i = spiltLocate; i < lNode.num; i++) {
	   		newlNode.key[insert] = lNode.key[i];
	   		lNode.key[i] = 0;
	   		newlNode.data[insert] = lNode.data[i];
	   		lNode.data[i] = -1;
	   		insert++;
	  	}
	  	//update  
	  	lNode.num = spiltLocate;
	  	newlNode.num = insert;
	  	lNode.parent = parent;
	  	newlNode.parent = parent;
	  	
	  	newlNode.nextLeaf = lNode.nextLeaf;
	  	lNode.nextLeaf = newlNode;
	  
	  	
	  	int parlocate = 0;
	  	for(; parlocate < parent.num; parlocate++) {
	   		if(valueIndex < parent.key[parlocate]) {
	    			break;
	   		}
	 	}
	  	
	  	for(int i=parent.num-1; i >= parlocate; i--) {
	   		parent.key[i+1] = parent.key[i];
	   		parent.child[i+2] = parent.child[i+1];
	  	}
	 	
	  	parent.key[parlocate] = valueIndex;
	  	parent.num++;
	  	parent.child[parlocate] = lNode;
	  	parent.child[parlocate+1] = newlNode;
	  	//exam overflow of parent node
	  	if(parent.num > this.max) {
	   		//System.out.print("\t再次分裂");
	   		spiltIndexNode(parent);
	  	}
	  
	  }

	 public void CreateBPtree(int[] k) {
		 this.root=new LeafNode(max+1);
		 for (int i=0;i<k.length;i++) {
			 LeafNode addNode = this.locateData(this.root, k[i],i);
			 if(addNode != null && addNode.num > this.max) {
					//System.out.print("加入"+k[i]+"时，溢出需要分裂");
					spiltLeafNode(addNode);
					//System.out.println();
				}
		 }
		 /* //test
		 InternalNode root= (InternalNode)this.root;
		 Object move = root.child[0];
		 while(move != null) {
		   		if( move instanceof InternalNode) {
		    			InternalNode iNode = (InternalNode)move;
		    			move = iNode.child[0];
		   		}else {
		    			break;
		   		}
		 	}
		  	LeafNode lNode = (LeafNode)move;
		  	while(lNode != null) {
		   		for(int i=0; i< lNode.num; i++) {
		    			System.out.print(lNode.key[i]+" ");
		   		}
		   		lNode = lNode.nextLeaf;
		  	}
	*/
	 }
	public int[] keyFunction(String[] k) {
		int[] coordinate= new int[k.length];
        for (int i=0;i<k.length;i++) {
        	int s=0,j=0;
    		StringBuffer sb =new StringBuffer();
    		while (s<3) {
    			
    			if (k[i].charAt(j)==',') {
    				
    					s++;
    			}	
    				
    			if (k[i].charAt(j)!= ','&& k[i].charAt(j) != '.' && k[i].charAt(j) !='-' && s>=1) {
    						sb.append(k[i].charAt(j));
    			
    			}
    			j++;
    		}
    	
    		
    		coordinate[i]=Integer.parseInt(sb.toString());
        }
        return coordinate;
	}
	public int[] search(String a) {
		int[] result= new int[max];
		
		StringBuffer sb=new StringBuffer();
		for (int i=0; i< a.length();i++) {
			if (a.charAt(i)!=',' && a.charAt(i)!='.' && a.charAt(i)!='-') {
				sb.append(a.charAt(i));
			}
		}
		int key= Integer.parseInt(sb.toString());
		Object temp=this.root; 
		while (temp instanceof InternalNode) {
			InternalNode temp1=(InternalNode) temp;
			int location=0;
			for (int i=0;i< temp1.num;i++) {
				if (temp1.key[i]>key) {
					location=i;
					break;
				}
				if (i==(temp1.num)-1) {
					location=temp1.num;
				}
			}
			temp=temp1.child[location];
		}
		LeafNode temp2=(LeafNode) temp;
		for (int i=0;i<result.length;i++) {
				result[i]=-1;
			}
		for (int i=0;i<temp2.num;i++) {
			if (temp2.key[i]==key) {
				result[i]=temp2.data[i];
				
			}
			
		}
		
		return result;
		
	}
}


