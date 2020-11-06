package searching;

public class test {
	public static void main(String argv[]) {
		String line = "AAAAL,53.57,-66.47,,";
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
		System.out.println(sb);
	}
}
