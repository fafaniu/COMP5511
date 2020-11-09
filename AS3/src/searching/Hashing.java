package searching;

import java.util.ArrayList;

class Hashing {
//M = 10000	
	private HashNode[] table = new HashNode[10000];
	private HashNode[] table1= new HashNode[10000];
	private int keyFunction1(String line) {
		int k=0,i=0;
		StringBuffer sb =new StringBuffer();
		while (k<4) {
			
			if (line.charAt(i)==',') {
				
					k++;
			}	
				
			if (line.charAt(i)!= ',' && k>=3) {
						sb.append(line.charAt(i));
			
			}
			i++;
		}
		String out = sb.toString();
		int key=out.hashCode()%10000;
		return key;
		
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

			hashkey = keyFunction1(k[i]);
			if (table1[hashkey]==null) {
				table1[hashkey]= new HashNode(keyFunction1(k[i]), i);
			}
			else {
				
				findempty(table1[hashkey], keyFunction1(k[i]) , i);
			}
		}
	}
//searching every record in a certain chain	
	public int[] searching(String k) {
		
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
	public String printout(int[] index, String[] input ) {
		String result="Retrieving with coordinates, find records:";
		if (index.length==0) {
			result="No record";
			return result;
		}
		else {
			
			for (int i=0; i<index.length;i++) {
				result=result+"\n"+input[index[i]];
				
			}
			return result;
		}
	}
}
