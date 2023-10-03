public class Account {
	int acc_bal = 10000;

	void withdraw(int amount) throws MyException {
		if (amount > acc_bal) {
			throw new MyException("Insufficient balance");
		}
	}
}
