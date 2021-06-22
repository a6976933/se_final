import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        File DataFile = new File(args[0]);
        BufferedReader reader = new BufferedReader(new FileReader(DataFile));
        String l;
        l = reader.readLine();
        if(l.equals("SCENARIO1")) {
            int delay_time = Integer.parseInt(reader.readLine());
            int bin_num = Integer.parseInt(reader.readLine());
            int package_num = Integer.parseInt(reader.readLine());
            List<String> packages = new ArrayList<String>();
            List<String> bins = new ArrayList<String>();
            for(int i=0;i<package_num;i++) {
                l = reader.readLine();
                String[] tokens = l.split(" ");
                String p = tokens[0];
                String bin = tokens[1];
                packages.add(p);
                bins.add(bin);
            }
            Scenario1 s = new Scenario1(delay_time, bin_num, package_num, packages, bins);
            s.solve();
        } else if(l.equals("SCENARIO3")) {
            int package_num = Integer.parseInt(reader.readLine());
            List<String> expected = new ArrayList<String>();
            List<String> real = new ArrayList<String>();
            for(int i=0;i<package_num;i++) {
                l = reader.readLine();
                expected.add(l);
            }
            while((l = reader.readLine()) != null) {
                real.add(l);
            }

            Scenario3 s = new Scenario3(expected, real);
            s.solve();
        } else if(l.equals("SCENARIO2")) {
            
        } else {
            
        }
    }
}
