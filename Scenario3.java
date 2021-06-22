import java.util.*;

public class Scenario3 {
    public void solve(Package[] packages, Bin[] bins) {      
        // Find expected destination of each packet
        Map<String, Integer> expected_bins;
        for(int i = 0; i < packages.length; i++) {
            expected_bins.put(packages[i].name, new Integer(packages[i].destination.getId()));
        }

        // Compare the real destinations with the expected ones
        for(int i = 0; i < bins.length; i++) {
            List<Package> actual_packages = bins[i].getPackages();
            for(int j = 0; j < actual_packages.size(); j++) {
                String package_name = actual_packages.get(j).name;
                if(expected_bins.get(package_name) != bins[i].getId) {
                    System.out.printf("%s bin%d\n", package_name, bins[i].getId);
                }
            }
        }
    }
}