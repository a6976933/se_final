
import java.util.*;

public class Sensor {
	public int switch_id;
	public String type;
	public List<pair<time, packet_count>> event;
	public Scenario2 system;
	public Boolean direction;
	public Sensor(switch_id int, scenario Scenario2) {
		this.switch_id = switch_id;
		this.system = scenario;
	}
	public package_in(pack Package) {
		//system.switches[switch_id].package_in(pack);
	}
	public Package package_out() {
		Package out_pack;
		out_pack = system.switches[switch_id].package_out();
	}
}
