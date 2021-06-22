import java.util.*;

public class Bin {
    int id;
    List<Package> reality_packages;

    public Bin(int id) {
        this.id = id;
        this.reality_packages = new ArrayList<Package>();
    }

    public void addPackage(Package p) {
        reality_packages.add(p);
    }

    public int getId() {
        return this.id;
    }

    public List<Package> getPackages() {
        return this.reality_packages;
    }
}
