import java.util.*;
import static java.lang.System.exit;

/**
 * Main function
 * Run infinite while loop to continuosly print menu message and scan
 * for inputs based on the user's desired command. Within while loop, create two hashmaps
 * (standardMap and VIPMap)to hold bankAccount objects.
 */
public class Main {

    public static void main(String[] args) {

        HashMap<String, bankAccount> standardMap = new HashMap<>();
        HashMap<String, bankAccount> VIPMap = new HashMap<>();

        int command;
        while(true){
            System.out.println("""

                    *** Menu ***
                    1. Create Account
                    2. Display
                    3. Withdraw
                    4. Deposit
                    5. Display All
                    6. Remove Account
                    7. Calculate Interest
                    8. Exit
                    """);
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter your choice: ");
            String input = scan.next();
            try{
                command = Integer.parseInt(input);
            }
            catch (NumberFormatException nfe){
                System.out.println('\n' + "Wrong Choice!!");
                continue;
            }
            switch (command){
                case 1:
                    System.out.println("""

                            **Create New Account**
                            1. Create Standard Account\s
                            2. Create VIP Account
                            Enter your choice:\s""");

                    String accountType_temp = scan.next();
                    int accountType;
                    try{
                        accountType = Integer.parseInt(accountType_temp);
                    }
                    catch (NumberFormatException nfe){
                        System.out.println('\n' + "Wrong Choice!!");
                        continue;
                    }
                    if(accountType == 1){
                        System.out.println("Enter name: ");
                        String name = scan.next();
                        System.out.println("Enter your initial balance: ");
                        double initialBalance;
                        try{
                            initialBalance = scan.nextDouble();
                        }
                        catch (InputMismatchException ime){
                            System.out.println('\n' + "Please enter in a number!!");
                            break;
                        }
                        standardAccount client = new standardAccount(name, initialBalance);
                        standardMap.put(name, client);
                        break;
                    }
                    else if (accountType == 2) {
                        System.out.println("Enter name: ");
                        String name = scan.next();
                        System.out.println("Starting balance: ");
                        double initialBalance;
                        try{
                            initialBalance = scan.nextDouble();
                        }
                        catch (InputMismatchException ime){
                            System.out.println('\n' + "Please enter in a number!!");
                            break;
                        }
                        VIPAccount client = new VIPAccount(name, initialBalance);
                        VIPMap.put(name, client);
                        break;
                    }
                case 2:
                    System.out.println("\nEnter Your name: ");
                    String keyDisplay = scan.next();
                    if(standardMap.containsKey(keyDisplay)){
                        System.out.println("**Account Details**");
                        standardMap.get(keyDisplay).display();
                    }
                    else if (VIPMap.containsKey(keyDisplay)) {
                        System.out.println("**Account Details**");
                        VIPMap.get(keyDisplay).display();
                    }
                    else{
                        System.out.println("Name: " + keyDisplay + " does not exist");
                    }
                    break;
                case 3:
                    System.out.println("\n**Transaction - Withdraw**");
                    System.out.println("Enter Your name: ");
                    String keyWithdraw = scan.next();
                    System.out.println("Enter amount to withdraw: ");
                    double scanWithdrawAmount;
                    try{
                        scanWithdrawAmount = scan.nextDouble();
                    }
                    catch (InputMismatchException ime){
                        System.out.println('\n' + "Please enter in a number!!");
                        break;
                    }
                    if(standardMap.containsKey(keyWithdraw)){
                        if(scanWithdrawAmount > standardMap.get(keyWithdraw).getBalance()) {
                            System.out.println("Not enough balance");
                            break;
                        }
                        standardMap.get(keyWithdraw).withdraw(scanWithdrawAmount);
                    }
                    else if (VIPMap.containsKey(keyWithdraw)) {
                        if(scanWithdrawAmount > standardMap.get(keyWithdraw).getBalance()) {
                            System.out.println("Not enough balance");
                            break;
                        }
                        VIPMap.get(keyWithdraw).withdraw(scanWithdrawAmount);
                    }
                    else{
                        System.out.println("Name: " + keyWithdraw + " does not exist");
                    }
                    break;
                case 4:
                    System.out.println("**Transaction - Deposit**");
                    System.out.println("Enter Your name: ");
                    String keyDeposit = scan.next();
                    System.out.println("Enter amount to deposit: ");
                    double scanDepositAmount;
                    try{
                        scanDepositAmount = scan.nextDouble();
                    }
                    catch (InputMismatchException ime){
                        System.out.println('\n' + "Please enter in a number!!");
                        break;
                    }
                    if(standardMap.containsKey(keyDeposit)){
                        standardMap.get(keyDeposit).deposit(scanDepositAmount);
                    }
                    else if (VIPMap.containsKey(keyDeposit)) {
                        VIPMap.get(keyDeposit).deposit(scanDepositAmount);
                    }
                    else{
                        System.out.println("Name: " + keyDeposit + " does not exist");
                    }
                    break;

                /** Display all functionality
                 * Access both standardAccounts and VIPAccounts hashmaps
                 * and iterate through both using .entrySet() method to display
                 * all current object in both hashmaps.
                 */
                case 5:
                    System.out.println("Standard Account Details\n**Account Details**");
                    for (Map.Entry<String, bankAccount> entry : standardMap.entrySet()) {
                        String name = entry.getKey();
                        standardMap.get(name).display();
                    }
                    System.out.println("\nVIP Account Details\n**Account Details**");
                    for (Map.Entry<String, bankAccount> entry1 : VIPMap.entrySet()) {
                        String name = entry1.getKey();
                        VIPMap.get(name).display();
                    }
                    break;
                /** Remove Account functionality
                 * Access both standardAccounts and VIPAccounts hashmaps
                 * and use .remove() function to remove object from hashmap.
                 */
                case 6:
                    System.out.println("\n**Transaction - remove Account**");
                    System.out.println("Enter Your name: ");
                    String keyRemove = scan.next();
                    if(standardMap.containsKey(keyRemove)){
                        System.out.println("Account has been removed!!");
                        standardMap.remove(keyRemove);
                    }
                    else if (VIPMap.containsKey(keyRemove)) {
                        System.out.println("Account has been removed!!");
                        VIPMap.remove(keyRemove);
                    }
                    else{
                        System.out.println("Name: " + keyRemove + " does not exist");
                    }
                    break;
                case 7:
                    System.out.println("**Transaction - calculate interest**");
                    System.out.println("Enter Your name: ");
                    String keyCalcInterest = scan.next();
                    System.out.println("Enter the number of months ");
                    double scanDuration;
                    try{
                        scanDuration = scan.nextDouble();
                    }
                    catch (InputMismatchException ime) {
                        System.out.println('\n' + "Please enter in a number!!");
                        break;
                    }
                    if(standardMap.containsKey(keyCalcInterest)){
                        standardMap.get(keyCalcInterest).calculateInterest(scanDuration);
                    }
                    else if (VIPMap.containsKey(keyCalcInterest)) {
                        VIPMap.get(keyCalcInterest).calculateInterest(scanDuration);
                    }
                    else{
                        System.out.println("Name: " + keyCalcInterest + " does not exist");
                    }
                    break;
                case 8:
                    System.out.println('\n' + "Thanks for banking with us!!");
                    exit(0);
                default: System.out.println('\n' + "Wrong Choice!!");
                }
            }
        }
    }