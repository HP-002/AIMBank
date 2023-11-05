import java.util.*;
class account {
    String name, password, email, phone;
    String accNo;
    double balance;
    account next = null;
    account previous = null;

    account(String name, String accNo, String email, String phone, String password) {
        this.name = name;
        this.accNo = accNo;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }
}

public class AIMBank {
    Scanner sc = new Scanner(System.in);
    account head;
    account last;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AIMBank ob = new AIMBank();
        int choice;

        ob.printMenu();

        while(true) {
            System.out.print("Enter: ");
            choice = sc.nextInt();
            switch(choice) {
                case 1: ob.openAcc();       break;
                case 2: ob.closeAcc();      break; 
                case 3: ob.viewDetails();   break;
                case 4: ob.deposit();       break;
                case 5: ob.withdraw();      break;
                case 6: ob.printMenu();     break;
                case 7: ob.help();;         break;
                case 8: ob.aboutUs();       break;
                case 9: System.exit(0);
                default: System.out.println("Invalid input... Try again...");
            }

        }

    }

    AIMBank() {
        account temp = new account(null, "50500000", null, null, null);
        head = temp;
        last = temp;
    }
    
    void openAcc() {
        System.out.print("Enter name: ");
        String n = sc.nextLine();
        System.out.print("Enter email: ");
        String e = sc.nextLine();
        System.out.print("Enter phone: ");
        String p = sc.nextLine();

        String accno = Integer.toString(Integer.parseInt(last.accNo) + 1);
        System.out.print("Enter a password: ");
        String pass = sc.nextLine();
        account temp = new account(n, accno, e, p, pass);
        temp.previous = last;
        last.next = temp;
        last = temp;

        System.out.println("Account opened successfully...");
        System.out.println("Account No.: " + accno);

        System.out.println("");
    }

    void closeAcc() {
        System.out.print("Enter Account number: ");
        String accno = sc.nextLine();   
        account currAcc = head;

        while(currAcc.next != null) {
            if(currAcc.accNo.equals(accno)) 
                break;
            currAcc = currAcc.next;
        }      
   
        if(currAcc.accNo.equals(accno)) {
            System.out.print("Enter Password: ");
            String p = sc.nextLine();
        
            if(currAcc.password.equals(p)) {
                System.out.println("$ " + currAcc.balance + " withdrawn...");
                currAcc = currAcc.previous;
                currAcc.next = currAcc.next.next;
                System.out.println("Account closed successfully...");
            }
            else
                System.out.println("Password incorrect");
        }
        else
            System.out.println("Account not found...");
        
        System.out.println("");
    }

    void viewDetails() {
        System.out.print("Enter Account number: ");
        String accno = sc.nextLine();
        account currAcc = head;

        while(currAcc.next != null) {
            if(currAcc.accNo.equals(accno)) 
                break;
            currAcc = currAcc.next;
        }

        if(currAcc.accNo.equals(accno)) {
            System.out.print("Enter Password: ");
            String p = sc.nextLine();
            if(currAcc.password.equals(p)) {
                System.out.println("Account No.: " + currAcc.accNo);
                System.out.println("Name: " + currAcc.name);
                System.out.println("Email: " + currAcc.email);
                System.out.println("Phone: " + currAcc.phone);
                System.out.println("Balance: $ " + currAcc.balance);
            }
            else
                System.out.println("Password incorrect");
        }
        else
            System.out.println("Account not found...");

        System.out.println("");
    }

    void deposit() {
        System.out.print("Enter Account number: ");
        String accno = sc.nextLine();
        account currAcc = head;

        while(currAcc.next != null) {
            if(currAcc.accNo.equals(accno)) 
                break;
            currAcc = currAcc.next;
        }

        if(currAcc.accNo.equals(accno)) {
            System.out.print("Enter Amount to be deposited (in USD): $ ");
            double amount = sc.nextDouble();
            currAcc.balance += amount;
            System.out.println("Amount deposited successfully...");
        }
        else
            System.out.println("Account does not exist...");

        System.out.println("");
    }

    void withdraw() {
        System.out.print("Enter Account number: ");
        String accno = sc.nextLine();
        account currAcc = head;

        while(currAcc.next != null) {
            if(currAcc.accNo.equals(accno)) 
                break;
            currAcc = currAcc.next;
        }

        if(currAcc.accNo.equals(accno)) {
            System.out.println("Enter Amount to be withdrawn (in USD): $ ");
            double amount = sc.nextDouble();

            if(amount <= currAcc.balance) {
                currAcc.balance -= amount;
                System.out.println("$ " + amount + " withdrawn successfully...");
            }
            else
                System.out.println("Transaction failed... Amount exceeds current balance...");
        }
        else
            System.out.println("Account does not exist...");

        System.out.println("");        
    }

    void printMenu() {
        System.out.println("""
            ******** Menu ********
            1 - Open Account
            2 - Close Account
            3 - View Details
            4 - Deposit
            5 - Withdraw
            6 - Print Menu
            7 - Help
            8 - About Us
            9 - Exit
            ********
            """);
    }

    void help() {
        System.out.println("This is a menu-driven program. Enter the number of your choice to perform the task. Enter 6 to print the menu again.\n");
    }

    void aboutUs() {
        System.out.println("Want to open a bank account? Or better yet Deposit/Withdraw money? Look no further than the AIM bank. A simple yet effective way of banking, all at your fingertips. Keep a track of your records starting today...AIM for it ;) \n");
    }
}