import java.io.*;

public class App {
    public static void main(String[] args) throws Exception {

        // temp path
        String path = "../file0.txt";

        // Note:  Double backquote is to avoid compiler
        // interpret words
        // like \test as \t (ie. as a escape sequence)

        // Creating an object of BufferedReader class
        BufferedReader bfro = new BufferedReader(
          					  new FileReader(path));

        // Declaring a string variable
        String st;
      
        // Condition holds true till
        // there is character in a string
        while ((st = bfro.readLine()) != null)
          	System.out.println(st);

        bfro.close();
        System.out.println("Program ending, have a nice day.");
    }
}
