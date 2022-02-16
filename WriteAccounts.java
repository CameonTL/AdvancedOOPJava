package assignment3;

import java.io.*;
import java.nio.file.*;

public class WriteAccounts {

	Path productsPath = Paths.get("accounts.txt");
	File productsFile = productsPath.toFile();{
	
	try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(productsFile)))){
		out.println("100, Bob, Blue, 24.98  \n" + 
				"200, Steve, Green, -345.67\n" + 
				"300, Pam, White, 0.00 \n" + 
				"400, Sam, Red, -42.16\n" + 
				"500, Sue, Yellow, 224.62");
	}
	catch (IOException e) {
		System.out.println(e);
	}
}
}