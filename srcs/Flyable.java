package flyable;

abstract class Flyable {
	protected WeatherTower weatherTower;

	public abstract void updateConditions();

	public void registerTower(WeatherTower p_tower) {};
}