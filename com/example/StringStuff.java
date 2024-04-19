import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Change me.
 *
 * @author Spencer Scarlett
 * @version 1.0
 * @since 2024-04-04
 */

// Arrays class
public final class StringStuff {
    /**
    * For style checker.
    *
    * @exception IllegalStateException Utility class.
    * @see IllegalStateException
    */
    private StringStuff() {
        throw new IllegalStateException("Utility class");
    }

    /**
    * main
    *
    * @param args Unused
    */
    public static void main(String[] args) {

        // declare opening list
        final ArrayList<String> fileList = new ArrayList<String>();

        try {
            // preps file access and writing/reading
            final File fileInput = new File("input.txt");
            final File fileOutput = new File("output.txt");
            final Scanner sc = new Scanner(fileInput);
            final FileWriter fW = new FileWriter(fileOutput);
            final PrintWriter write = new PrintWriter(fW);

            // reads each line of file
            while (sc.hasNextLine()) {
                // adds the next file
                fileList.add(sc.nextLine());
            }

            // creates an array and adds the element to the array
            final String[] ArrayList = new String[fileList.size()];
            for (int i = 0; i < ArrayList.length; i++) {
                ArrayList[i] = fileList.get(i);
            }

            // call and writes to the file (for each completed line)
            for (String line : ArrayList) {
                final int run = findMaxRun(line);
                write.println(run);
                System.out.println("Done Line");
            }

            // program finished
            System.out.println("Done");

            // closes resources
            write.close();
            sc.close();

        } catch (IOException err) {
            // For when no input file is found.
            System.err.println("Error: " + err.getMessage());
        }
    }

    /**
    * function to find max runs per run
    *
    * @param line 
    * @return maxRun
    */
    public static int findMaxRun(String line) {
        // declaring variables
        int currentRun = 1;
        int maxRun = 0;

        // checks if the line is equal to 1 character
        if (line.length() == 1) {
            maxRun = 1;
        }

        // create and add to array
        char[] ArrayList = new char[line.length()];
        ArrayList = line.toCharArray();

        // checks the line for if a character is repeated more than once and keeps track of it
        for (int counter = 0; counter < ArrayList.length - 1; counter++) {
            if (ArrayList [counter] == ArrayList[counter + 1]) {
                currentRun++;
            } else {
                currentRun = 1;
            }
            if (currentRun > maxRun) {
                maxRun = currentRun;
            }
        }
        return maxRun;
    }
}