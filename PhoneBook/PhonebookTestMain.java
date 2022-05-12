//Programmers: Christina Mymrin
//             Hannah Hendrickson
// Assignment 2 PhoneBook
// Class: CS145 Hybrid01


package PhoneBook;
import java.util.Scanner;
import java.lang.Character;

import static PhoneBook.PhonebookMenu.*;

public class PhonebookTestMain {

    public static void main(String[] args) {

       Scanner input = new Scanner(System.in);

        PhonebookManager bellingham = new PhonebookManager();
        // populates the linkedlist with sample entries
        addTestEntries(bellingham);
        System.out.println(bellingham.size());

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
