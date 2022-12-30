/**
 * VIPAccount class
 * Refer to standardAccount java docs for
 * explanation of methods
 */
public class VIPAccount implements bankAccount {

    private final String name;
    private double currentBalance;

    /**
     * VIPAccount constructor
     */
    public VIPAccount(String name, double initialBalance){
        this.name = name;
        currentBalance = initialBalance;
        System.out.println("Account Created!!");
    }

    public String getName(){ return this.name; }
    public double getBalance(){
        return this.currentBalance;
    }
    public void display(){
        System.out.println("Name: " + name + "\nAccount Type: VIP\n" + "Balance: " + currentBalance);
    }
    public void withdraw(double withdrawAmount){
        currentBalance = currentBalance - withdrawAmount;
        System.out.println("Name: " + name + "\nBalance: " + currentBalance + "\n");
    }
    public void deposit(double depositAmount){
        currentBalance = currentBalance + depositAmount ;
        System.out.println("Name: " + name + "\nBalance: " + currentBalance + "\n");
    }
    public void calculateInterest(double month){
        double rate = 0.01;
        double interest = currentBalance * rate * month;
        System.out.println("The expected interest is: " + interest);
    }
}
