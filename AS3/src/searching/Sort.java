package searching;

class Sort {
	int[] in;
	int[] temp;
	int[] index;
	int left;
	int right;
	public Sort(int[] k) {
		in=k;
		index= new int[in.length];
		for (int i =0;i<index.length;i++) {
		index[i]=i;
	    }
		temp = new int[in.length];
		right= in.length-1;
		left=0;
	} 
	
	
	
	public int[] insertionsort(int[] a) {
		int min=0;
		int index=0;
		int[] b= new int[a.length];
		for (int i= 0;i<a.length;i++) {
			
			for (int j=0; j<a.length;j++) {
				if (a[j] !=0) {
					if (min==0) {
						min=a[j];
						index=j;
					}
					if (a[j]<min) {
						min=a[j];
						index=j;
					}
				}
				
			}
		b[i]=index;
		a[index]=0;
		
		min =0;
		index=0;
		}
		return b;
	}
	
	public void mergesort(int[] in,int[] index,int[] temp,int left, int right) {
		
		if ((right-left+1)<=20) {
			int[] a= new int[right-left+1];
			int j=0;
			for (int i=left;i<=right;i++) {
				
				a[j++]=in[i];
			}
			int[] b=this.insertionsort(a);
			j=0;
			for (int i=left;i<=right;i++) {
				index[i]=b[j++]+left;
			}
			return;
		}
		
		int mid=(left+right)/2;
		if (left==right) {
			return;
		}
		mergesort(in,index,temp,left,mid);
		mergesort(in,index,temp,mid+1,right);
		for (int i=mid;i>=left;i--) {
			temp[i]= index[i];
		}
		for (int j=1;j<=right-mid;j++) {
			temp[right-j+1]=index[j+mid];
		}
		int i=left;
		int j=right;
		for (int k=left;k<=right;k++) {
			if (in[temp[i]]<in[temp[j]]) {
				index[k]=temp[i++];
			}
			else index[k]=temp[j--];
		}
		
	}
	
	
}
