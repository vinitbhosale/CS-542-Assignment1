package wordPlay.handler;

import wordPlay.util.FileProcessor;
import wordPlay.util.Results;
import wordPlay.metrics.MetricsCalculator;
import wordPlay.util.Results;


import java.io.IOException;

public class WordRotator{

  private FileProcessor fp;
  private Results res;
  

  
  public WordRotator(FileProcessor inFp, Results inRes){
    
    fp = inFp;
    res = inRes;
  
  }
  
  public String wordRotation(String str, float iterator)throws IOException{

    while(iterator != 0)
        {
          str = str.charAt(str.length()-1) + str.substring(0, str.length()-1);
          
          iterator -= 1;
        }
    
    return str;
    
  }
  
  
    
}