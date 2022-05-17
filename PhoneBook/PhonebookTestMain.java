//Programmers: Christina Mymrin
//             Hannah Hendrickson
// Assignment 2 PhoneBook
// Class: CS145 Hybrid01
// Date: 05/17/2022
// Purpose: This program creates a linkedlist for use as a phonebook.
// A user can add, remove, modify, and search for entries via a menu.
// The menu can also view the entire phonebook printed to the console.
// We both used IntelliJ for our IDE and GitHub for version control.


package PhoneBook;
import java.util.Scanner;

import static PhoneBook.PhonebookMenu.*;

public class PhonebookTestMain
{
    public static void main(String[] args)
    {

       Scanner input = new Scanner(System.in);
        //Creates a PhonebookManager for Bellingham
        PhonebookManager bellingham = new PhonebookManager();
        // Populates the linkedlist with sample entries
        addTestEntries(bellingham);

        System.out.println("There are " + bellingham.size() + " entries in the phonebook.");

        // For every menu selection completed, the user will be prompted again
        while (userInput(input))
        {
            PhonebookMenu.printMenu();
            // evaluates user menu option and initiates it
            menuSelect(bellingham);

        } // end of while

    } // end of main method

    // addTestEntries method, initializes a handful of PhonebookManager objects
    public static void addTestEntries(PhonebookManager cityBook)
    {
        cityBook.add("BeastBoy", "Zebra", "Savannah St",
                "Bellingham", "360" + random7digits());

        cityBook.add("Harley", "Yvette", "7 Main St",
                "Bellingham", "360" + random7digits());

        cityBook.add("Peter", "Zanzibar", "321 SomeRoad Dr",
                "Bellingham", "360" + random7digits());

        cityBook.add("Egg", "Brain", "222 Blah Ave",
                "Bellingham", "360" + random7digits());

        cityBook.add("Birdie", "IsADog", "1 Canine Way",
                "Bellingham", "360" + random7digits());

        cityBook.add("Ginkgo", "IsACat", "CardboardBox",
                "Bellingham", "360" + random7digits());
    } // end of addTestEntries method
} // end of PhonebookTestMain
