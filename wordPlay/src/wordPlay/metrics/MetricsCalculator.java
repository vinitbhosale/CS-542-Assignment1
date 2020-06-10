package wordPlay.metrics;

import wordPlay.util.Results;
import java.util.ArrayList;

import java.io.IOException;

public class MetricsCalculator {

    float avgWordLength=0;
    float avgNumWordsPerSentence=0;
    
    public void calculateMeterics(ArrayList<String> arrLstStr, float dot, Results res){
      calculateAvgWrdLength(arrLstStr);
      calculateAvgWrdCount(arrLstStr, dot);
      res.storeMetricsResult(avgWordLength, avgNumWordsPerSentence);
    }

    // Calculate average word length
  private void calculateAvgWrdLength(ArrayList<String> arrLstStr){
      
      float counter = 0;
      float sum = 0;
      
      for(String temp: arrLstStr){
        
          sum += temp.length();
          counter++;
      }
      avgWordLength = sum/counter;
       
  }
  
  // Calculate average word count per sentence
  private void calculateAvgWrdCount(ArrayList<String> arrLststr1, float dot){
  
      float sum = arrLststr1.size();
      avgNumWordsPerSentence = sum/dot;  
  
  }

}