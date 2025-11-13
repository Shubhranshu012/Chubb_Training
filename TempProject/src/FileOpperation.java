

import java.io.*;
import java.util.Scanner;
class FileOpperation {

	
    public static void main(String[] args)  {
        // Create and write a sample file
    	//Scanner sc = new Scanner(System.in);
    	
    	try {
    		
    		FileOpperation obj = new FileOpperation();
        //	obj.fileprocess();
        File file = new File("demo.txt");
        FileWriter writer = new FileWriter(file) ;
            writer.write("Hello Java\nThis is a Scanner example");
            writer.flush();
            
           // File f = new File("C:\\trainingdocs\\NewTraining\\userdettails.txt");
        Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
            
    	}catch(Exception ex) {
    		ex.printStackTrace();
    	}
    	
    	
        }
    

    public  void fileprocess() throws IOException {
        // Create a file and write content
        try (FileWriter writer = new FileWriter("fileReader.txt")) {
            writer.write("Learning FileReader and FileWriter in Java");
        }

        // Read using FileReader
        try (FileReader reader = new FileReader("fileReader.txt")) {
        
   //     try (FileReader reader = new FileReader("C:\\trainingdocs\\NewTraining\\userdettails.txt")) {
            int ch;
            while ((ch = reader.read()) != -1) {
                System.out.print((char) ch);
            }
        }
    }

}