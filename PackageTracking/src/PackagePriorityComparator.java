import java.util.*;

class PackagePriorityComparator implements Comparator<Package> {
    private int getP(String priority) {
        switch (priority) {
            case "HIGH": return 3;
            case "MEDIUM": return 2;
            case "LOW": return 1;
            default: return 0;
        }
    }

    @Override
    public int compare(Package p1, Package p2) {
        
        return getP(p2.getPriority()) - getP(p1.getPriority());
    }
}