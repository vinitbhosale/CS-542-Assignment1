package wordPlay.handler;

import wordPlay.util.FileProcessor;
import wordPlay.util.Results;
import wordPlay.metrics.MetricsCalculator;
import wordPlay.util.Results;
import java.util.ArrayList;

import java.io.IOException;

public class WordRotator{

  private FileProcessor fp;
  private Results res;
  private ArrayList<String> wordList = new ArrayList<String>();

  
  public WordRotator(FileProcessor inFp, Results inRes){
    
    fp = inFp;
    res = inRes;
  
  }
  
  public void wordRotation()throws IOException{
  
    String str = fp.poll();
    int index = 1;
    double dotCount=0;
    boolean isSentenceComplete = false;
    MetricsCalculator mC = new MetricsCalculator();
    
    while(str != null)
    {
        int iterator = index;
        if(str.endsWith(".")){
            str = str.split("\\.")[0];
            index = 0;
            dotCount++;
            isSentenceComplete = true;
        } 
        while(iterator != 0)
        {
          str = str.charAt(str.length()-1) + str.substring(0, str.length()-1);
          
          iterator -= 1;
        }
        
        res.storeWrdRotaterResult(str, isSentenceComplete);
        isSentenceComplete = false;
        wordList.add(str);
    
        index++;
        str = fp.poll();
       
    }
    
    
    mC.calculateMeterics(wordList, dotCount, res);
  
  }
  
  
    
}