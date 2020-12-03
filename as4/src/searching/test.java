package searching;

import java.io.BufferedReader;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class test {
	public static void main(String[] args)throws Exception {
		System.out.println("Program is loading, please wait the message (enter the name of geographic) pop out");
 		ArrayList<Index> Indexs = new ArrayList<>();
 		ArrayList<String> Indexss = new ArrayList<>();
 		String encoding="UTF-8"; 		
	    File file = new File("data/cgn_canada_csv_eng(unsorted).csv");
	    InputStreamReader read = new InputStreamReader(new FileInputStream(file),encoding);
	    BufferedReader br = new BufferedReader(read); 	    
	    String data; 
	    int j=0;
	    int m=0;
	    
	    
	    while ((data = br.readLine()) != null) {
	    	//Indexs.add(new Index(data));
	    	 
	    	String s = readname(data);
	    	//Indexss.add(s);
	    	String[] words = s.split(" ");
	
	    	for(int i=0; i<words.length; i++) {
	    		
	    		String word = words[i];
	    		
	    			if(word.equals("aux")|| word.equals("des") || word.equals("du")|| word.equals("la")|| word.equals("La")|| word.equals("sur")){
	    				// System.out.println("aux");
	    			}
	    			else if (Indexss.contains(word)) {
	    				
	    				int n = Indexss.indexOf(word);	
	    				 //System.out.println(word);
	    				Indexs.get(n).setID(data);
	    				Indexs.get(n).setName(data);
	    				Indexs.get(n).setLatitude(data);
	    				Indexs.get(n).setLongitude(data);
	    				Indexs.get(n).setrecord(j);  	    				
	    			}
	    			//else if (Indexss.contains(word)) {	    	    			}
	    			
	    			//if (Indexss.contains(words[i])) {}
	    			else {
	    			Indexss.add(word);
	    			Indexs.add(new Index(data, word,j));
	    			}
	    		}
	    	
	    	j++;
	    	
	    	
	    }
	    
	    
	   
	    
	
	    
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the name of geographic for the searching | For Exit: please enter 'n'");
		//String search = keyboard.nextLine();
		
	    while (true) {
	    	String search = keyboard.nextLine();
	    	
        	if (search.equals("n")) {
        		System.out.println("Program Exit"); 
        		break;
        	}
        	else {
        		
        		m = Indexss.indexOf(search);
        		/*for(int i = 0; i< Indexss.size(); i++) {
        			if (Indexss.contains(search)) {
        				m = i;
        			
        			}
        		} doesnot work well
        		*/
				System.out.println("Index of the Searching word" + m);
			    System.out.println("Geographic ID: " + Indexs.get(m).getID());
    	    	System.out.println("Geographic Name: " + Indexs.get(m).getName());
    	    	System.out.println("Latitude: " + Indexs.get(m).getLatitude());
    	    	System.out.println("Longitude: " + Indexs.get(m).getLongitude());
        		}
       
	    }
		
		
		
		/*
		int m = Indexss.indexOf(search);
		System.out.println(m);
		
	    System.out.println("Geographic ID: " + Indexs.get(m).getID());
    	System.out.println("Geographic Name: " + Indexs.get(m).getName());
    	System.out.println("Latitude: " + Indexs.get(m).getLatitude());
    	System.out.println("Longitude: " + Indexs.get(m).getLongitude());
		*/
		
		 
		  
}

public static String readname(String k) {
int j=0;
StringBuffer sb= new StringBuffer();

for (int i=0;i<k.length();i++) {
if (k.charAt(i)==',') {
	j++;
}
if (j>=3) {
	if (k.charAt(i)!=',') {
		sb.append(k.charAt(i));
	}
}
}
return sb.toString();
}
	    
	    
	    
	
}	    

class Index {
	
	public String Word;
	ArrayList<String> ID = new ArrayList<>();
	ArrayList<String> Latitude = new ArrayList<>();
	ArrayList<String> Longitude = new ArrayList<>();
	ArrayList<String> Name = new ArrayList<>();
	ArrayList<Integer> record = new ArrayList<>();
	
	
	
	public Index(String k, String x, int j) {
		ID.add(readid(k));
		Word = x;
		Name.add(readname(k));
		Latitude.add(readlatitude(k));
		Longitude.add(readlongitude(k));
		record.add(j);
	}
	
	
	/*
	
	public Index(String k) {
		this.ID = readid(k);
		this.Name = readname(k);
		this.Latitude = readlatitude(k);
		this.Longitude = readlongitude(k);				
	}
	
	
	
	public String getID(){
		return ID;
	}
	public String getName(){
		return Name;
	}
	public String getLatitude(){
		return Latitude;
	}
	public String getLongitude(){
		return Longitude;
	}
	*/
	public ArrayList<String> getID(){
		return ID;
	}
	public ArrayList<String> getName(){
		return Name;
	}
	public ArrayList<String> getLatitude(){
		return Latitude;
	}
	public ArrayList<String> getLongitude(){
		return Longitude;
		}
	public String getWord(){
		return Word;
		}
	
	public ArrayList<Integer> getrecord(){
			return record;
		}
	
	
	
	
	public void setID (String x) {	
		x = readid(x);
		ID.add(x);	
	}
	
	public void setLatitude (String x) {	
		x = readlatitude(x);
		Latitude.add(x);	
	}
	public void setLongitude (String x) {	
		x = readlongitude(x);
		Longitude.add(x);	
	}
	public void setName (String x) {	
		x = readname(x);
		Name.add(x);	
	}
	
	public void setrecord (int j) {	
		record.add(j);	
	}
			
	
	private String readid(String line) {
		int i=0;
		StringBuffer sb =new StringBuffer();
		while (line.charAt(i)!=','){
			sb.append(line.charAt(i));
			i++;
		}
		return sb.toString();
	}
	

	private String readname(String k) {
		int j=0;
		StringBuffer sb= new StringBuffer();
		
		for (int i=0;i<k.length();i++) {
			if (k.charAt(i)==',') {
				j++;
			}
			if (j>=3) {
				if (k.charAt(i)!=',') {
					sb.append(k.charAt(i));
				}
			}
		}
		return sb.toString();
	}
	
	
	
	
	
	
	
	
	
	private String readlatitude(String k) {
		int j=0;
		StringBuffer sb= new StringBuffer();
		
		for (int i=0;i<k.length();i++) {
			if (k.charAt(i)==',') {
				j++;
			}
			if (j==1) {
				if (k.charAt(i)!=',') {
					sb.append(k.charAt(i));
				}
			}
		}
		return sb.toString();
	}

	
	private String readlongitude(String k) {
		int j=0;
		StringBuffer sb= new StringBuffer();
		
		for (int i=0;i<k.length();i++) {
			if (k.charAt(i)==',') {
				j++;
			}
			if (j==2) {
				if (k.charAt(i)!=',') {
					sb.append(k.charAt(i));
				}
			}
		}
		return sb.toString();
	}
}
