package tower;

import flyable.Coordinates;

public class WeatherTower extends  Tower {
	public String getWeather(Coordinates p_coordinates) {
		WeatherProvider w = WeatherProvider.getInstance();
		return (w.getCurrentWeather(p_coordinates));
	}

	public void changeWeather() {
		conditionChanged();
	}
}
