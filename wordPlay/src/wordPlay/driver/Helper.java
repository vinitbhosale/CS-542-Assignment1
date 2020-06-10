package wordPlay.driver;

import wordPlay.util.FileProcessor;
import wordPlay.util.Results;
import wordPlay.handler.WordRotator;
import wordPlay.metrics.MetricsCalculator;
import java.util.ArrayList;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.io.IOException;

/**
* Class consisting methods and data members for performming 
* word rotation and metrics calculation
*/

public class Helper{
    
    /**
    * Initializing object of FileProcessor file
    * Initializing object for storing word rotate result and
    * metrics result in Results file
    */
    private FileProcessor fp;
    private Results wordRotResult;
    private Results metricsCalResult;
    private ArrayList<String> wordList = new ArrayList<String>();
    
    /**
    * Constructor of Helper class for storing objects
    * 
    * @param FileProcessor, two objects of Results for wordRotateResult and MetricsCalResul
    */
    public Helper(FileProcessor inFp, Results inWordRotResult, Results inMetricsCalResult){
      
      fp = inFp;
      wordRotResult = inWordRotResult;
      metricsCalResult = inMetricsCalResult ;
    
    }
    
    /**
    * function to rotate word
    */
    public void wordRotate()throws IOException{
      
      /**
      * creating object of rotation function in WordRotator file in handler
      *
      * @param Fileprocessor object and Results object of WordRotator 
      */
      WordRotator wr = new WordRotator(fp, wordRotResult);
      
      /**
      * Object of MetricsCalculator for Helper class
      */
      MetricsCalculator mC = new MetricsCalculator();
      
      Pattern pattern = Pattern.compile("[$&+,:;=\\\\?@#|/'<>^*()%!-]+");
      
      String temp;
      
      String str = fp.poll();
      
      float index = 1;
      float dotCount=0;
      boolean isSentenceComplete = false;
      
      /**
      * Condition to check empty input file
      */
      if (null == str){
        System.err.println("Error: Empty input file! try running program with sentence in input file.");
        System.exit(0);
      }
      /**
      *
      */
      while(str != null)
      {
        /**
        * condition to check whether empty line in input file
        */
        if (str.isEmpty()){
            System.err.println("Error: Empty line in input file!");
            System.exit(0);
        }
        else{
          /**
          * condition to check special charachters 
          */
          if (pattern.matcher(str).find()){
        
            System.err.println("Error: Word contain special charachter!. Try running program with no special charachter in input file.");
            System.exit(0);  
          }
          else
          {
            float iterator = index;
            
            /**
            *condition to check end of line 
            */
            if(str.endsWith(".")){
              str = str.split("\\.")[0];
              index = 0;
              
              /**
              * counter for number of sentence
              */
              dotCount++;
              
              /**
              * flag for getting period(.) with the word
              */
              isSentenceComplete = true;
            }
            
            /**
            *call to the word rotation in the WordRotator file
            *
            * @param str - single word from poll funtion in Fileprocessor and
            * iterartor - number of place to rotate the world
            *
            *@return string rotated word  
            */
            temp = wr.wordRotation(str, iterator); 
            
            /**
            * storing the rotated word in the Results file
            *
            *@param temp - rotated word and isSentenceComplete - flag for period(.)
            */
            wordRotResult.storeWrdRotaterResult(temp, isSentenceComplete);
            
            isSentenceComplete = false;
            
            /**
            * adding rotated word in wordList for metricsCalculation
            */
            wordList.add(temp);
      
            index++;
          }
        
        }
        
        /**
        * fetching next word from the input file
        */
        str = fp.poll();
 
      }
         
      /**
      * call to the calculateMeterics method in the MetricsCalculator class
      * 
      * @param wordList - ArrayList of rotated words, dotCount - count of sentences
      * metricscalresult - metrics Results object for storing result 
      */   
      mC.calculateMeterics(wordList, dotCount, metricsCalResult);
        
    }
    
    @Override
    public String toString(){
      return "Class: Helper, Data Members: [fp="+fp.toString()+", wordRotResult="+wordRotResult.toString()+", metricsCalResult= "+
      metricsCalResult.toString()+", wordList= "+wordList.toString()+"]";
    }
    
}