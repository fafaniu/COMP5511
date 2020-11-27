package searching;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class test {
	public static void main(String[] argv) {
		File DataFile = new File("data/cgn_canada_csv_eng(unsorted).csv");
		File outFile = new File("data/sorting.txt");
		ArrayList<String> data= new ArrayList<>();
		String DataString = "";
        try {
            BufferedReader DataReader = new BufferedReader(new FileReader(DataFile));
            
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
            for (int i=0;i<a.length;i++) {
            	writer.write(a[sid.index[i]]+"\n");
            }
            writer.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Not finding file!");
        } catch (IOException ex) {
            System.out.println("error");
        }
	}
}
