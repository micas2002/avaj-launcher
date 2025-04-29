import flyable.Flyable;
import flyable.Coordinates;
import flyable.aircraft.Aircraft;
import flyable.aircraft.AircraftFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import tower.WeatherTower;

public class Main {
	private static int					nSimRun = 0;
	private static ArrayList<String[]>	aircrafts = new ArrayList<>();

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

	public static void runSimulation() {
		// register aircrafts into tower
		WeatherTower weatherTower = new WeatherTower();
		AircraftFactory aircraftFactory = AircraftFactory.getInstance();
		for (String[] i : aircrafts) {
			Coordinates coordinates = Coordinates.newCoordinates(Integer.parseInt(i[2]), Integer.parseInt(i[3]), Integer.parseInt(i[4]));
			Aircraft plane = (Aircraft) aircraftFactory.newAircraft(i[0], i[1], coordinates);
			weatherTower.register(plane);
		}

		ArrayList<Flyable> observers = weatherTower.getObservers();
		for (Flyable flyable : observers) {
			weatherTower.changeWeather();
		}
	}

	public static void main(String[] args) {
		try {
			if (args.length != 1)
				throw new Exception("Wrong number of arguments");

			checkInput(args[0]);

			runSimulation();

			// System.out.println(weatherTower.getWeather(coordinates1));
			// System.out.println(weatherTower.getWeather(coordinates2));

			// weatherTower.changeWeather();

			// System.out.println(weatherTower.getWeather(coordinates1));
			// System.out.println(weatherTower.getWeather(coordinates2));

			System.out.println("complete");
		}
		catch (Exception e) {
			System.out.print(e);
		}
	}
}
