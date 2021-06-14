package bank;

import java.util.Scanner;

public class Account {

    // Class variables
    int balance;
    int previousTransaction;
    String customerName;
    String customerID;

    //class constructor
    Account(String cName, String cID){
        customerName = cName;
        customerID = cID;
    }

    //function for depositing money
    void deposit (int amount){
        if (amount != 0){
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    //function for withdrawing money
    void withdraw (int amount){
        if (amount !=0){
            balance -= amount;
            previousTransaction = -amount;
        }
    }

    //function that shows the previous transaction
    void getPreviousTransaction(){
        if (previousTransaction > 0){
            System.out.println("Deposited: $" + previousTransaction);
        } else if (previousTransaction < 0){
            System.out.println("Withdrew: $" + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction occurred.");
        }
    }

    void welcome(){
        System.out.println("Welcome, " + customerName + ".\nWhat would you like to do?\n");

    }

    void message(){
        System.out.println("Would you like to do something else?");
    }


    //function that shows main menu
    void showMenu(){
        char option = '\0';
        Scanner scanner = new Scanner(System.in);
        System.out.println("A. Check your balance");
        System.out.println("B. Make a deposit.");
        System.out.println("C. Make a withdrawal");
        System.out.println("D. View previous transaction");
        System.out.println("E. Exit");
        System.out.println("Enter an option: ");


        do {
            char option1 = scanner.next().charAt(0);
            option = Character.toUpperCase(option1);


            switch (option){
                //Case A allows user to check their balance
                case 'A':
                    System.out.println("=====================");
                    System.out.println("Balance = $" + balance);
                    System.out.println("=====================");
                    System.out.println();
                    showMenu();
                    break;

                    // allows user to deposit money
                case 'B':
                    System.out.println("Enter amount to deposit:");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println("=====================");
                    System.out.println("$" + amount + " has been deposited to your account.\nNew balance is: $" + balance);
                    System.out.println("=====================");
                    showMenu();
                    break;

                    //allows user to withdraw their money
                case 'C':
                    System.out.println("Enter an amount to withdraw: ");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    System.out.println("=====================");
                    System.out.println("$" + amount2 + " has been withdrawn from your account.\nNew balance is: $" + balance);
                    System.out.println("=====================");
                    showMenu();
                    break;

                    //allows user to
                case 'D':
                    System.out.println("=====================");
                    getPreviousTransaction();
                    System.out.println("=====================");
                    showMenu();

                    //exit
                case 'E':
                    break;

                    //the default case lets user know that they entered an invalid option
                default:
                    System.out.println("Error: invalid option.");
                    break;
            }
        } while (option != 'E');
        System.out.println("\nThank you for banking with us.\nHave a great day.");
    }

























}
