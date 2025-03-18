import java.beans.XMLDecoder;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ReadNamesFromXMLWhithWhileTrue {
    public static void main(String[] args){

        XMLDecoder decoder;
        String fileName = "lab09.xml";
        ArrayList<String> list = new ArrayList<>();

        decoder = getStream(fileName);

        if(decoder != null){
            JOptionPane.showMessageDialog(null, "Success, file found");
            loadList(list, decoder);
            //printList(list);
            // close the stream
            decoder.close();
        }// end if
        else{
            JOptionPane.showMessageDialog(null, "Error, file not found");
        }// end file not found

        printList(list);
        
        // closing message
        System.out.println("end of program");
    }//end main

    public static void printList(ArrayList<String> list){
        for(String s : list)
            System.out.println(s);
    }// end printLIst

    public static XMLDecoder getStream(String fileName){
        XMLDecoder decoder = null;

        try{
            decoder = new XMLDecoder(new FileInputStream(fileName));
            //JOptionPane.showMessageDialog(null, "Success, file found");
        }// end try
        catch(FileNotFoundException e){
            //JOptionPane.showMessageDialog(null, "Error, file not found");
            decoder = null;
        }

        return decoder;
    }// end getSream

    public static void loadList(ArrayList<String> l, XMLDecoder decoder){
        boolean eof = false;
        String strin;
        try{
            while(true){

                strin = (String)decoder.readObject();
                l.add(strin);
                //System.out.println(strin);
            } // while
        } // end tryu
        catch(ArrayIndexOutOfBoundsException e){
            eof = true;
            //printList(l);
            //System.out.println("eof");
        }// end catch
        finally{
            decoder.close();
        }// end finally

    }// end loadList
}
