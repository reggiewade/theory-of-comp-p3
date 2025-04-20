import java.io.*;

public class App {
    public static void main(String[] args) throws Exception {

        // temp path
        String path = "test_data/file0.txt";

        // Note:  Double backquote is to avoid compiler
        // interpret words
        // like \test as \t (ie. as a escape sequence)

        // Creating an object of BufferedReader class
        BufferedReader bfro = new BufferedReader(
          					  new FileReader(path));

        // Declaring a string variable
        String st;
        String[] parts = null;
      
        // read input file
        while ((st = bfro.readLine()) != null) {
            // Example: Split the line by spaces
            parts = st.split("\n");
            
            // Process each part
            for (String part : parts) {
                System.out.println(part); // Print each parsed part
            }
        }


        //System.out.println(st);
        bfro.close();
    
        /*
         * TODO: parse data
         */

        
    }
}
