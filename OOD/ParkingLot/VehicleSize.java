
public enum VehicleSize {
	COMPACT (0),
	LARGE	(10);
	private final int vehicleSize;
	private VehicleSize(int size) {
		vehicleSize = size;
	}
	public int getVehicleSize() {
		return vehicleSize;
	}
}
