package flyable;

public class Coordinates {
	private int	longitude;
	private int	latitude;
	private int	height;

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

	public void setLongitude(int p_longitude) {
		this.longitude = p_longitude;
	};

	public void setLatitude(int p_latitude) {
		this.latitude = p_latitude;
	};

	public void setHeight(int p_height) {
		this.height = p_height;
	};
}
