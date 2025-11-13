
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Filefunction {
    public static void main(String[] args) {
        String filePath = "data.txt";  
        int count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
               
                String[] words = line.toLowerCase().split(" ");

                for (String w : words) {
                    if (w.equals("india")) {
                        count++;
                    }
                }
            }

            System.out.println("Total occurrences of 'India': " + count);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
