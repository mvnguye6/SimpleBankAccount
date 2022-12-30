/**
 * standardAccount class
 * This class implements the interface bankAccount,
 * implementing the methods and variables declared in bankAccount
 * Lastly refer to main file for
 * implementation of functions 5 and 6
 */
public class standardAccount implements bankAccount {

    private final String name;
    private double currentBalance;

    /**
     * standardAccount constructor
     * This construction takes in the account holders name and initial balance
     * as parameters, and creates private variables to hold their bank account
     * information.
     */
    public standardAccount(String name, double initialBalance){
        this.name = name;
        currentBalance = initialBalance;
        System.out.println("Account Created!!");
    }

    public String getName(){return this.name;}
    public double getBalance(){return currentBalance;}

    /**
     * display method
     * This method prints out the client's bank account
     * information (name on the account and current balance).
     */
    public void display(){
        System.out.println("Name: " + name + "\nAccount Type: Standard\n" + "Balance: " + currentBalance);
    }

    /**
     * withdraw method
     * This method takes the current balance of a standardAccount
     * instance and subtracts the withdraw amount from their current balance.
     * Lastly, it displays how much is in their balance after the withdrawel.
     */
    public void withdraw(double withdrawAmount){
        currentBalance = currentBalance - withdrawAmount;
        System.out.println("Name: " + name + "\nBalance: " + currentBalance + "\n");
    }

    /**
     * deposit method
     * This method takes the current balance of a standardAccount
     * instance and adds the deposit to their current balance.
     * Lastly, it displays how much is in their balance after the deposit.
     */
    public void deposit(double depositAmount){
        currentBalance = currentBalance + depositAmount ;
        System.out.println("Name: " + name + "\nBalance: " + currentBalance + "\n");
    }

    /**
     * calculateInterest method
     * This method takes in the user's current balance, rate of a standardAccount and
     * the amount of months needed as parameters and calculates the Interest.
     */
    public void calculateInterest(double month){
        double rate = 0.005;
        double interest = currentBalance * rate * month;
        System.out.println("The expected interest is: " + interest);
    }
}
