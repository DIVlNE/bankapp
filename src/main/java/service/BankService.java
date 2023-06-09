package service;

import model.Account;

public interface BankService {

    void createAccount(String accountNumber, String accountHolder, double balance, String accountType);

    Account findAccount(String accountNumber);

    void transferFunds(String fromAccountNumber, String toAccountNumber, double amount);

    void generateAccountStatement(String accountNumber);

    double getBalance(String accountNumber);

    void deposit(String accountNumber, double amount);

    void withdraw(String withdrawAccountNumber, double withdrawAmount);
}




