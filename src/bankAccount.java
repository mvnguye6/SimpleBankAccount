
/***
 * Interface declaration for bankAccount.
 * This interface declares all the methods needed for
 * the SimpleBankAccount project, required any class that
 * implements it to fill out the declared methods.
 */
public interface bankAccount {
    public String getName();
    public double getBalance();
    public void display();
    public void withdraw(double withdrawAmount);
    public void deposit(double depositAmount);
    public void calculateInterest(double month);
}
