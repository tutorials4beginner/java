import java.io.*;

public class PrintfStuff {
    public static void main(String[] args) throws IOException {
        char three[] = {'t', 'h', 'r', 'e', 'e'};
        System.out.printf("%b %n %c %n %s %n %s %n %d %n" +
                          "%d %n %g %n %g %n %s %n",
                ! false, '3', new String(three), "Three", 3,
                Long.MAX_VALUE, Math.PI, Double.MAX_VALUE,
                new Object());
    }
}
