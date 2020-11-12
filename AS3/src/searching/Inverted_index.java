package searching;

import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class Inverted_index {
	Index aux =new Index("aux");
	Index des =new Index("des");
	Index du  =new Index("du");
	Index of  =new Index("of");
	Index la  =new Index("la");
	Index sur =new Index("sur");
	String[] words= {"aux","des","du","of","la","sur"};
	private String readname(String k) {
		int j=0;
		StringBuffer sb= new StringBuffer();
		
		for (int i=0;i<k.length();i++) {
			if (k.charAt(i)==',') {
				j++;
			}
			if (j>=4) {
				if (k.charAt(i)!=',') {
					sb.append(k.charAt(i));
				}
			}
		}
		return sb.toString();
	}
	public void establish(String[] k) {
		for (int i=0; i<k.length;i++) {
			String line=k[i];
			String name=readname(line);
			if ( name.contains(" aux ")) {
				aux.freq++;
				aux.record.add(i);
			}
			if ( name.contains(" des ")) {
				des.freq++;
				des.record.add(i);
			}
			if ( name.contains(" du ")) {
				du.freq++;
				du.record.add(i);
			}
			if ( name.contains(" of ")) {
				of.freq++;
				of.record.add(i);
			}
			if ( name.contains(" la ") | name.contains("La ")) {
				la.freq++;
				la.record.add(i);
			}
			if ( name.contains(" sur ")) {
				sur.freq++;
				sur.record.add(i);
			}
			
		}
		
	}
	public void printindex(String[] k) {
		 try {
			 File outFile = new File("/Users/xietianhao/eclipse-workspace/AS3/src/searching/inverted_index.txt");
			 if (!outFile.exists()) {
				 outFile.createNewFile();
			 }
			 BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
			 writer.write("aux Frequence = "+ aux.freq+"\n");
			 writer.write("\ndes Frequence = "+ des.freq+"\n");
			 writer.write("\ndu Frequence = "+ du.freq+"\n");
			 writer.write("\nof Frequence = "+ of.freq+"\n");
			 writer.write("\nla Frequence = "+ la.freq+"\n");
			 writer.write("\nsur Frequence = "+ sur.freq+"\n");
			 writer.write("aux:\n ");
			 
			 for (int i=0;i< aux.record.size();i++) {
				 writer.write(k[aux.record.get(i)]+"\n");
			 }
			 
			 
			 writer.write("des:\n ");
			 
			 for (int i=0;i< des.record.size();i++) {
				 writer.write(k[des.record.get(i)]+"\n");
			 }
			 
			 
			 writer.write("du:\n ");
			 
			 for (int i=0;i< du.record.size();i++) {
				 writer.write(k[du.record.get(i)]+"\n");
			 }
			 
			 
			 writer.write("of:\n ");
			 
			 for (int i=0;i< of.record.size();i++) {
				 writer.write(k[of.record.get(i)]+"\n");
			 }
			 
			 
			 writer.write("la:\n ");
			 
			 for (int i=0;i< la.record.size();i++) {
				 writer.write(k[la.record.get(i)]+"\n");
			 }
			 
			 
			 writer.write("sur:\n ");
			 
			 for (int i=0;i< sur.record.size();i++) {
				 writer.write(k[sur.record.get(i)]+"\n");
			 }
			 
			 writer.close();
		 }
		 catch (IOException ex) {
	            System.out.println("error");
	        }
	}
	
}	
class Index{
	public int freq;
	public String word;
	public Index(String k) {
		freq=0;
		word=k;
	}
	ArrayList<Integer> record = new ArrayList<>();
	
	
}