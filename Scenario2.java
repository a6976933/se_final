
import java.util.*;

public class Scenario2 {
	public List<Switch> switches;
	public List<Package> packages: 
	public List<Sensor> sensors;
	public List<Bin> bins;
	public List<Pipe> pipes;
	public static void Main(Strings[] args) {
		this.solve();
	}
	public solve() {
		int bin_num = 4;
		int package_num = 2;
		List<pair<String, String>> packagelist = new ArrayList<pair<string, string>>;
		packagelist.add(new Pair<String, String>("package0", "bin0"))
		packagelist.add(new Pair<String, String>("package1", "bin1"))
		for(int i = 0;i < bin_num; i++) {
			Bin bin = new Bin(i);
			this.bins.add(bin);
		}
		for(int i = 0; i < packagelist.size(); i++) {
			int pack_id = packagelist[i].getKey().substring(7).parseInt();
			int bin_id = packagelist[i].getValue().substring(3).parseInt();
			Package pack = new Package(packagelist[i].getKey(),bins[bin_id]);
			this.packages.add(pack);
		}
		List<String> command = new ArrayList<String>();
		command.add("0 out 1 sourceStation");
		command.add("2 in 1 switch0");
		command.add("5 out 1 switch0 L");
		command.add("5 out 1 sourceStation");
		command.add("6 in 1 switch0");
		command.add("7 out 1 switch0 L");
		command.add("8 in 1 switch1");
		command.add("10 out 1 siwtch1 L");
		command.add("12 in 1 switch1");
		command.add("13 out 1 switch1 R");
		for(int i = 0; i < bin_num; i++) {
			this.create_Switch(i);
			this.create_Sensor(i);
		}
		for(int i = 0; i < 2*bin_num-1; i++) {
			this.create_Pipe(i);
		}
		List<Package> now_pack = new ArrayList<Package>();
		for(int i = 0; i < command.size(); i++) {
			int now_inr = -1;
			String [] cmd_arr = command.split("\\s+");
			int time = Integer.parseInt(cmd_arr[0]);
			Boolean in_out;
			int sw_id;
			Boolean dir;
			if(cmd_arr[1] == "in"){
				in_out = true;
			} else {
				in_out = false;
			}
			int pass_num = Integer.parseInt(cmd_arr[2]);
			if(cmd_arr[3] == "sourceStation") {
				sw_id = 0;
				for(int j = 0; j < pass_num; j++) {
					now_pack.add(packages[now_inr+j]);
					this.pipes[0].package_in(packages[now_inr+j])
				}
				now_inr += pass_num;
			} else {
				sw_id = cmd_arr[3].substring(6).parseInt();
				if(pass_num > 1) {
					if(in_out) {
						
					}
				}
				if(this.switches[sw_id].true_in.size() > 1) {
					int dest = this.switches[sw_id].true_in.peek().name
					for(Package tmp_pack: this.switches[sw_id].true_in) {
						
					}
				}
				if(!in_out) {
					if(cmd_arr[4] == "L") {
						dir = false;
					} else {
						dir = true;
					}
					set_switch_dir(sw_id, dir);
					if(!dir) {
						system.set_switch(time,2*sw_id,dir);
					} else {
						system.set_switch(time,2*sw_id+1,dir);
					}
					for(int k = 0;k < pass_num; k++) {
						now_pack.add(this.sensors[k].package_out());
					}
					if(dir = false) {
						for(int j = 0; j < pass_num; j++) {
							this.pipes[2*sw_id-1].package_in(now_pack[j]);
						}
					} else {
						for(int j = 0; j < pass_num; j++) {
							this.pipes[2*sw_id].package_in(now_pack[j]);
						}
					}
				} else {
					for(int j = 0; j < pass_num; j++) {
						now_pack.add(this.pipes[sw_id-1].package_out());
					}
					for(int j = 0; j < pass_num; j++) {
						this.switches[sw_id].package_in(now_pack[j]);
					}
				}
			}
			
		}
		
		
	}
	public create_Switch(id int) {
		Switch swit = new Switch(id, this);
		this.switches.add(swit);
	}
	public create_Sensor(id int) {
		Sensor sensor = new Sensor(id, this);
		this.sensors.add(sensor);
	}
	public create_Pipe(id int) {
		Pipe pipe = new Pipe(id, this);
		this.pipes.add(pipe);
	}
	public set_switch_dir(id int, dir Boolean) {
		this.switches[id].direction = dir;
	}
	public set_switch(time int,id int, dir Boolean) {
		String direct = "L";
		if(dir) {
			direct = "R"
		}
		this.switches[id].isSet = true;
		System.out.printf("%d set switch%d %s", time, id, direct);
	}
}