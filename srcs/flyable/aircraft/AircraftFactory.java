package flyable.aircraft;

import flyable.Flyable;
import flyable.Coordinates;

interface IAircraftFactory {
	Flyable	newAircraft(String p_type, String p_name, Coordinates p_coordinates);
}

public class AircraftFactory implements IAircraftFactory {
	private static AircraftFactory	instance;

	private AircraftFactory() {}

	public static AircraftFactory	getInstance() {
		if (instance == null)
			instance = new AircraftFactory();

		return  (instance);
	}

	public Flyable	newAicraft(String p_type, String p_name, Coordinates p_coordinates) {
		
	};
;}
