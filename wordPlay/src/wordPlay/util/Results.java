package wordPlay.util;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;

import java.io.IOException;
import java.text.DecimalFormat;



public class Results implements FileDisplayInterface, StdoutDisplayInterface {

    private String result = "";
    private float avgWordLength;
    private float avgNumWordsPerSentence;
    
    private String filePath;
    
    private File outputFile;
    private BufferedWriter outputBufferedWriter;
    
    public Results(String path){
      filePath = path;
    }
    
    public void storeWrdRotaterResult(String str, boolean isSentenceComplete){
         
      if (!isSentenceComplete){
        result = result.concat(str+" ");
      }
      else{     
        result = result.concat(str+".\n");
      }
      
    }
    
    public void storeMetricsResult(float inAvgWordLength, float inAvgNumWordsPerSentence){
      
      String pattern = "##.##";
      DecimalFormat decimalFormat = new DecimalFormat(pattern);
      
      avgWordLength =inAvgWordLength;
      avgNumWordsPerSentence=inAvgNumWordsPerSentence;
          
      result = "AVG_NUM_WORDS_PER_SENTENCE - "+decimalFormat.format(inAvgNumWordsPerSentence)+"\n"+"AVG_WORD_LENGTH - "+decimalFormat.format(inAvgWordLength);
    }
    
    public void writeToStdout(){
      
      System.out.println(result);
      
    }
    
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
