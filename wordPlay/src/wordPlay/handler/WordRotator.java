package wordPlay.handler;

import wordPlay.util.FileProcessor;
import wordPlay.util.Results;
import wordPlay.metrics.MetricsCalculator;
import wordPlay.util.Results;

/**
* class consisting method doing functionality of word rotation
* and storing result in Results class
*/

import java.io.IOException;

public class WordRotator{

  private FileProcessor fp;
  private Results res;
  
  /**
  * constructor for creating FileProcessor and Results object 
  */
  public WordRotator(FileProcessor inFp, Results inRes){
    
    fp = inFp;
    res = inRes;
  
  }
  
  /**
  * function rotating word 
  *
  * @param str - word from sentence from input file iterator - number of place to rotate the world 
  * @ return string str - rotated word
  */
  public String wordRotation(String str, float iterator)throws IOException{
    
    /**
    * rotating word charachter operation by number of place in iterator  
    */
    while(iterator != 0)
        {
          str = str.charAt(str.length()-1) + str.substring(0, str.length()-1);
          
          iterator -= 1;
        }
    
    return str;
    
  }
      
}