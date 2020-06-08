package wordPlay.metrics;

import wordPlay.util.Results;
import java.util.ArrayList;

import java.io.IOException;

public class MetricsCalculator {

    double avgWordLength=0;
    double avgNumWordsPerSentence=0;
    
    public void calculateMeterics(ArrayList<String> arrLstStr, double dot, Results res){
      calculateAvgWrdLength(arrLstStr);
      calculateAvgWrdCount(arrLstStr, dot);
      res.storeMetricsResult(avgWordLength, avgNumWordsPerSentence);
    }

    // Calculate average word length
  private void calculateAvgWrdLength(ArrayList<String> arrLstStr){
      
      double counter = 0;
      double sum = 0;
      
      for(String temp: arrLstStr){
        
          sum += temp.length();
          counter++;
      }
      avgWordLength = sum/counter;
      
      
  }
  
  
  private void calculateAvgWrdCount(ArrayList<String> arrLststr1, double dot){
  
      double sum = arrLststr1.size();
      avgNumWordsPerSentence = sum/dot;
      
    
  
  }

}