import java.util.Scanner;

public class Atm {
    private static double balance = 1000.0;
    private static int pin = 1234;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your PIN: ");
        int enteredPin = scanner.nextInt();

        if (enteredPin == pin) {
            int choice;
            do {
                System.out.println("Main Menu");
                System.out.println("1. check Balance");
                System.out.println("2. Withdrawal");
                System.out.println("3. Cash Deposit");
                System.out.println("4. Change PIN");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        showBalance();
                        break;
                    case 2:
                        withdraw(scanner);
                        break;
                    case 3:
                        deposit(scanner);
                        break;
                    case 4:
                        changePin(scanner);
                        break;
                    case 5:
                        System.out.println("Thank you for using the ATM.");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } while (choice != 5);
        } else {
            System.out.println("Incorrect PIN. Access denied.");
        }

        scanner.close();
    }

    private static void showBalance() {
        System.out.printf("Current Balance: $%.2f%n", balance);
    }

    private static void withdraw(Scanner scanner) {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (amount <= 0) {
            System.out.println("Invalid amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.printf("Withdrawal of $%.2f successful.%n", amount);
            showBalance();
        }
    }

    private static void deposit(Scanner scanner) {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        if (amount <= 0) {
            System.out.println("Invalid amount.");
        } else {
            balance += amount;
            System.out.printf("Deposit of $%.2f successful.%n", amount);
            showBalance();
        }
    }

    private static void changePin(Scanner scanner) {
        System.out.print("Enter new PIN: ");
        int newPin = scanner.nextInt();
        if (newPin < 1000 || newPin > 9999) {
            System.out.println("PIN must be a 4-digit number.");
        } else {
            pin = newPin;
            System.out.println("PIN changed successfully.");
        }
    }
}