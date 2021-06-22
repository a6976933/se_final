
import java.util.*;

public class Scenario2 {
	public List<Switch> switches;
	public List<Package> packages;
	public List<Sensor> sensors;
	public List<Bin> bins;
	public List<Pipe> pipes;
	private List<String> command;
	
	public Scenario2(List<String> input) {
		this.command = new ArrayList<String>();
		this.command = input;
	}
	
	public void solve() {
		int bin_num = Integer.parseInt(command.get(0));
		int package_num = Integer.parseInt(command.get(1));
		List<pair<String, String>> packagelist = new ArrayList<pair<String, String>>();
		for(int i = 0; i < package_num; i++) {
			String cmd = command.get(i+2);
			String[] cmd1 = cmd.split("\\s+");
			Package pack = new Package(Integer.parseInt(cmd1[0]), Integer.parseInt(cmd1[1]));
			this.packages.add(pack);
		}
		for(int i = 0;i < bin_num; i++) {
			Bin bin = new Bin(i);
			this.bins.add(bin);
		}
		
		for(int i = 0; i < bin_num; i++) {
			this.create_Switch(i);
			this.create_Sensor(i);
		}
		for(int i = 0; i < 2*bin_num-1; i++) {
			this.create_Pipe(i);
		}
		List<Package> now_pack = new ArrayList<Package>();
		for(int i = package_num+1; i < command.size(); i++) {
			int now_inr = -1;
			String[] cmd_arr = command.get(i).split("\\s+");
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
					now_pack.add(packages.get(now_inr+j));
					this.pipes.get(0).package_in(packages.get(now_inr+j));
				}
				now_inr += pass_num;
			} else {
				sw_id = Integer.parseInt(cmd_arr[3].substring(6));
				if(!in_out) {
					if(cmd_arr[4] == "L") {
						dir = false;
					} else {
						dir = true;
					}
					set_switch_dir(sw_id, dir);
					if(!dir) {
						this.set_switch(time,2*sw_id,dir);
					} else {
						this.set_switch(time,2*sw_id+1,dir);
					}
					for(int k = 0;k < pass_num; k++) {
						now_pack.add(this.switches.get(sw_id).package_out());
					}
					if(dir = false) {
						for(int j = 0; j < pass_num; j++) {
							this.pipes.get(2*sw_id-1).package_in(now_pack.get(j));
						}
					} else {
						for(int j = 0; j < pass_num; j++) {
							this.pipes.get(2*sw_id).package_in(now_pack.get(j));
						}
					}
				} else {
					for(int j = 0; j < pass_num; j++) {
						now_pack.add(this.pipes.get(sw_id-1).package_out());
					}
					for(int j = 0; j < pass_num; j++) {
						this.switches.get(sw_id).package_in(now_pack.get(j));
					}
				}
			}
			
		}
		
		
	}
	
	public void create_Switch(int ids) {
		Switch swit = new Switch(ids);
		this.switches.add(swit);
	}
	
	public void create_Sensor(int id) {
		Sensor sensor = new Sensor(id);
		this.sensors.add(sensor);
	}
	
	public void create_Pipe(int id) {
		Pipe pipe = new Pipe(id);
		this.pipes.add(pipe);
	}
	
	public void set_switch_dir(int id, Boolean dir) {
		this.switches.get(id).direction = dir;
	}
	
	public void set_switch(int time, int id, Boolean dir){
		String direct = "L";
		if(dir) {
			direct = "R";
		}
		this.switches.get(id).isSet = true;
		System.out.printf("%d set switch%d %s", time, id, direct);
	}
}