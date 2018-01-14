
public class ParkingSpot {
	private final VehicleSize size;
	private Vehicle currentVehicle;
	
	ParkingSpot(VehicleSize size) {
		this.size = size;
	}
	
	boolean fit(Vehicle v) {
		return currentVehicle == null && size.getVehicleSize() >= v.getSize().getVehicleSize();
	}
	
	void par(Vehicle v) {
		currentVehicle = v; 
	}
	
	Vehicle getVehicle() {
		return currentVehicle;
	}
	
	void leaveVehicle() {
		currentVehicle = null;
	}
}
