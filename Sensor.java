
import java.util.*;

public class Sensor {
	public int switch_id;
	public String type;
	public List<pair<time, packet_count>> event;
	public Boolean direction;
	public Sensor(int switch_id) {
		this.switch_id = switch_id;
	}
}
