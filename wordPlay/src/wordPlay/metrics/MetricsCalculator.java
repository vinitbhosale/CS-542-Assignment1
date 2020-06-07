package wordPlay.metrics;

import java.util.ArrayList;

import java.io.IOException;

public class MetricsCalculator {

    // Calculate average word length
  public void calculateMetrics(ArrayList<String> arrLstStr){
      
      double counter = 0;
      double sum = 0;
      
      for(String temp: arrLstStr){
        
          sum += temp.length();
          counter++;
      }
      double average = sum/counter;
      System.out.println("AVG_WORD_LENGTH - "+average);
  }
  
  // Calcualte average word per sentance
  public void calculateMetrics2(ArrayList<String> arrLststr1, double dot){
  
      double sum = arrLststr1.size();
      //System.out.println(sum);
      double avg1 = sum/dot;
      System.out.println("AVG_NUM_WORDS_PER_SENTENCE - "+avg1);
    
  
  }

}