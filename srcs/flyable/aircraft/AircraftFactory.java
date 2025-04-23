package flyable.aircraft;

import flyable.Coordinates;
import flyable.Flyable;

interface IAircraftFactory {
	Flyable	newAircraft(String p_type, String p_name, Coordinates p_coordinates);
}

public class AircraftFactory implements IAircraftFactory {
	private static AircraftFactory	instance = null;
	private int id = -1;

	private AircraftFactory() {}

	public static AircraftFactory	getInstance() {
		if (instance == null)
			instance = new AircraftFactory();

		return (instance);
	}

	@Override
	public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) {
		return switch (p_type) {
			case "Baloon" -> new Baloon(++id, p_name, p_coordinates);
			case "JetPlane" -> new JetPlane(++id, p_name, p_coordinates);
			case "Helicopter" -> new Helicopter(++id, p_name, p_coordinates);
			default -> null;
		};
	};
;}
