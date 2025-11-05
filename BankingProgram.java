import java.util.Scanner;

public class BankingProgram {
    static Scanner scanner = new Scanner(System.in);

    public static void main (String[] args){
        // BANKING PROGRAM FOR BEGINNERS
        // DECLARE VARIABLES
        double balance = 0;
        boolean isRunning = true; // We will define a while loop because the code should run until the user exits
        int choice;
        while (isRunning){
        // DISPLAY THE MENU
            System.out.println("-------------------");
            System.out.println("| BANKING PROGRAM |");
            System.out.println("|-----------------|");
            System.out.println("|1. Show Balance  |");
            System.out.println("|2. Deposit Funds |");
            System.out.println("|3. Withdraw Funds|");
            System.out.println("|4. Exit          |");
            System.out.println("-------------------");

        // GET AND PROCESS USERS CHOICE
            System.out.print("Enter your choice (1-4): ");
            choice = scanner.nextInt();
            switch (choice){
                case 1 -> showBalance(balance);
                case 2 -> balance += deposit();
                case 3 -> balance -= withdraw(balance);
                case 4 -> isRunning = false;
                default -> System.out.println("INVALID CHOICE");
            }
        }

        // EXIT MESSAGE
        System.out.println("---------------------------");
        System.out.println("Thank you, have a nice day!");
        System.out.println("---------------------------");

        scanner.close();
    }

    // showBalance()
    static void showBalance(double balance){
        System.out.println("-------------------");
        System.out.printf("--> Your account balance is $%.2f\n", balance);
    }
    // deposit()
    static double deposit(){
        double amount;
        System.out.print("Enter an amount to be deposited: ");
        amount = scanner.nextDouble();
        if (amount < 0){
            System.out.println("The deposit amount can't be negative.");
            return 0;
        }
        else{
            return amount;
        }

    }
    // withdraw()
    static double withdraw(double balance){
        double amount;
        System.out.print("Please enter the amount to withdraw: ");
        amount = scanner.nextDouble();
        if (amount > balance){
            System.out.printf("You don't have enough funds for that withdrawal. Your balance is $%.2f\n", balance);
            System.out.print("Please enter a valid amount to withdraw: ");
            amount = scanner.nextDouble();
        }
        else if (amount < 0) {
            System.out.println("Withdraw amount can't be negative");
            System.out.print("Please enter a valid amount to withdraw: ");
            amount = scanner.nextDouble();
        }
        else{
            System.out.printf("You have successfully withdrawn $%.2f\n", amount);
        }
        return balance -= amount;
    }

}
