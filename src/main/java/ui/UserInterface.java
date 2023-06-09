package ui;

import service.BankService;
import service.BankServiceImpl;

import java.util.Scanner;

public class UserInterface {
    public UserInterface() {

    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        // Instantiate the BankService and TransactionService implementations
        BankService bankService = new BankServiceImpl();


        while (!exit) {
            System.out.println("GJ Bank Menu:");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Transfer Funds");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character after reading the integer input

            switch (choice) {
                case 1:
                    // Create Account
                    System.out.print("Enter account number: ");
                    String accountNumber = scanner.nextLine();
                    System.out.print("Enter account holder name: ");
                    String accountHolder = scanner.nextLine();
                    System.out.print("Enter initial balance: ");
                    double initialBalance = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character after reading the double input
                    System.out.print("Enter account type: ");
                    String accountType = scanner.nextLine();

                    // Invoke the createAccount method from the BankService class
                    bankService.createAccount(accountNumber, accountHolder, initialBalance, accountType);
                    break;
                case 2:
                    // Deposit Money
                    System.out.print("Enter account number: ");
                    String depositAccountNumber = scanner.nextLine();
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character after reading the double input

                    //  transactionService.deposit(bankService.findAccount(depositAccountNumber), depositAmount);
                    // Invoke the deposit method from the TransactionService class
                    try {
                        bankService.deposit(depositAccountNumber, depositAmount);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 3:
                    // Withdraw Money
                    System.out.print("Enter account number: ");
                    String withdrawAccountNumber = scanner.nextLine();
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character after reading the double input

                    // Invoke the withdraw method from the TransactionService class
                    // transactionService.withdraw(bankService.findAccount(withdrawAccountNumber), withdrawAmount);
                    // try and catch
                    try {
                        bankService.withdraw(withdrawAccountNumber, withdrawAmount);
                        System.out.println("Withdrawal successful. New balance: " + withdrawAmount);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }

                    break;
                case 4:
                    // Check Balance
                    System.out.print("Enter account number: ");
                    String checkBalanceAccountNumber = scanner.nextLine();

                    // Invoke the getBalance method from the BankService class
                    double balance = bankService.getBalance(checkBalanceAccountNumber);
                    System.out.println("Account balance: " + balance);
                    try {
                        double chkbal = bankService.getBalance(checkBalanceAccountNumber);
                        System.out.println("Current balance: " + chkbal);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                //
                case 5:
                    // Transfer Funds
                    System.out.print("Enter source account number: ");
                    String sourceAccountNumber = scanner.nextLine();
                    System.out.print("Enter destination account number: ");
                    String destinationAccountNumber = scanner.nextLine();
                    System.out.print("Enter transfer amount: ");
                    double transferAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character after reading the double input

                    // Invoke the transferFunds method from the TransactionService class
                    // transactionService.transferFunds(bankService.findAccount(sourceAccountNumber), bankService.findAccount(destinationAccountNumber), transferAmount);
                    try {
                        bankService.transferFunds(sourceAccountNumber, destinationAccountNumber, transferAmount);
                        System.out.println("Funds transferred successfully.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 6:
                    // Exit the application
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

            System.out.println(); // Add a line break for better readability
        }

        System.out.println("Thank you for using GJ Bank. Goodbye!");
    }
}