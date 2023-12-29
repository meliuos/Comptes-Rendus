public class BankAccount {
    private int accountNumber;
    private String accountHolderName;
    private int balance;

    // Constructor
    public BankAccount(int accountNumber, String accountHolderName, int balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    // Getter methods
    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public int getBalance() {
        return balance;
    }

    // Deposit method
    public void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
            System.out.println("New Balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount. Amount must be greater than 0.");
        }
    }

    // Withdraw method
    public void withdraw(int amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                System.out.println("Withdrawn: $" + amount);
                System.out.println("New Balance: $" + balance);
            } else {
                System.out.println("Insufficient funds. Cannot withdraw $" + amount);
            }
        } else {
            System.out.println("Invalid withdrawal amount. Amount must be greater than 0.");
        }
    }

    public static void main(String[] args) {
        // Example usage of BankAccount
        BankAccount myAccount = new BankAccount(123456, "John Doe", 1000);

        System.out.println("Account Number: " + myAccount.getAccountNumber());
        System.out.println("Account Holder: " + myAccount.getAccountHolderName());
        System.out.println("Balance: $" + myAccount.getBalance());

        myAccount.deposit(500);
        myAccount.withdraw(200);
    }
}
