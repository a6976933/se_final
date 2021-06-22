import java.util.*;
import java.io.*;

public class Scenario3 {
    private List<Package> packages;
    private List<Bin> bins;

    public Scenario3(List<String> expected, List<String> real) {
        this.packages = new ArrayList<>();
        this.bins = new ArrayList<>();
        Map<String, Packet> package_identifier;

        for(int i = 0; i < expected.size(); i++) {
            String[] package_info = expected.get(i).split(' ');
            String package_name = package_info[0];
            Bin destination = new Bin(package_info[1].charAt(3) - '0');
            Package package = new Package(package_name, destination);
            this.packages.add(package);
            package_identifier.put(package_name, package);
        }

        for(int i = 0; i < real.size(); i++) {
            String[] bin_info = real.get(i).split(' ');
            int bin_id = bin_info[0].charAt(3) - '0';
            Bin bin = new Bin(bin_id);

            for(int j = 1; j < bin_info.length; j++) {
                Package package = packet_identifier(bin_info[j]);
                this.bins.addPackage(package);
            }
        }
    }

    public void solve() {      
        // Compare the real destinations with the expected ones
        for(int i = 0; i < this.bins.length; i++) {
            List<Package> actual_packages = this.bins[i].reality_packages();
            for(int j = 0; j < actual_packages.size(); j++) {
                Package package = actual_packages.get(j);
                if(package.destination.id != this.bins[i].id) {
                    System.out.printf("%s bin%d\n", package_name, bins[i].getId);
                }
            }
        }
    }
}