package flyable;

import tower.WeatherTower;

public abstract class Flyable {
	protected WeatherTower weatherTower;

	public WeatherTower	getWeatherTower() {
		return (this.weatherTower);
	}

	public void registerTower(WeatherTower p_tower) {
		this.weatherTower = p_tower;
	}

	public abstract void updateConditions();
	public abstract String getType();

}
