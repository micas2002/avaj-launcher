package aircraft;

import flyable.Coordinates;

public class Baloon extends Aircraft {
	public Baloon(long p_id, String p_name, Coordinates p_coordinates) {
		super(p_id, p_name, p_coordinates);
	};

	@Override
	public void updateConditions() {};
}