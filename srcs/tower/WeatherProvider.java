package weatherprovider;

// Singleton
public class WeatherProvider {
	private static WeatherProvider instance = null;
	private String[]	weather;

	private WeatherProvider() {};

	public static WeatherProvider	getInstance() {
		if (instance == null)
			instance = new WeatherProvider();
		
		return (instance);
	}
	
	public String	getCurrentWeater(Coordiates p_coordiates) {};
}
