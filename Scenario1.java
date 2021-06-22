import java.util.*;
import java.io.*;

class Scenario1 {
    int delay_time;
    int bin_num;
    int package_num;
    List<Package> package_list;

    public Scenario1(int delay_time, int bin_num, int package_num, List<String> packages, List<String> bins) {
        this.delay_time = delay_time;
        this.bin_num = bin_num;
        this.package_num = package_num;
        package_list = new ArrayList<>();
        
        for(int i=0;i<packages.size();++i) {
            String package_name = packages.get(i);
            String bin_name = bins.get(i);
            Bin bin = new Bin(bin_name.charAt(3) - '0');
            Package p = new Package(package_name, bin);
            package_list.add(p);
        }
    }

    void solve() {
        System.out.println(0);
        System.out.print(package_list.get(0).name);
        int previous_id = package_list.get(0).destination.id;
        int now = 0;
        for(int i=1;i<package_list.size();++i) {
            Package p = package_list.get(i);
            if(p.destination.id != previous_id) {
                previous_id = p.destination.id;
                now += delay_time;
                System.out.println();
                System.out.println(now);
                System.out.print(p.name);
            } else {
                System.out.printf(" %s", p.name);
            }
        }
    }
}
