import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TMSimulator {
    public static void main(String[] args) throws Exception {

        if (args.length == 0) {
            System.out.println("No arguments provided.");
            return;
        }

        String path = args[0];

        // TM initilization
        TM tm = new TM();


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

         
         // get the number of states and alphabet length
        int numStates = Integer.parseInt(lines.get(0));
        int sigmaLen = Integer.parseInt(lines.get(1)) + 1;    // add 1 for extra 0
        Integer currState = 0;
        int counter = 0;

        List<String> slicedList = lines.subList(2, lines.size());
        while ((currState + 1) != numStates) {
            for (int i = counter; i < sigmaLen + counter; i++) {
                System.out.println(slicedList.get(i));
                String[] parts = slicedList.get(i).split(",");
                tm.addTransition(currState, Integer.valueOf(parts[0]), Integer.valueOf(parts[1]), parts[2].charAt(0));
            }
            currState++;
            counter += sigmaLen;
        }
    }
}
