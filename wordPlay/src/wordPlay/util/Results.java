package wordPlay.util;



import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;

import java.io.IOException;



public class Results implements FileDisplayInterface, StdoutDisplayInterface {

    private String result = "";
    private double avgWordLength;
    private double avgNumWordsPerSentence;
    
    private String outputFilePath;
    private String metricsFilePath;
    
    private File outputFile, metriceOutputFile;
    private BufferedWriter outputBufferedWriter, metricsBufferedWriter;
    private FileWriter outputFileWriter, metricsOutputFileWriter;
    
    public Results(String inOutputFilePath, String inMetricsFilePath){
      outputFilePath = inOutputFilePath;
      metricsFilePath = inMetricsFilePath;
    }
    
    public void storeWrdRotaterResult(String str, boolean isSentenceComplete){
    
      
      if (!isSentenceComplete){
        result = result.concat(str+" ");
      }
      else{
        
        result = result.concat(str+".\n");
      }
       
    }
    
    public void storeMetricsResult(double inAvgWordLength, double inAvgNumWordsPerSentence){
      avgWordLength = inAvgWordLength;
      avgNumWordsPerSentence = inAvgNumWordsPerSentence;
    }
    
    public void writeToStdout(){
      
      System.out.println("OUTPUT:");
      System.out.println(result);
      System.out.println("AVG_WORD_LENGTH - "+avgWordLength);
      System.out.println("AVG_NUM_WORDS_PER_SENTENCE - "+avgNumWordsPerSentence);  
      
    }
    
    public void writeToFile()throws IOException{
    
        outputFile = new File(outputFilePath);
        metriceOutputFile = new File(metricsFilePath);
        
        if(!outputFile.exists() && !metriceOutputFile.exists())
        {
          outputFile.createNewFile();
          metriceOutputFile.createNewFile();
        }
        
        outputFileWriter = new FileWriter(outputFile);
        metricsOutputFileWriter = new FileWriter(metriceOutputFile);
        
        outputBufferedWriter = new BufferedWriter(outputFileWriter);
        metricsBufferedWriter = new BufferedWriter(metricsOutputFileWriter);
        
        outputBufferedWriter.write(result.trim());
        metricsBufferedWriter.write("AVG_NUM_WORDS_PER_SENTENCE - "+avgNumWordsPerSentence+"\n"+"AVG_WORD_LENGTH - "+avgWordLength);
        
        outputBufferedWriter.close();
        metricsBufferedWriter.close();
    
        
      }

    
    	
}
