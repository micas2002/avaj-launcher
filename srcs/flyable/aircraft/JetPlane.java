package flyable.aircraft;

import flyable.Coordinates;

public class JetPlane extends Aircraft {
	public JetPlane(long p_id, String p_name, Coordinates p_coordinates) {
		super(p_id, p_name, p_coordinates);
	}

	@Override
	public void updateConditions() {
		String weather = weatherTower.getWeather(this.coordinates);

		switch (weather) {
			case "Sun" -> {
				coordinates.setLatitude(coordinates.getLatitude() + 10);
				coordinates.setHeight(coordinates.getHeight() + 2);
			}
			case "Rain" -> coordinates.setLatitude(coordinates.getLatitude() + 5);
			case "Fog" -> coordinates.setLatitude(coordinates.getLatitude() + 1);
			case "Snow" -> coordinates.setHeight(coordinates.getHeight() - 7);
			default -> {}
		}

		String message = String.format("JetPlane#%s(%d): ", this.getName(), this.getId());

		switch (weather) {
			case "Rain" -> LogMessage.writeMessage(message + "It's raining. Better watch out for lightings");
			case "Fog" -> LogMessage.writeMessage(message + "There's so much fog. I can't see anything in front of me");
			case "Sun" -> LogMessage.writeMessage(message + "It's a sunny weather. Better get some sun glasses");
			default -> LogMessage.writeMessage(message + "It's snowing. I want to build a snowman");
		}

		if (coordinates.getHeight() <= 0) {
			LogMessage.writeMessage(message + "landing");
			unregisterTower();
			return;
		}
	}

	@Override
	public String getType() {
		return ("JetPlane");
	}

}
