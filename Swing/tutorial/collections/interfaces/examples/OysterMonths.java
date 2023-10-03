import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.text.DateFormatSymbols;

public class OysterMonths {
    Collection<String> safeMonths;

    public Collection<String> filter(Collection<String> c) {

	Collection<String> filteredCollection = new ArrayList<String>();

	for (Iterator<String> i = c.iterator(); i.hasNext(); ) {
	    String s = i.next();
	    if (condition(s)) {
		filteredCollection.add(s);
	    }
	}
	return filteredCollection;
    }

    public boolean condition(String s) {
	return s.contains("r");
    }

    public static void main(String[] args) {
	OysterMonths om = new OysterMonths();
	DateFormatSymbols dfs = new DateFormatSymbols();
	String[] monthArray = dfs.getMonths();
	Collection<String> months = Arrays.asList(monthArray);
	om.safeMonths = om.filter(months);
	System.out.println("The following months are safe for oysters:");
	System.out.println(om.safeMonths);
    }
}
