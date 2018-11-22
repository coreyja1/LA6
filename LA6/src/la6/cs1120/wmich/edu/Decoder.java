package la6.cs1120.wmich.edu;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Decoder implements IDecoder {

	@Override
	/**
	 * Will set pointer to location in the file based on the random integer after each
	 * character and will print each character to the console.
	 */
	public void decode(String filePath) {
		// TODO Auto-generated method stub
		try {
		int location = 0;
		int x = 0;
		boolean finish = true;
		RandomAccessFile input = new RandomAccessFile(filePath, "r");
		System.out.print(input.readChar());
		location = 6;
		x = input.readInt();
		location += x;
		while (finish == true) {
			input.seek(location);
			System.out.print(input.readChar());
			x = input.readInt();
			location = location + x + 6;
			if (x == -1) {
				finish = false;
			}
		}
			
		input.close();
		
		}
		catch (IOException e) {
			System.out.println("IOException!");
		}
	}

}
