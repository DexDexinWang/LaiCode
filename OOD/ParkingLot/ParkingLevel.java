import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class ParkingLevel {
	
	private final List<ParkingSpot> spots;
	
	ParkingLevel(int numberOfSports) {
		List<ParkingSpot> list = new ArrayList<>(numberOfSports);
		int i = 0; 
		for(; i < numberOfSports / 2; i++) {
			list.add(new ParkingSpot(VehicleSize.LARGE));
		}
		
		for (; i < numberOfSports; i++) {
			list.add(new ParkingSpot(VehicleSize.COMPACT));
		}
		spots = Collections.unmodifiableList(list);
	}
	
	boolean hasSport(Vehicle v) {
		for (ParkingSpot spot : spots) {
			if (spot.fit(v)) {
				return true;
			} 
		} 
		return false;
	}
	
	boolean park(Vehicle v) {
		for (ParkingSpot spot: spots) {
			if (spot.fit(v)) {
				spot.par(v);
				return true;
			}
		}
		return false;
	}
	
	boolean leave(Vehicle v) {
		for (ParkingSpot spot: spots) {
			if (spot.getVehicle() == v) {
				spot.leaveVehicle();
				return true;
			}
		}
		return false;
	}
}
