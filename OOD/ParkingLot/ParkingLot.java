
public class ParkingLot {
	private final ParkingLevel[] levels;
	
	ParkingLot(int numLevels, int numSpotsPerLevel) {
		levels = new ParkingLevel[numLevels];
		for (int i = 0; i < numLevels; i++) {
			levels[i] = new ParkingLevel(numSpotsPerLevel);
		}
	}
	
	public boolean hasSport(Vehicle v) {
		for (ParkingLevel level: levels) {
			if (level.hasSport(v)) {
				return true;
			}
		}
		 return false;
	}
	
	public boolean park(Vehicle v) {
		for(ParkingLevel level:levels) {
			if (level.hasSport(v)) {
				level.park(v);
				return true;
			}
		}
		return false;
	}
	
	public boolean leave(Vehicle v) {
		for(ParkingLevel level:levels) {
			if (level.leave(v)) {
				return true;
			}
		}
		return false;
	}
}
