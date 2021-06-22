
import java.util.*;

public class Switch {
	public int id;
	public Boolean direction;
	public Queue<Package> now_package;
	public Queue<Package> true_in;
	public Scenario2 system;
	public Switch(id int, scenario Scenario2) {
		this.id = id;
		this.system = scenario;
		this.now_package = new LinkedBlockingQueue<Package>();
		this.true_in = new LinkedBlockingQueue<Package>();
	}
	public package_in(pack Package) {
		this.now_package.offer(pack);
	}
	public Package package_out() {
		Package out_pack;
		out_pack = this.now_package.poll();
		return out_pack;
	}
	public Boolean get_direction() {
		return this.direction;
	}
}