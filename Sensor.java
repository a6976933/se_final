
import java.util.*;

public class Sensor {
	public int switch_id;
	public String type;
	public List<pair<time, packet_count>> event;
	public Scenario system;
	public Boolean direction;
	public package_in(package Package) {
		system.switches[switch_id].package_in(package);
	}
	public Package package_out(id int) {
		Package out_pack;
		out_pack = system.switches[switch_id].package_out();
		if(system.switches[switch_id].get_direction() == false) {
			system.set_switch(2*switch_id+1);
		} else {
			system.set_switch(2*switch_id+2);
		}
	}
}
