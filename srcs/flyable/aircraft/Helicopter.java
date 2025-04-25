package flyable.aircraft;

import flyable.Coordinates;

public class Helicopter extends Aircraft {
	public Helicopter(long p_id, String p_name, Coordinates p_coordinates) {
		super(p_id, p_name, p_coordinates);
	}

	@Override
	public void updateConditions() {
		String weather = weatherTower.getWeather(this.coordinates);

		switch (weather) {
			case "Sun" -> {
				coordinates.setLongitude(coordinates.getLongitude() + 10);
				coordinates.setHeight(coordinates.getHeight() + 2);
			}
			case "Rain" -> coordinates.setLongitude(coordinates.getLongitude() + 5);
			case "Fog" -> coordinates.setLongitude(coordinates.getLongitude() + 1);
			case "Snow" -> coordinates.setHeight(coordinates.getHeight() - 12);
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

	@Override
	public String getType() {
		return ("Helicopter");
	}

}
