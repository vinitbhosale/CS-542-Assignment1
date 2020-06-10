package wordPlay.metrics;

import wordPlay.util.Results;
import java.util.ArrayList;

import java.io.IOException;

/**
* Class consisting methods calculating average word length
* average number per sentence and storing both results
* in Results file
*/
public class MetricsCalculator {

    float avgWordLength=0;
    float avgNumWordsPerSentence=0;
    
    /**
    * constructor for calling calculateAvgWrdLength, calculateAvgWrdCount methods and
    * storeMetricsResult methods in Results class
    *
    * @param arrLstStr - ArrayList of rotated words, dot - dot period(.) count, res - Results object to store average values by calling
    * storeMetricsResult method in Results class
    */
    public void calculateMeterics(ArrayList<String> arrLstStr, float dot, Results res){
      calculateAvgWrdLength(arrLstStr);
      calculateAvgWrdCount(arrLstStr, dot);
      res.storeMetricsResult(avgWordLength, avgNumWordsPerSentence);
    }

    /** 
    * method to calculate average word length
    *
    * @param arrLstStr - String ArrayList of rotated words
    */
  private void calculateAvgWrdLength(ArrayList<String> arrLstStr){
      
      float counter = 0;
      float sum = 0;
      
      for(String temp: arrLstStr){
        
          sum += temp.length();
          counter++;
      }
      avgWordLength = sum/counter;
       
  }
  
  /** 
  * method to calculate average word count per sentence
  *
  * @param arrLstStr - String ArrayList of rotated words, dot - dot period(.) count
  */
  private void calculateAvgWrdCount(ArrayList<String> arrLststr1, float dot){
  
      float sum = arrLststr1.size();
      avgNumWordsPerSentence = sum/dot;  
  
  }
  
  @Override
  public String toString(){
    return "Class: MetricsCalculator, Data members:[avgWordLength="+avgWordLength+", avgNumWordsPerSentence="+
    avgNumWordsPerSentence+"]";
  }

}