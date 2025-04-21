import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        // temp path
        String path = "file0.txt";

        // TM initilization
        TM tm = new TM();

        // Note:  Double backquote is to avoid compiler
        // interpret words
        // like \test as \t (ie. as a escape sequence)

        // Creating an object of BufferedReader class
        BufferedReader bfro = new BufferedReader(
          					  new FileReader(path));

        // Declaring a string variable
        String st;
        List<String> lines = new ArrayList<>();
      
        // read input file
        while ((st = bfro.readLine()) != null) {
            lines.add(st);
        }

        //System.out.println(st);
        bfro.close();
    
        /*
         * TODO: parse data
         */

         
         // get the number of states and alphabet length
        int numStates = Integer.parseInt(lines.get(0));
        int sigmaLen = Integer.parseInt(lines.get(1)) + 1;
        Integer currState = 0;
    /*  
        for (int i = 2; i < lines.size(); i++) {
            if (i % sigmaLen == 0) {
                currState++;
            }
            String[] parts = lines.get(i).split(",");
            tm.addTransition(currState, Integer.valueOf(parts[0]), Integer.valueOf(parts[1]), parts[2].charAt(0));
        }
        */
        List<String> slicedList = lines.subList(2, lines.size());
        while (currState != numStates) {
            for (int i = currState; i < sigmaLen + currState; i++) {
                System.out.println(slicedList.get(i));
                String[] parts = slicedList.get(i).split(",");
                tm.addTransition(currState, Integer.valueOf(parts[0]), Integer.valueOf(parts[1]), parts[2].charAt(0));
            }
            currState++;
        }
    }
}
