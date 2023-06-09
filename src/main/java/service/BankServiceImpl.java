package service;

import model.Account;

import java.util.ArrayList;
import java.util.List;

public class BankServiceImpl implements BankService {

    private final List<Account> accounts;

    public BankServiceImpl() {
        accounts = new ArrayList<>();
    }

    @Override
    public void createAccount(String accountNumber, String accountHolder, double balance, String accountType) {
        Account account = new Account(accountNumber, accountHolder, balance, accountType);
        accounts.add(account);
    }

    @Override
    public Account findAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    @Override
    public double getBalance(String accountNumber) {
        Account account = findAccount(accountNumber);
        if (account != null) {
            return account.getBalance();
        } else {
            throw new IllegalArgumentException("Account not found: " + accountNumber);
        }
    }

    @Override
    public void deposit(String accountNumber, double amount) {
        Account account = findAccount(accountNumber);

        if (account == null) {
            throw new IllegalArgumentException("Account not found.");
        }
        // Get the current balance of the account
        double currentBalance = account.getBalance();
        // Update the balance by adding the deposit amount
        double newBalance = currentBalance + amount;
        // Set the new balance to the account
        account.setBalance(newBalance);
        System.out.println("Deposit successful. New balance: " + newBalance);
    }

    @Override
    public void withdraw(String withdrawAccountNumber, double withdrawAmount) {
        Account account = findAccount(withdrawAccountNumber);

        if (account == null) {
            throw new IllegalArgumentException("Account not found");
        }

        double currentBalance = account.getBalance();
        if (currentBalance < withdrawAmount) {
            throw new IllegalArgumentException("Insufficient funds");
        }

        double newBalance = currentBalance - withdrawAmount;
        account.setBalance(newBalance);
    }


    @Override
    public void transferFunds(String fromAccountNumber, String toAccountNumber, double amount) {
        Account fromAccount = findAccount(fromAccountNumber);
        Account toAccount = findAccount(toAccountNumber);

        if (fromAccount == null || toAccount == null) {
            System.out.println("Invalid account number(s). Transfer failed.");
            return;
        }
        if (fromAccount.getBalance() < amount) {
            System.out.println("Insufficient funds. Transfer failed.");
            return;
        }
        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);

        System.out.println("Funds transferred successfully.");
    }

    @Override
    public void generateAccountStatement(String accountNumber) {
        Account account = findAccount(accountNumber);

        if (account == null) {
            System.out.println("Invalid account number. Cannot generate account statement.");
            return;
        }

        System.out.println("Account Statement for Account Number: " + account.getAccountNumber());
        System.out.println("Account Holder: " + account.getAccountHolderName());
        System.out.println("Balance: " + account.getBalance());
        // Additional logic to display transaction history or other relevant information
    }
}



