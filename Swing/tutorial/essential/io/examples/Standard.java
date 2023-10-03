import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Standard {

    public static void main(String args[]) throws IOException {
        BufferedReader cin = 
            new BufferedReader(new InputStreamReader(System.in));
        String number;
        int total = 0;

        while ((number = cin.readLine()) != null) {
            try {
                total += Integer.parseInt(number);
            } catch (NumberFormatException e) {
                System.err.println("Invalid number in input");
                System.exit(1);
            }
        }
        System.out.println(total);
    }
}

        
