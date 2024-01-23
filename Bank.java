package com.javahongkong.bootcamp.exercise;

import java.util.LinkedHashMap;

public class Bank {
	private LinkedHashMap<Long, Account> accounts; // object reference

	private static long counter = 0;

	public Bank() {
		// complete the function
		this.accounts = new LinkedHashMap<>();
	}

	public Account getAccount(Long accountNumber) {
		// complete the function
		return accounts.get(accountNumber);
	}

	public Long openCommercialAccount(Company company, int pin,
			double startingDeposit) {
		// complete the function
		CommercialAccount commercialAccount =
				new CommercialAccount(company, counter++, pin, startingDeposit);
		this.accounts.put(commercialAccount.getAccountNumber(), commercialAccount);
		return commercialAccount.getAccountNumber();
	}

	public Long openConsumerAccount(Person person, int pin,
			double startingDeposit) {
		// complete the function
		ConsumerAccount consumerAccount =
				new ConsumerAccount(person, counter++, pin, startingDeposit);
		this.accounts.put(consumerAccount.getAccountNumber(), consumerAccount);
		return consumerAccount.getAccountNumber();
	}

	public boolean authenticateUser(Long accountNumber, int pin) {
		// complete the function
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(accountNumber).getAccountNumber().equals(accountNumber)
					&& accounts.get(accountNumber).getPin() == pin)
				return true;
		}
		return false;
	}

	public double getBalance(Long accountNumber) {
		// complete the function
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.containsKey(accountNumber))
				return accounts.get(accountNumber).getBalance();
		}
		return -1.0d;
	}

	public void credit(Long accountNumber, double amount) {
		// complete the function
		this.accounts.get(accountNumber).creditAccount(amount);


	}

	public boolean debit(Long accountNumber, double amount) {
		if (this.accounts.get(accountNumber) == null)
			return false;
		else {
			return this.accounts.get(accountNumber).debitAccount(amount);
		}
	}
}
