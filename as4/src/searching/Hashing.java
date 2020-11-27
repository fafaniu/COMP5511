package searching;

import java.util.ArrayList;

class Hashing {
//M = 10000	
	private HashNode[] table = new HashNode[10000];
	private HashNode[] table1= new HashNode[10000];
	private int hashlocation(String k) {
		int key=0;
		for (int j=0; j<k.length()-1;j++) {
			key=key+(int) k.charAt(j)*(int) Math.pow(31,k.length()-j-1);
		}
		return key;
	}
	private int keyFunction1(String line) {
		int k=0;
		StringBuffer sb =new StringBuffer();
		for (int i=0;i<line.length();i++) {
			if (line.charAt(i)==',') {
				k++;
			}
			if (k==3 && line.charAt(i)!=',') {
				sb.append(line.charAt(i));
			}
		}
		String out = sb.toString();
	
		return hashlocation(out);
		
	}
//having coordinate without '.' and '-'	
	private int keyFunction(String line) {
		int k=0,i=0;
		StringBuffer sb =new StringBuffer();
		while (k<3) {
			
			if (line.charAt(i)==',') {
				
					k++;
			}	
				
			if (line.charAt(i)!= ','&& line.charAt(i) != '.' && line.charAt(i) !='-' && k>=1) {
						sb.append(line.charAt(i));
			
			}
			i++;
		}
	
		
		int out =Integer.parseInt(sb.toString());
		
		return  out ;
	}
	
	
// putting record in certain chain	
	private void findempty(HashNode k, int item, int num) {
		if (k.next != null) {
			findempty(k.next, item, num);
		}
		else {
			k.next= new HashNode(item , num);
		}
	}
	
	public void establish_coordinate(String[] k) {
		int hashkey=-1;
		for (int i=0;i<k.length;i++) {
// h(key)= (coordinate without '.' and '-' /100)% 10000
			hashkey = (keyFunction(k[i])/100)%10000; 
			if (table[hashkey]==null) {
				table[hashkey]= new HashNode(keyFunction(k[i]), i);
			}
			else {
				
				findempty(table[hashkey], keyFunction(k[i]) , i);
			}
		}
	}
	public void establish_location(String[] k) {
		int hashkey=-1;
		for (int i=0;i<k.length;i++) {
			if (keyFunction1(k[i])==0) {
				continue;
			}
			else{
				hashkey = Math.abs(keyFunction1(k[i]))%10000;
			
				if (table1[hashkey]==null) {
					table1[hashkey]= new HashNode(keyFunction1(k[i]), i);
				}
				else {
				
					findempty(table1[hashkey], keyFunction1(k[i]) , i);
				}
			}
		}
	}
//searching every record in a certain chain	
	public int[] searching_coordinate (String k) {
		
		StringBuffer sb =new StringBuffer();
		for (int i=0; i< k.length();i++) {
			if (k.charAt(i)!=',' && k.charAt(i)!='.' && k.charAt(i)!='-') {
				sb.append(k.charAt(i));
			}
		}
		int f =Integer.parseInt(sb.toString());
		int hashkey=(f/100)%10000;
		ArrayList<Integer> index=new ArrayList<>();
		if (table[hashkey] != null) {
			HashNode temp = table[hashkey];
			while (temp.next != null) {
				if (temp.key == f ) {
					index.add(temp.index);
				}
				temp=temp.next;
			}
		}
		int[] result = new int[index.size()];
		for(int i =0; i< index.size(); i++) {
			result[i]=index.get(i);
		}
		return result;
		
	}
	
	public int[] searching_location (String k) {
		int hashkey=Math.abs(hashlocation(k))%10000;
		ArrayList<Integer> index =new ArrayList<>();
		if (table1[hashkey]!=null) {
			HashNode temp =table1[hashkey];
			while (temp.next != null) {
				if (temp.key == hashlocation(k) ) {
					index.add(temp.index);
				}
				temp=temp.next;
			}
			
		}
		int[] result = new int[index.size()];
		
		for(int i =0; i< index.size(); i++) {
			result[i]=index.get(i);
		}
		return result;
	}
	public String printout_coordinate(int[] index, String[] input ) {
		String result="\nRetrieving with coordinates, find records:";
		if (index.length==0) {
			result=result+"\nNo record\n";
			return result;
		}
		else {
			
			for (int i=0; i<index.length;i++) {
				result=result+"\n"+input[index[i]]+"\n";
				
			}
			return result;
		}
	}
	public String printout_location(int[] index, String[] input ) {
		String result="\nRetrieving with location, find records:";
		if (index.length==0) {
			result=result+"\nNo record\n";
			return result;
		}
		else {
			
			for (int i=0; i<index.length;i++) {
				result=result+"\n"+input[index[i]]+"\n";
				
			}
			return result;
		}
	}
}
