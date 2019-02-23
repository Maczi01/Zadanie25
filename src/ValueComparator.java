import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
public class ValueComparator implements Comparator {

    private Map map;

    public ValueComparator(Map map) {
        this.map = map;
    }

    @Override
    public int compare(Object keyA, Object keyB) {
        Comparable valueA = (Comparable) map.get(keyA);
        Comparable valueB = (Comparable) map.get(keyB);
        return valueB.compareTo(valueA);
    }
}
