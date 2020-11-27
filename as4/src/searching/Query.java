package searching;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Query {
	public static void main(String[] argv){
        File DataFile = new File("data/cgn_canada_csv_eng(unsorted).csv");  
        File queryFile = new File("/Users/xietianhao/eclipse-workspace/as4/data/query.txt");
        File outFile = new File("data/searchingresult.txt");
        String DataString = "";
        String QueryString = "";
        String query1="What is at latitude and longitude:";
        String query2="Find the details of:";
        String query3="Find all:";
        
        ArrayList<String> data= new ArrayList<>();
        
        try {
            BufferedReader DataReader = new BufferedReader(new FileReader(DataFile));
            BufferedReader QueryReader = new BufferedReader(new FileReader(queryFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
            if (!outFile.exists()) {
				 outFile.createNewFile();
			 }
            while((DataString = DataReader.readLine())!= null){
                data.add(DataString);
            }
            DataReader.close();
            int dataSize=data.size();
            String[] a= (String[]) data.toArray(new String[dataSize]);
            String[] ID= new String[a.length];
            for (int i=0;i<a.length;i++) {
            	ID[i]=Cut.ID(a[i]);
            }
            Sort sid=new Sort(ID);
            sid.mergesort(sid.in, sid.index, sid.temp, sid.left, sid.right);
            
            while((QueryString=QueryReader.readLine())!= null ){
            	StringBuffer sb =new StringBuffer();
            	//retrieving with coordinate(B+ tree)
            	if (QueryString.startsWith(query1)) {
            		for (int i= query1.length();i<QueryString.length();i++) {
            			
            			sb.append(QueryString.charAt(i));
            			
            		}
            		writer.write("\nWhat is at coorditate "+ sb.toString()+"\nOutput:\n");
            		BPtree bp=new BPtree(10);
            		bp.CreateBPtree(bp.keyFunction(a));
            		int[] result=bp.search(sb.toString());
            		int k=0;
            		for (int i=0;i<result.length;i++) {
            			if (result[i]==-1) {
            				
            				continue;
            			}
            			else {
            				String GeoID=Cut.ID(a[result[i]]);
            				String GeoName=Cut.GeoName(a[result[i]]);
            				
            				writer.write("\nGeographic ID: "+ GeoID+"\nGeographic Name: " +GeoName+"\n");
            				k++;
            			}
            		}
            		if (k==0) {
            			writer.write("\nNo record\n");
            		}
            		}
            	
            	//retrieving with GeoID(BST)
            	if (QueryString.startsWith(query2)) {
            		for (int i= query2.length();i<QueryString.length();i++) {
            			
            				sb.append(QueryString.charAt(i));
            			
            		}
            		writer.write("\nFind details of "+sb.toString()+"\nOutput:\n");
            		BST bs= new BST();
                    bs.establish(a,sid.index);
                    int out=bs.searching(sb.toString());
                    if(out== -1) {
                    	writer.write("\nNo record\n");
                    }
                    else {
                    	String GeoName=Cut.GeoName(a[out]);
                    	String latitude=Cut.Latitude(a[out]);
                    	String longitude=Cut.Longitude(a[out]);
                    	writer.write("\nGeographic Name: "+GeoName+"\nlatitude: "+latitude+"\nlongitude: "+longitude+"\n");
                    }
            	}
            	
            	//retrieving with GeoName(hash table)
            	if (QueryString.startsWith(query3) ) {
            		for (int i= query3.length();i<QueryString.length();i++) {
            			
            				sb.append(QueryString.charAt(i));
            			
            		}
            		writer.write("\nFind all: "+ sb.toString()+"\nOutput:\n");
            		Hashing hashing=new Hashing();
            		hashing.establish_location(a);
                    int[] result = hashing.searching_location(sb.toString());
                    if (result.length==0) {
                    	writer.write("\nNo record\n");
                    }
                    else {
                    	for (int i=0;i<result.length;i++) {
                    		String GeoID=Cut.ID(a[result[i]]);
                    		String latitude=Cut.Latitude(a[result[i]]);
                    		String longitude=Cut.Longitude(a[result[i]]);
                    		writer.write("\nGeographic ID: "+ GeoID+"\nlatitude: " +latitude+"\nlongitude: "+longitude+"\n");
                    }
                    }
            	}
            }
            
            QueryReader.close();
            writer.close();
            
            
/*            
// retrieving with ID, by BST            
            BST tree= new BST();
            tree.establish(a);
            int out1=tree.searching("EKOMY");
            writer.write(tree.printout(out1, a));
// retrieving with coordinate, by open hashing
            Hashing hashing = new Hashing();
            hashing.establish_coordinate(a);
            int[] result= hashing.searching_coordinate("56.79,-61.22");
            
            writer.write(hashing.printout_coordinate(result, a));
// retrieving with location
            hashing.establish_location(a);
            int[] result1 = hashing.searching_location("Albert Lake");
            writer.write(hashing.printout_location(result1, a));
//Inverted index
            Inverted_index nnw= new Inverted_index();
            nnw.establish(a);
            nnw.printindex(a);
            writer.close();
            */
        } catch (FileNotFoundException ex) {
            System.out.println("Not finding file!");
        } catch (IOException ex) {
            System.out.println("error");
        }
        
    }
}
