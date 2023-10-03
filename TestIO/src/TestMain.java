import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		try {
			int n = Integer.parseInt(br.readLine());
			float f = Float.parseFloat(br.readLine());
			System.out.println(n+10);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
