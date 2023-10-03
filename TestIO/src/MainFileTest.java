import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MainFileTest {
	public static void main(String[] args) {
		int i;
		try {
			FileInputStream fis = new FileInputStream("Test.txt");
			do {
				i = fis.read();
				//System.out.print(i);
				if (i != -1)
					System.out.print((char) i);
			} while (i != -1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
