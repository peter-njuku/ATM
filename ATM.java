import java.util.Scanner;

public class ATM{
    private String accountNumber;
    private String accountHolder;
    private double balance;

    public ATM(String accountNumber, String accountHolder, double balance){
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }
    public double checkbalance(){
        return balance;
    }
    public void deposit(double amount){
        if (amount > 0){
            balance += amount;
            System.out.println("Deposit Successful. New balance: $" + balance);
        } else {
            System.out.println("Depposit must be positive.");
        }
    }
    public void withdraw(double amount){
        if (amount > 0 && amount <= balance){
            balance -= amount;
            System.out.println("Withdraw successful. New balance: $" + balance);
        }else if(amount > balance){
            System.out.println("Insufficient balance.");
        }else{
            System.out.println("Withdraw amount should be positive.");
        }
    }
    public void transfer(double amount){
        if (amount > 0 && amount <= balance){
            balance -= amount;
            System.out.println("Transfer Successful. New balance: $"+ balance);
        }else if (amount > balance){
            System.out.println("Insuficient balance.");
        }else{
            System.out.println("Transfer amount should be positive.");
        }
    }
    public static void main(String[] args){
        ATM myAccount = new ATM("1234567890123", "Peter Njuku", 10000.00);
        System.out.println("The balance is: "+ myAccount.checkbalance());
        Scanner scanner = new Scanner(System.in);
        int choice;
        double amount;
        do{
            System.out.println("\n--------ATM Menu--------");
            System.out.println("1. Deposit");
            System.out.println("2. Check balance");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Exit");
            System.out.println("Choose an option: ");
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Current balance: $"+myAccount.checkbalance());
                    System.out.println("Enter amount to deposit: ");
                    amount = scanner.nextDouble();
                    myAccount.deposit(amount);
                    break;
                
                case 2:
                    System.out.println("Your current balance is: $"+  myAccount.checkbalance());
                    break;

                case 3:
                    System.out.println("Enter the amount to withdraw: ");
                    amount = scanner.nextDouble();
                    myAccount.withdraw(amount);
                    break;
                
                case 4:
                    System.out.println("Enter amount to transfer to recipient: ");
                    amount = scanner.nextDouble();
                    myAccount.transfer(amount);
                    break;

                case 5:
                    System.out.println("Thank you for using the ATM.");
                    break;
                
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
                    break;
            }
        }while (choice != 5);

        scanner.close();
    }
}