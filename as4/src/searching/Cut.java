package searching;

class Cut{
	public static String ID(String k) {
		StringBuffer sb= new StringBuffer();
		for (int i=0;i<k.length();i++) {
			if (k.charAt(i)!= ',') {
				sb.append(k.charAt(i));
			}
			else{
				break;
			}
		}
		return sb.toString();
	}
	
	public static String Latitude(String k) {
		StringBuffer sb = new StringBuffer();
		int j=0;
		for (int i=0;i<k.length();i++) {
			if (k.charAt(i)==',') {
				j++;
			}
			if (j==1 && k.charAt(i)!=',') {
				sb.append(k.charAt(i));
			}
			if (j>1) {
				break;
			}
		}
		return sb.toString();
	}
	
	public static String Longitude(String k) {
		StringBuffer sb = new StringBuffer();
		int j=0;
		for (int i=0;i<k.length();i++) {
			if (k.charAt(i)==',') {
				j++;
			}
			if (j==2 && k.charAt(i)!=',') {
				sb.append(k.charAt(i));
			}
			if (j>2) {
				break;
			}
		}
		return sb.toString();
	}
	
	public static String GeoName(String k) {
		StringBuffer sb = new StringBuffer();
		int j=0;
		for (int i=0;i<k.length();i++) {
			if (k.charAt(i)==',') {
				j++;
			}
			if (j==3 && k.charAt(i)!=',') {
				sb.append(k.charAt(i));
			}
		}
		return sb.toString();
	}
}
