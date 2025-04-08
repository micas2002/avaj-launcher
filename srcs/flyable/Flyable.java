package flyable;

import tower.WeatherTower;

abstract class Flyable {
	protected WeatherTower weatherTower;

	public abstract void updateConditions();

	public void registerTower(WeatherTower p_tower) {
		weatherTower = p_tower;
	};
}