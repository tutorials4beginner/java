public class MainString {

	public static void main(String[] args) {
		String s1 = new String("abc");
		String s2 = new String("abc");
		System.out.println(s1);
		System.out.println(s2);
		
		
		if (s1.equals(s2)) {
			System.out.println("Both are same");
		}else{
			System.out.println("Not same");
		}
	}

}
