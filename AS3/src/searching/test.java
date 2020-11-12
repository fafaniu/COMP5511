package searching;

public class test {
	public static void main(String argv[]) {
		int k=0,i=0;
		StringBuffer sb =new StringBuffer();
		String line = "EPUUF,48.09,-66.12,Carleton-sur-Mer; Avignon,Quebec,Refuge faunique du Barachois-de-Carleton";
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
		
		int key=0;
		for (int j=0; j<out.length()-1;j++) {
			key=key+(int) out.charAt(j)*(int) Math.pow(31,out.length()-j-1);
		}
		System.out.println(Math.abs(out.hashCode()));
		System.out.println(key);
		
	}
}
