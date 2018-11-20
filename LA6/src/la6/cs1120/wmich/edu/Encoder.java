package la6.cs1120.wmich.edu;

	import java.io.File;
	import java.io.IOException;
	import java.io.RandomAccessFile;
	import java.util.Random;
	import java.util.Scanner;

	public class Encoder implements IEncoder {

		@Override
		/**
		 * This method takes the inputFileName and reads the file. It will write each character
		 * followed by an integer between 1 and 20 to a binary file specified by outputFilePath
		 * after each random integer it will move x spaces in the file, where x is the random
		 * integer for each character.
		 */
		public void encode(String inputFileName, String outputFilePath) {
			// TODO Auto-generated method stub
			Random rand = new Random();
			int location = 0;
			try {
				File file = new File(inputFileName);
				Scanner sc = new Scanner(file);
				RandomAccessFile output = new RandomAccessFile(outputFilePath, "rw");
				while (sc.hasNextLine()) {
					String line = sc.nextLine();
					char [] letters = line.toCharArray();
					for (int i = 0; i < letters.length; i++) {
						//generates a random integer between 1 and 20
						int randomInt = rand.nextInt(20) + 1;
						output.writeChar(letters[i]);
						//if it is the last character in the file add -1 after the character
						if (sc.hasNextLine() == false && i == (letters.length-1)) {
							output.writeInt(-1);
						}
						else {
							output.writeInt(randomInt);
							location += (6+randomInt);
							output.seek(location);
						
						}
					}
				}
				sc.close();
				output.close();
			}
			catch (IOException e) {
				System.out.println("The file was not found.");
			}
		}

	}


