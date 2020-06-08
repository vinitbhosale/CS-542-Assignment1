package wordPlay.driver;
import wordPlay.util.FileProcessor;
import wordPlay.util.Results;
import wordPlay.handler.WordRotator;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.nio.file.InvalidPathException;
/**
 * @author John Doe
 *
 */
public class Driver {
	public static void main(String[] args)throws InvalidPathException, FileNotFoundException, IOException {

		/*
		 * As the build.xml specifies the arguments as input,output or metrics, in case the
		 * argument value is not given java takes the default value specified in
		 * build.xml. To avoid that, below condition is used
		 */
		if ((args.length != 3) || (args[0].equals("${input}")) || (args[1].equals("${output}")) || (args[2].equals("${metrics}"))) {
			System.err.println("Error: Incorrect number of arguments. Program accepts 3 arguments.");
			System.exit(0);
		}
		System.out.println("Hello World! Lets get started with the assignment");
    FileProcessor fileProcsr = new FileProcessor(args[0]);
    Results res = new Results(args[1],args[2]);
    
    
    WordRotator wr = new WordRotator(fileProcsr, res);
    
    wr.wordRotation();
    
    res.writeToStdout();
    res.writeToFile();
    
		

	}
}
