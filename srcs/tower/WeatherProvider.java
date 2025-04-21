package weatherprovider;

import flyable.Coordinates;

public class WeatherProvider {
	private static WeatherProvider instance = null;
	private String[] weather = {"Rain", "Fog", "Sun", "Snow"};

	private WeatherProvider() {};

	public static WeatherProvider	getInstance() {
		if (instance == null)
			instance = new WeatherProvider();
		
		return (instance);
	}
	
	public String	getCurrentWeather(Coordinates p_coordiates) {
		int weatherType = (p_coordiates.getLongitude() + p_coordiates.getLatitude() + p_coordiates.getHeight()) % 4;

		return (this.weather[weatherType]);
	};
}
