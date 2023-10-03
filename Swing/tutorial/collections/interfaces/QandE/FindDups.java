import java.util.*;

public class FindDups {

    public static void main(String[] args) {
        Comparator<String> comparator = new Comparator<String>() {
            public int compare (String s1, String s2) {
                return s1.compareToIgnoreCase(s2);
            }
        };

        SortedSet<String> s = new TreeSet<String>(comparator);
        for (String a : args)
            if (!s.add(a))
                System.out.println("Duplicate detected: " + a);

        System.out.println(s.size() + " distinct words: " + s);
    }
}
