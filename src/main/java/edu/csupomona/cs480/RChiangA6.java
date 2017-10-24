package edu.csupomona.cs480;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This simply pulls all of the lines from the output.json file into an array list.
 * @author Rachel Chiang
 */
public class RChiangA6 {
   public Object[] getJsonLines()
   {
      File file = new File(getClass().getResource("/static/output.json").getFile());
      List<String> fileLines = new ArrayList<>();
      
      Scanner inFile;
      try {
         inFile = new Scanner(file);
         
         while(inFile.hasNext())
         {
            fileLines.add(inFile.next());
         }
         
         inFile.close();
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      }
      
      return fileLines.toArray();
   }
}
