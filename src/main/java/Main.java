import service.BankService;
import service.BankServiceImpl;
import ui.UserInterface;


public class Main {
    public static void main(String[] args) {
        BankService bankService = new BankServiceImpl();
        UserInterface userInterface = new UserInterface();

        userInterface.displayMenu();

    }
}


//        BankService bankService = new BankServiceImpl(); // Create an instance of the BankService implementation
//        TransactionService transactionService = new TransactionServiceImpl();
//        bankService.createAccount("6546541331", "dylan", 100000, "Savings");
//        bankService.createAccount("6546541332", "ken", 100000, "Savings");
//        bankService.createAccount("6546541333", "fong", 100000, "Savings");
//
//        // Perform operations on the accounts
//        Account account1 = bankService.findAccount("6546541331");
//        Account account2 = bankService.findAccount("6546541332");
//        Account account3 = bankService.findAccount("6546541333");
//
//        transactionService.withdraw(account1, 100);
//        transactionService.withdraw(account2, 200);
//        transactionService.withdraw(account3, 300);
//
//        // Print account information
//        for (Account account : Arrays.asList(account1, account2, account3)) {
//            System.out.println(account.getAccountHolderName() + " Account balance: " + account.getBalance());
//        }
//
//        // Withdraw & Transfer
//        transactionService.deposit(account1, 5000.0);
//        transactionService.transferFunds(account1, account2, 20000.0);
//        transactionService.transferFunds(account2, account3, 5000.0);
//
//        // check balance afterwards
//        for (Account account : Arrays.asList(account1, account2, account3)) {
//            System.out.println(account.getAccountHolderName() + " Account balance: " + account.getBalance());
//        }
//
//    }