package wordPlay.driver;

import wordPlay.util.FileProcessor;
import wordPlay.util.Results;
import wordPlay.handler.WordRotator;
import wordPlay.metrics.MetricsCalculator;
import java.util.ArrayList;

import java.io.IOException;

public class Helper{
    
    private FileProcessor fp;
    private Results wordRotResult;
    private Results metricsCalResult;
    private ArrayList<String> wordList = new ArrayList<String>();
    
    public Helper(FileProcessor inFp, Results inWordRotResult, Results inMetricsCalResult){
      
      fp = inFp;
      wordRotResult = inWordRotResult;
      metricsCalResult = inMetricsCalResult ;
    
    }
    
    public void wordRotate()throws IOException{
      
      WordRotator wr = new WordRotator(fp, wordRotResult);
      MetricsCalculator mC = new MetricsCalculator();
      
      String temp;
      
      String str = fp.poll();
      float index = 1;
      float dotCount=0;
      boolean isSentenceComplete = false;
      
      
      while(str != null)
      {
        float iterator = index;
        if(str.endsWith(".")){
            str = str.split("\\.")[0];
            index = 0;
            dotCount++;
            isSentenceComplete = true;
        }
        temp = wr.wordRotation(str, iterator); 
        wordRotResult.storeWrdRotaterResult(temp, isSentenceComplete);
        isSentenceComplete = false;
        wordList.add(temp);
    
        index++;
        str = fp.poll();
       
      }
      mC.calculateMeterics(wordList, dotCount, metricsCalResult);
      
    
    }
        

}