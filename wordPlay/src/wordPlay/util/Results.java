package wordPlay.util;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;

import java.io.IOException;
import java.text.DecimalFormat;

/**
* Class consisting methods and data members storing result of
* WordRotator anf MetricsCalcultor and displaying results on
* Stdout and output file 
*/

public class Results implements FileDisplayInterface, StdoutDisplayInterface {

    private String result = "";
    private float avgWordLength;
    private float avgNumWordsPerSentence;
    
    
    private String filePath;
    
    private File outputFile;
    private BufferedWriter outputBufferedWriter;
    
    /**
    * method to store results in text file
    * @param path - file path of text file
    */
    public Results(String path){
      filePath = path;
    }
    
    /**
    * method to store rotated word in result
    *
    * @param str - rotated word and isSentenceComplete - for appending period(.) at the end of the word
    */
    public void storeWrdRotaterResult(String str, boolean isSentenceComplete){
         
      if (!isSentenceComplete){
        result = result.concat(str+" ");
      }
      else{     
        result = result.concat(str+".\n");
      }
      
    }
    
    /**
    * method to store metricscalcultor result
    *
    * @ param inAvgWordLength - value of average word length,
    * inAvgNumWordsPerSentence - value of average number od words per sentence
    */
    public void storeMetricsResult(float inAvgWordLength, float inAvgNumWordsPerSentence){
      
      /**
      * decimal formattor to display average value with two number after decimal 
      */
      String pattern = "##.##";
      DecimalFormat decimalFormat = new DecimalFormat(pattern);
      
      avgWordLength =inAvgWordLength;
      avgNumWordsPerSentence=inAvgNumWordsPerSentence;
          
      result = "AVG_NUM_WORDS_PER_SENTENCE - "+decimalFormat.format(inAvgNumWordsPerSentence)+"\n"+"AVG_WORD_LENGTH - "+decimalFormat.format(inAvgWordLength);
    }
    
    /**
    * method to display result on stdout
    */
    public void writeToStdout(){
      
      System.out.println(result);
      
    }
    
    /**
    * method to write the result in the text file 
    */
    public void writeToFile()throws IOException{
        
        outputFile = new File(filePath);
        if(!outputFile.exists())
        {
          outputFile.createNewFile();
        }
        
        outputBufferedWriter = new BufferedWriter(new FileWriter(outputFile));
        
        outputBufferedWriter.write(result.trim());
        
        outputBufferedWriter.close();
               
      }
    	
}
