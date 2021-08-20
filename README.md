# Word Play
## Name: Vinit S Bhosale

-----------------------------------------------------------------------
-----------------------------------------------------------------------


Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in wordPlay/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: ant -buildfile wordPlay/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile wordPlay/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: ant -buildfile wordPlay/src/build.xml run -Dinput="input.txt" -Doutput="output.txt" -Dmetrics="metrics.txt"

Note: Arguments accept the absolute path of the files.


-----------------------------------------------------------------------
## Description:

1. Assumption:
- Well formatted input file with equal space between each word and ends
with a period.
- While executing the program absolute path of the files need to pass as input arguments.
-  Order of input arguments to run command is input.txt file path, output.txt file path, metrics.txt file path.

2. Data structures:
- ArrayList - Used to store the rotated words. Also is used to calculate average word length and average words per sentence with dot counter.
- String - Used to append rotated word one by one to display the complete sentence in the Stdout and output.txt file.

3. External Materials:
- Used regex to find special charachter in the sentence.

4. Code working:
- The contents of input.txt file are read line by line and are stored word by word of a line in an ArrayList.
- In the helper class with the help of poll method in FileProcessor single word is fetched and is rotated by an index value and append the rotated word in result file. Also it keeps a count of period when it counter a period with a word to calculate avgNumWordsPerSentence.
-Once rotation and metrics calculation is done it prints the results in Stdout, output.txt and metrics.txt respectively.

-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: 06/10/2020


