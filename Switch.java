
import java.util.*;

public class Switch {
	public int id;
	public Boolean direction;
	public Queue<Package> now_package;
	public Scenario system;
	public package_in(package Package) {
		now_package.
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