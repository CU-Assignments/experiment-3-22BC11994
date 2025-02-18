import java.util.Scanner;

class InvalidPinException extends Exception {
    public InvalidPinException(String message) {
        super(message);
    }
}
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

public class ATMWithdrawalSystem {
    private static final String correctPin = "1234"; 
    private double balance;
    public ATMWithdrawalSystem(double initialBalance) {
        this.balance = initialBalance;
    }
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance. Current Balance: " + balance);
        }
        balance -= amount;
        System.out.println("Withdrawal successful. Remaining balance: " + balance);
    }
    public void checkPin(String enteredPin) throws InvalidPinException {
        if (!enteredPin.equals(correctPin)) {
            throw new InvalidPinException("Error: Invalid PIN entered.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATMWithdrawalSystem atm = new ATMWithdrawalSystem(3000.0);
        System.out.print("Enter PIN: ");
        String enteredPin = scanner.nextLine();

        try {
            atm.checkPin(enteredPin);
            System.out.print("Enter amount to withdraw: ");
            double amount = scanner.nextDouble();
            atm.withdraw(amount);

        } catch (InvalidPinException e) {
          
            System.out.println(e.getMessage());
        } catch (InsufficientBalanceException e) {
           
            System.out.println(e.getMessage());
        } finally {
           
            System.out.println("Current balance: " + atm.balance);
            scanner.close();
        }
    }
}
