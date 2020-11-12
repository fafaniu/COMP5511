package searching;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Operation {
	public static void main(String[] argv){
        File inFile = new File("/Users/xietianhao/eclipse-workspace/AS3/src/searching/cgn_qc_csv_eng.csv"); // 
        File outFile = new File("/Users/xietianhao/eclipse-workspace/AS3/src/searching/searchingresult.txt");//
        String inString = "";
        ArrayList<String> data= new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
            if (!outFile.exists()) {
				 outFile.createNewFile();
			 }
            while((inString = reader.readLine())!= null){
                data.add(inString);
            }
            reader.close();
            int dataSize=data.size();
            String[] a= (String[]) data.toArray(new String[dataSize]);
// retrieving with ID, by BST            
            BST tree= new BST();
            tree.establish(a);
            int out1=tree.searching("EKOMY");
            writer.write(tree.printout(out1, a));
// retrieving with coordinate, by open hashing
            Hashing hashing = new Hashing();
            hashing.establish_coordinate(a);
            int[] result= hashing.searching_coordinate("46.86,-71.10");
            
            writer.write(hashing.printout_coordinate(result, a));
// retrieving with location
            hashing.establish_location(a);
            int[] result1 = hashing.searching_location("Maniwaki; La Vallée-de-la-Gatineau");
            writer.write(hashing.printout_location(result1, a));
//Inverted index
            Inverted_index nnw= new Inverted_index();
            nnw.establish(a);
            nnw.printindex(a);
            writer.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Not finding file!");
        } catch (IOException ex) {
            System.out.println("error");
        }
    }
}
