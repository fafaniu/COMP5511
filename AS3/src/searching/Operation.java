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
        File inFile = new File("/Users/xietianhao/eclipse-workspace/AS3/src/searching/cgn_canada_csv_eng.csv"); // 
        //File outFile = new File("/Users/xietianhao/Documents/COMP5511/testdata.csv");//
        String inString = "";
        ArrayList<String> data= new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            //BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
            while((inString = reader.readLine())!= null){
                data.add(inString);
            }
            reader.close();
            int dataSize=data.size();
            String[] a= (String[]) data.toArray(new String[dataSize]);
            BST tree= new BST();
            tree.establish(a);
            int out=tree.searching("DDC");
            int out1=tree.searching("EKOMY");
            tree.printout(out,a);
            tree.printout(out1, a);
            //writer.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Not finding file!");
        } catch (IOException ex) {
            System.out.println("error");
        }
    }
}
