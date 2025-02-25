package io_practice;

import java.io.*;

public class io_practice {
	public static void main(String[] args) {
		// create file
		File myFile = new File("practice.txt");
		try {
			if (myFile.createNewFile()) {
				System.out.println("Created the file: " + myFile);
			} else {
				System.out.println("File already exists");
			}
		} catch (IOException e) {
			System.out.println("error occurred during file creation");
			e.printStackTrace();
		}
		 // write to file
		try {
			FileWriter myWriter = new FileWriter(myFile);
			myWriter.write("I am text being written to a newly created file");
			myWriter.close();
			System.out.println("Text written to file sucessfully");
		} catch (IOException e) {
			System.out.println("error occurred during file writting");
			e.printStackTrace();
		}
		
		// read from a file
		try {
			FileReader myReader = new FileReader(myFile);
			BufferedReader myBuffReader = new BufferedReader(myReader);
			String line;
			while ((line = myBuffReader.readLine()) != null) {
				System.out.println(line);
			}
			myReader.close();
			System.out.println("Text read from file appears above.");
		} catch (IOException e) {
			System.out.println("error occurred during file reading");
			e.printStackTrace();		}
	}
}
