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

		String message = String.format("Baloon#%s(%d): ", this.getName(), this.getId());

		if (coordinates.getHeight() == 0)
			printMessage(message + "landing");

		switch (weather) {
			case "Rain" -> printMessage(message + "It's raining. Better watch out for lightings");
			case "Fog" -> printMessage(message + "There's so much fog. I can't see anything in front of me");
			case "Sun" -> printMessage(message + "It's a sunny weather. Better get some sun glasses");
			default -> printMessage(message + "It's snowing. I want to build a snowman");
		}
	}
}
