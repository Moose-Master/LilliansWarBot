import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Logger {

    private int gNum = 0;
    private String game = "testGame";
    FileWriter numEdit;
    FileWriter writer;
    public Logger(){
        
        try{
            File numFile = new File("num.txt");
            
            if(!numFile.exists()){
                numFile.createNewFile();
                numEdit = new FileWriter("num.txt");
                numEdit.write("0");
                numEdit.close();
            }
            
            Scanner number = new Scanner(numFile);
            gNum = number.nextInt();
            game += gNum;
            number.close();
            String sNum = "" + (gNum + 1);
            numEdit = new FileWriter("num.txt");
            numEdit.write(sNum);
            numEdit.close();
            
            File log = new File(game + ".txt");
              if (log.createNewFile()) {
                System.out.println("Log Started for " + game);
             }
             writer = new FileWriter(game+".txt");
        }//Try
        catch(IOException e){System.out.println("Error in Constructor " + e);}
    }//End of Constructer
    public void write(String text){
        try{writer.write(text + "\n");}
        catch(IOException e){System.out.println(e);}
    }
    
    public void close(){
        try{writer.close();}
        catch(IOException e){System.out.println(e);}
    }
}