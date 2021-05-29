package practice;
import java.util.*;
import java.util.ArrayList;

/**
 * this class generate an account for the client
 *
 * @author ahmed
 * @version 1.0
 */
class Account {

    protected double balance;
    private int Account_Number;
    static int v = 0;

    /**
     * it sets the balance to the parameter b
     *
     * @param b
     */
    public void setBalance(double b) {
        balance = b;
    }

    /**
     * it sets the account number to the parameter an
     *
     * @param an
     */
    public void setAccount_Number(int an) {
        Account_Number = an + v;
    }

    /**
     * returns the Balance in the client`s account in the bank
     *
     * @return Balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * returns the account number of the client in the bank
     *
     * @return account number
     */
    public int getAccount_Number() {
        return Account_Number;
    }

    public Account() {
        v++;
    }

    /**
     * parameterized constructor that sets the balance to b parameter and the
     * account number to parameter an
     *
     * @param b makes the balance
     * @param an makes the acc number
     */
    public Account(double b, int an) {
        balance = b;
        Account_Number = an;

    }

    /**
     * describe the information of the account
     *
     * @return acc number / balance of the client
     */

    @Override
    public String toString() {
        System.out.println("Data of this custmor is ");
        System.out.printf("Account_Number= %d%n", Account_Number);
        System.out.printf("balance= %f%n", balance);
        return "..... ";
    }

    /**
     * check if the client wants to withdraw some money from his account that he
     * have enough money to withdraw and if he hasn`t enough money it will
     * returns error ..
     *
     * @param num How much money he wants to withdraw
     */

    public void Withdraw(double num) {

        if (balance >= num) {
            balance = balance - num;
            System.out.println("balance after subtruction --> " + balance);
        } else {
            System.out.println("Haven't enough balance");
        }
    }

    /**
     * a function to add the funds that the client wants to deposit to the main
     * balance
     *
     * @param num how much money he wants to add
     */
    public void Deposit(double num) {
        balance = balance + num;
        System.out.println("balance after addition --> " + balance);

    }
}

class Special_Account extends Account {

    Special_Account() {
    }

    public Special_Account(double balance, int Account_Number) {    
        super(balance, Account_Number);
    }

    /**
     * describe a special account
     *
     * @param num How much money he wants to withdraw
     */
    @Override
    public void Withdraw(double num) {
        super.Withdraw(num);
        if (num > balance) {
            if (balance - num >= -1000) {
                balance = balance - num;
            } else {
                System.out.println("you exceedes the determined amount And your balance is" + balance);
            }
            balance = balance - num;
        }
    }
}






/**
 *
 * @author Ahmed
 * @version 1.0
 */
class Client {

    protected String name, address;
    long phone, nationalid;
    Account clientacc;

    /**
     * parametrized constructor that sets the initial value to the
     * name,address,phone number and nationality of the client
     *
     * @param c_acc the account of the client
     */
    public Client(Account c_acc) {
        name = "";
        address = "";
        phone = 0000;
        nationalid = 00000;
        clientacc = c_acc;
    }

    /**
     * function to set the actual client name
     *
     * @param n the name of the clinet
     */

    void setname(String n) {
        name = n;
    }

    /**
     * function that sets the actual address of the client
     *
     * @param add describe the address
     */
    void setaddress(String add) {
        address = add;
    }

    /**
     * function to set the actual client phone number
     *
     * @param p the phone number of the client
     */
    void setphone(long p) {
        phone = p;
    }

    /**
     * function to set the actual client national id
     *
     * @param id the national id of the client
     */
    void setnationalid(long id) {
        nationalid = id;
    }

    /**
     * function to return the client name
     *
     * @return client name
     */
    String getname() {
        return name;
    }

    String getaddress() {
        return address;
    }

    long getphone() {
        return phone;
    }

    long getnationalid() {
        return nationalid;
    }

    /**
     * function to describe the full information to the client and his account
     *
     * @return name / address / phone number / national id / balance / acc name
     */
    public String toString() {
        System.out.printf("name of the client %s %n ", name);
        System.out.printf("the address  of the client %s %n ", address);
        System.out.printf("phone number of the client %d %n", phone);
        System.out.printf("national id  of the client %d %n", nationalid);
        clientacc.toString();
        return "..... ";
    }
}

class CommercialClient extends Client {

    private long commercialid;

    /**
     * parameterized constructor that sets initial value to the commercial id
     *
     * @param acc
     */
    public CommercialClient(Account acc) {
        super(acc);
        nationalid = 00000000000000;
    }

    void setcommercialid(long p) {
        commercialid = p;
    }

    long getcommercialid() {
        return commercialid;
    }

    /**
     * function to describe the full information to the client and his account
     *
     * @return name / address / phone number / commercial id / balance / acc
     * name
     */
    @Override
    public String toString() {

        System.out.printf("name of the client %s %n ", name);
        System.out.printf("the address  of the client %s %n ", address);
        System.out.printf("phone number of the client %d %n", phone);
        System.out.printf("commercial id  of the client %d %n", commercialid);
        clientacc.toString();
        return "....";
    }

}





class Bank {

    private String name;
    private String address;
    private String phone;
    public static int clientCounter = 0;
    public static int accountCounter = 0;

    /**
     * default constructor that sits initial value to the name, address, phone
     * number
     */
    Bank() {
        name = "no name";
        address = "no address";
        phone = "no phone number";
    }

    public void setName(String n) {
        name = n;
    }

    public void setAddress(String ad) {
        address = ad;
    }

    public void setPhone(String ph) {
        phone = ph;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    ArrayList<Account> account_list = new ArrayList<>();
    ArrayList<Client> client_list = new ArrayList<>();

    /**
     * function that return the account info
     */
    public void printAccounts() {
        for (int i = 0; i < account_list.size(); i++) {
            System.out.println(account_list.get(i));
        }
    }

    /**
     * function that return the client info
     */
    public void printClients() {
        for (int i = 0; i < client_list.size(); i++) {
            System.out.println(client_list.get(i));
        }
    }

    /**
     * function that add the account info
     */
    public void addAccount(Account acc) {
        account_list.add(accountCounter, acc);
        this.printAccounts();
        accountCounter++;
    }

    /**
     * function that add the client info
     */

    public void addClient(Client cli) {
        client_list.add(clientCounter, cli);
        this.printClients();
        clientCounter++;
    }

    /**
     * function that search for an exist account
     */
    public Account Search(int acc_num) {
        for (int i = 0; i < account_list.size(); i++) {
            if (account_list.get(i).getAccount_Number() == acc_num) {
                int t = i;
                return account_list.get(t);
            }
        }
        return null;
    }

}



/**
 *
 * @author semsem
 */


public class Practice {

    public static void main(String[] args) {
        Bank CIB = new Bank();
        int x = 3;
        int choice;
        do {
            System.out.println("Hello Sir, How can we help you?\n 1- I want to Creat an Account \n"
                    + " 2- I want to be a Client in this Bank\n 3- Exit \n");
            Scanner sc = new Scanner(System.in);

            choice = sc.nextInt();
            if (choice == 1) {
                System.out.println("Please, Enter your Balance\n");
                int balance = sc.nextInt();
                Account acc = new Account();
                acc.setAccount_Number(5255384);
                acc.setBalance(balance);
                CIB.addAccount(acc);
                System.out.println(" 1- Withdraw Money\n 2- Deposite Money\n 3- Bake to the main menu");
                x = sc.nextInt();
                if (x == 1) {
                    System.out.println("How much mony will you withdraw?\n");
                    double w = sc.nextDouble();
                    acc.Withdraw(w);

                }
                if (x == 2) {
                    System.out.println("How much mony will you deposite?\n");
                    double d = sc.nextDouble();
                    acc.Deposit(d);

                }

            }

            if (choice == 2) {
                System.out.println("Do you have an account in the bank?\n 1- YES\n 2- NO\n");
                int ans = sc.nextInt();
                if (ans == 1) {
                    System.out.println("What's the number of your account?\n");
                    int num = sc.nextInt();
                    Client cl = new Client(CIB.Search(num));
                    System.out.println("What's your name?\n");
                    String n = sc.next();
                    cl.setname(n);
                    System.out.println("What's your address?\n");
                    n = sc.next();
                    cl.setaddress(n);
                    System.out.println("What's your phone number?\n");
                    long nu = sc.nextLong();
                    cl.setphone(nu);
                    System.out.println("What's your national ID?\n");
                    nu = sc.nextLong();
                    cl.setnationalid(nu);
                    CIB.addClient(cl);
                    System.out.println("CONGRATULATIONS!" + cl.getname() + " to be one of our clients\n");

                }
                if (ans == 2) {
                    System.out.println("Please, Enter your Balance\n");
                    int balance = sc.nextInt();
                    Account acc = new Account();
                    acc.setAccount_Number(5255384);
                    acc.setBalance(balance);
                    CIB.addAccount(acc);
                    Client cl = new Client(acc);
                    System.out.println("What's your name?\n");
                    String n = sc.next();
                    cl.setname(n);
                    System.out.println("What's your address?\n");
                    n = sc.next();
                    cl.setaddress(n);
                    System.out.println("What's your phone number?\n");
                    long nu = sc.nextLong();
                    cl.setphone(nu);
                    System.out.println("What's your national ID?\n");
                    nu = sc.nextLong();
                    cl.setnationalid(nu);
                    CIB.addClient(cl);
                    System.out.println("CONGRATULATIONS!" + cl.getname() + " to be one of our clients\n");

                }
            }

        } while (choice != 3);

    }
}
