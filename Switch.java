
import java.util.*;

public class Switch {
	public int id;
	public Boolean direction;
	public Queue<Package> now_package;
	public Queue<Package> true_in;
	public Boolean isSet;
	public Switch(id int) {
		this.id = id;
		this.now_package = new LinkedBlockingQueue<Package>();
		this.true_in = new LinkedBlockingQueue<Package>();
		this.isSet = false;
	}
	public package_in(Package pack) {
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