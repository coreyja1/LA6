package la6.cs1120.wmich.edu;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IEncoder encoder = new Encoder();
		IDecoder decoder = new Decoder();
		String inputFileName = "input.txt";
		String encodedFileName = inputFileName+".encode";
		encoder.encode(inputFileName,encodedFileName);
		decoder.decode(encodedFileName);
	}

}