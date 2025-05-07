import flyable.Coordinates;
import flyable.aircraft.Aircraft;
import flyable.aircraft.AircraftFactory;
import flyable.aircraft.LogMessage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import tower.WeatherTower;

public class Main {
	private static int					nSimRun = 0;
	private static ArrayList<String[]>	aircrafts = new ArrayList<>();

	public static void checkInput(String input) throws Exception {
		File file = new File(input);
		Scanner myReader = new Scanner(file);

		// check number of times simulation must run
		String data = myReader.nextLine();
		try {
			nSimRun = Integer.parseInt(data);

			if (nSimRun < 0)
			throw new Exception();
		}
		catch (Exception e) {
			throw new Exception("Number of times to run the simulation must be a positive integer");
		}

		// store information of every aircraft
		while (myReader.hasNextLine())
			aircrafts.add(myReader.nextLine().split(" "));

		// check aircrafts settings
		for (int i = 0; i != aircrafts.size(); ++i) {
			if (aircrafts.get(i).length != 5)
				throw new Exception("Invalid aircraft settings");

			if (!aircrafts.get(i)[0].matches("Baloon|JetPlane|Helicopter"))
				throw new Exception("Invalid aircraft type: " + aircrafts.get(i)[0]);

			try {
				int x = Integer.parseInt(aircrafts.get(i)[2]);
				int y = Integer.parseInt(aircrafts.get(i)[3]);
				int z = Integer.parseInt(aircrafts.get(i)[4]);

				if (x < 0 || y < 0 || z < 0)
					throw new Exception();
			}
			catch (Exception e) {
				throw new Exception("Coordinates and height must be positive integers");	
			}
		}
	}

	public static void createFile() throws IOException {
		try {
			File outputFile = new File("simulation.txt");
			outputFile.createNewFile();
		}
		catch (IOException e) {
			throw (e);
		}
	}

	public static void runSimulation() {
		// register aircrafts into tower
		WeatherTower weatherTower = new WeatherTower();
		AircraftFactory aircraftFactory = AircraftFactory.getInstance();
		for (String[] i : aircrafts) {
			Coordinates coordinates = Coordinates.newCoordinates(Integer.parseInt(i[2]), Integer.parseInt(i[3]), Integer.parseInt(i[4]));
			Aircraft plane = (Aircraft) aircraftFactory.newAircraft(i[0], i[1], coordinates);
			weatherTower.register(plane);
		}

		// run simulation
		for (int i = 0; i != nSimRun; i++) {
			weatherTower.changeWeather();
		}
	}

	public static void main(String[] args) {
		try {
			if (args.length != 1)
				throw new Exception("Wrong number of arguments");

			checkInput(args[0]);

			runSimulation();

			LogMessage.closeFile();
			System.out.println("complete");
		}
		catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
