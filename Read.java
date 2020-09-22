// Use data which is encoded in UTF-8 !!!
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
public class Read {

	public static void readTxtFile(String filePath){
        boolean flag=false;
		try {
                String encoding="UTF-8";                    // encoding method of data
                File file=new File(filePath);
                if(file.isFile() && file.exists()){ 
                    String a ="INSERT";
                    String b ="POP";
                    String c ="PRINT";
                	InputStreamReader read = new InputStreamReader(new FileInputStream(file),encoding);
                    BufferedReader bufferedReader = new BufferedReader(read);
                    String lineTxt = null;
                    stack LinkStack = new stack(100);       //establish stack
                    while((lineTxt = bufferedReader.readLine()) != null){
                    	
                    	if (lineTxt.startsWith("\uFEFF")) {        //delete BOM of txt file
                    		lineTxt=lineTxt.replace("\uFEFF", "");
                    	}                   	
                        System.out.print(lineTxt + "\n");
                    	if (a.equals(lineTxt) ){
                        	flag=true;
                        	
                        	continue;
                        }
                        if (b.equals(lineTxt)) {
                        	LinkStack.pop();
                        	System.out.print( LinkStack.elementCount + "\n");
                        	continue;
                        }
                        if (c.equals(lineTxt)) {
                        	LinkStack.print();
                        	System.out.print( LinkStack.elementCount + "\n");
                        	continue;
                        }
                        if (flag==true) {
                        	LinkStack.push(lineTxt);
                        	System.out.print( LinkStack.elementCount + "\n");
                        }
                        
                    }
                    read.close();
        }
        else{													
            System.out.println("do not find file");
        }
        } catch (Exception e) {
            System.out.println("error");
            e.printStackTrace();
        }
     
    }
     
    public static void main(String argv[]){
        String filePath = "/Users/xietianhao/Documents/COMP5511/data1.txt";
//      "res/";
        readTxtFile(filePath);
    }
     
     
 
}

