import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	private static int					nSimRun = 0;
	private static ArrayList<String[]>	aircrafts = new ArrayList<String[]>();

	public static void checkInput(String input) throws Exception {
		File file = new File(input);
		Scanner myReader = new Scanner(file);

		String data = myReader.nextLine();
		nSimRun = Integer.parseInt(data);

		if (nSimRun < 0)
			throw new Exception("Number of simutation runs must be a positive integer");

		while (myReader.hasNextLine())
			aircrafts.add(myReader.nextLine().split(" "));

		for (int i = 0; i != aircrafts.size(); ++i) {
			if (aircrafts.get(i).length != 5)
				throw new Exception("Invalid aircraft settings");
			if (aircrafts.get(i)[0].matches("Baloon|JetPlane|Helicopter") == false)
				throw new Exception(aircrafts.get(i)[0]);
		}
	}

	public static void main(String[] args) {
		try {
			if (args.length != 1)
				throw new Exception("Wrong number of arguments");

			checkInput(args[0]);
		}
		catch (Exception e) {
			System.out.print(e);
		}
	}
}
