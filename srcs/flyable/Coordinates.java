package flyable;

public class Coordinates {
	final private int	longitude;
	final private int	latitude;
	final private int	height;

	Coordinates(int p_longitude, int p_latitude, int p_height) {
		this.longitude = p_longitude;
		this.latitude = p_latitude;
		this.height = p_height;
	};

	public int getLongitude() {
		return longitude;
	};

	public int getLatitude() {
		return latitude;
	};

	public int getHeight() {
		return height;
	};
}
