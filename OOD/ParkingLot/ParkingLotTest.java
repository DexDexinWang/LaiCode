
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ParkingLotTest {

	@Test
	public void test() {
		ParkingLot lot = new ParkingLot(4, 20);
		List<Vehicle> list = new ArrayList<>();
		for(int i = 0; i < 50; i++) {
			final Vehicle v = i% 2 == 0 ? new Sedan(): new Truck();
			list.add(v);
			boolean hasSpot = lot.hasSport(v);
			if (i < 20) {
				assert hasSpot;
				assert lot.park(v);
			} else {
				assert !hasSpot;
				assert !lot.park(v);
			}
		}
		
		assert list.size() == 50;
		int i = 0;
		for (Vehicle v : list) {
			assert i >= 40 || lot.leave(v);
			i++;
		}	
	}
}
