package aircraft;

import flyable.Coordinates;

public class Baloon extends Aircraft {
	public Baloon(long p_id, String p_name, Coordinates p_coordinates) {
		super(p_id, p_name, p_coordinates);
	};

	@Override
	public void updateConditions() {
		String weather = weatherTower.getWeather(this.coordinates);

		switch (weather) {
			case "Sun" -> {
				coordinates.setLongitude(coordinates.getLongitude() + 2);
				coordinates.setHeight(coordinates.getHeight() + 4);
			}
			case "Rain" -> coordinates.setHeight(coordinates.getHeight() - 5);
			case "Fog" -> coordinates.setHeight(coordinates.getHeight() - 3);
			case "Snow" -> coordinates.setHeight(coordinates.getHeight() - 15);
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
	};
}