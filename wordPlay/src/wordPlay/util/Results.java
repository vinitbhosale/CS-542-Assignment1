package wordPlay.util;



public class Results implements FileDisplayInterface, StdoutDisplayInterface {

    private String result = "";
    private double avgWordLength;
    private double avgNumWordsPerSentence;
    
    private String outputFilePath;
    private String metricsFilePath;
    
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
    public void writeToFile(){
    
      
    
    }
    
    	
}
