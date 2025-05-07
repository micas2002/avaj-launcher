package flyable.aircraft;

import java.io.FileWriter;
import java.io.IOException;

public class LogMessage {
	private static FileWriter myWriter;

	static {
		try {
			myWriter = new FileWriter("simulation.txt", true);
		}
		catch (IOException e) {}
	}

	public static void writeMessage(String p_message) {
		try {
			myWriter.write(p_message + "\n");
			myWriter.flush();
		}
		catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public static void closeFile() {
		try {
			myWriter.close();
		}
		catch (IOException e) {}
	}
}