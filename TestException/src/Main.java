public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*int res = 0;
		try {
			res = new A().div(10, 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(res);
		*/
		//-------------------------------------
		try {
			new Account().withdraw(2000);
		} catch (MyException e) {
			//e.printStackTrace();
		}
		
	}
}
