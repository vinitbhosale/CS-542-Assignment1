package wordPlay.handler;

import wordPlay.util.FileProcessor;
import wordPlay.handler.MetricsCalculator;
import java.util.ArrayList;

import java.io.IOException;

public class WordRotator{

  private FileProcessor fp;
  private ArrayList<String> wordList = new ArrayList<String>();
  
  public WordRotator(FileProcessor inFp){
    
    fp = inFp;
  
  }
  
  public void wordRotation()throws IOException{
  
    String str = fp.poll();
    int index = 1;
    double dotCount=0;
    MetricsCalculator mC = new MetricsCalculator();
    
    while(str != null)
    {
        int iterator = index;
        if(str.endsWith(".")){
            str = str.split("\\.")[0];
            index = 0;
            dotCount++;
        } 
        while(iterator != 0)
        {
          str = str.charAt(str.length()-1) + str.substring(0, str.length()-1);
          iterator -= 1;
        }
        System.out.println(str);
        wordList.add(str);
    
        index++;
        str = fp.poll();
    }
    System.out.println(wordList);
    mC.calculateMetrics(wordList);
    mC.calculateMetrics2(wordList, dotCount);
  
  }
  
  
    
}