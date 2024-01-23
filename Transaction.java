package com.javahongkong.bootcamp.exercise;

public class Transaction {
	private Long accountNumber;
	private Bank bank;

	/**
	 *
	 * @param bank The bank where the account is housed.
	 * @param accountNumber The customer's account number.
	 * @param attemptedPin The PIN entered by the customer.
	 * @throws Exception Account validation failed.
	 */
	public Transaction(Bank bank, Long accountNumber, int attemptedPin)
			throws Exception {
		// complete the function
		this.bank = bank;
		this.accountNumber = accountNumber;
		if (!bank.getAccount(accountNumber).validatePin(attemptedPin))
			throw new NullPointerException("Please Insert the correct Pin");
	}

	public double getBalance() {
		// complete the function
		return this.bank.getAccount(this.accountNumber).getBalance();
	}

	public void credit(double amount) {
		// complete the function
		this.bank.credit(this.accountNumber, amount);
	}

	public boolean debit(double amount) {
		// complete the function
		if (this.bank.getAccount(this.accountNumber) == null)
			return false;
		return this.bank.debit(this.accountNumber, amount);
	}
}
