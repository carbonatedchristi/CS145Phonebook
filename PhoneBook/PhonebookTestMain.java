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
            menuSelect(bellingham);

        } // end of while

    } // end of main method

    public static void addTestEntries(PhonebookManager cityBook)
    {
        cityBook.add("BeastBoy", "Zebra", "address1",
                "Bellingham", "360" + random7digits());

        cityBook.add("Harley", "Yvette", "address2",
                "Bellingham", "360" + random7digits());

        cityBook.add("firstname3", "Zanzibar", "address3",
                "Bellingham", "360" + random7digits());

        cityBook.add("Egg", "Brain", "666 ave",
                "Bellingham", "360" + random7digits());

        cityBook.add("Birdie", "IsADog", "1 Canine Drive",
                "Bellingham", "360" + random7digits());

        cityBook.add("Ginkgo", "IsACat", "CardboardBox",
                "Bellingham", "360" + random7digits());
    } // end of addTestEntries method
} // end of PhonebookTestMain
