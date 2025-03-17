/** 
 * ACS-1904 Lab 9 Names
 * your name
 * your student number
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Lab9Names{
    public static void main (String[] args)throws FileNotFoundException{
        // CONSTANTS 
        final int MAX = 10; // maximum number of records in the file

        // variables
        String strin;       // for input from the file
        String[] tokens;    // array of strings for split input record

        String delim = "[ ]+";  // delimiters
        int total = 0;
        int n = 0;              // number of records read from the file

        // arrays for input data
        String[] names = new String[MAX];
        int[] n1 = new int[MAX];
        int[] n2 = new int[MAX];
        int[] n3 = new int[MAX];

        // create a Scanner object to get file input
        Scanner fin = new Scanner (new File("Lab9NameData.txt"));

        n = 0;      // make sure we start counting records at 0

        while (fin.hasNextLine()) {
            strin = fin.nextLine();
            //System.out.println(strin);

            // parse the input record
            tokens = strin.split(delim);

            // load the data into arrays
            try{
                names[n] = tokens[0];
                n1[n] = Integer.parseInt(tokens[1]);
                n2[n] = Integer.parseInt(tokens[2]);
                n3[n] = Integer.parseInt(tokens[3]);
                
                // count the record added
                System.out.println("Record added.");
                n++;
            }// end try
            catch(NumberFormatException e){
                System.out.println("oops not an int, record not added.");
            }// end catch number format exception
            catch(ArrayIndexOutOfBoundsException e){
                System.out.println("Incomplete input record");
                System.out.println("Input record must contain 3 numbers");
            }// end catch incomplete record
            
            
        }//end while

        // print the arrays
        System.out.println("\nRecords added to lists");
        for(int i = 0; i < n; i++){
            System.out.print(names[i] + " " + n1[i] + " ");
            System.out.println(n2[i] + " " + n3[i]);
        }// end print arrays

        // bye bye

        System.out.println("\nProgram ended normally") ;
    }
}

