//Programmers: Christina Mymrin
//             Hannah Hendrickson
// Assignment 2 PhoneBook
// Class: CS145 Hybrid01
// Date: 05/17/2022
// Purpose: This program creates a linkedlist for use as a phonebook.
// A user can add, remove, modify, and search for entries via a menu.
// The menu can also view the entire phonebook printed to the console.
// We both used IntelliJ for our IDE and GitHub for version control.

// Notes for PhonebookMenu: Loops and try/catches were used to ensure
// that the user can't crash the program via invalid entries.
// Switch cases are used for menu functionality.

package CMHHPhonebook;
import java.util.Random;
import java.util.Scanner;

public class PhonebookMenu
{
    protected static char userSelection;
    protected boolean userRemoveEntry;

    // userInput method, processes a yes/no response from user
    protected static boolean userInput(Scanner input)
    {
        boolean userConfirm = false;
        char userResponse;
        System.out.printf("\nWould you like to use the phonebook? ");

        do
        {
            //grab user input and return to lowercase for comparisons
            System.out.println("Please type \"y\" or \"n\".");
            userResponse = input.next().charAt(0);
            userResponse = Character.toLowerCase(userResponse);

            //set bool to true, then return the value to main to open menu method
            if (Character.toLowerCase(userResponse) == 'y')
            {
                userConfirm = true;
                return userConfirm;
            } // end of if
            //if user does not want to see the menu, do nothing
            else if (Character.toLowerCase(userResponse) == 'n')
            {
                userConfirm = false;
            } // end of else

            //repeats the above if the user types something other than y or n
        } while (Character.toLowerCase(userResponse) != 'y' ||
                Character.toLowerCase(userResponse) != 'n');
        return false;
    } // end of userInput method

    // printMenu method, displays menu options
    public static void printMenu()
    {
        System.out.printf("Please make a selection and type the corresponding letter.%n%n");
        System.out.println("|v| View the phonebook.");
        System.out.println("|a| Add an entry to the phonebook.");
        System.out.println("|r| Remove an entry from the phonebook.");
        System.out.println("|m| Modify an entry in the phonebook.");
    } // end of printMenu method

    // menuSelect method, evaluates user menu choice and initiates it
    protected static void menuSelect(PhonebookManager cityBook)
    {
        Scanner input = new Scanner(System.in);
        char userSelection = 'z';
        // Only changes to false if the user enters an invalid char
        boolean validSelection = true;

        do
        {
            // intakes user entry and converts it to lowercase char
            userSelection = input.next().charAt(0);
            userSelection = Character.toLowerCase(userSelection);
            switch (userSelection)
            {
                case 'v': //shows the phonebook to the user if they input 'v'
                    System.out.printf("Here is the phonebook:%n%n");
                    cityBook.display(cityBook.front);
                    break;
                case 'a': //goes to the createNode method: user will input info for new node
                    userCreateNode(cityBook);
                    break;
                case 'r': //goes to removeNode method: user will
                    userRemoveNode(cityBook);
                    break;
                case 'm': //goes to modifynode method where user decides what string to modify
                    userModifyNode(cityBook);
                    break;
                default: //defaults for user to try again
                    System.out.printf("%nInvalid Selection. Please type in 'v', 'a', 'r', or 'm'. %n%n");
                    validSelection = false;
                    break;
            } // end of switch case

        } while (!validSelection);
    } // end of menu method

    // userCreateNode method, intakes user's string entries and creates a node
    public static void userCreateNode(PhonebookManager cityBook)
    {
        Scanner input = new Scanner(System.in);
        String firstName;
        String lastName;
        String address;
        String city;
        String phoneNum;

        System.out.printf("%n%nPlease type in a First Name %n");
        firstName = input.nextLine();
        System.out.printf("Please type in a Last Name %n");
        lastName = input.nextLine();
        System.out.printf("Please type in an Address %n");
        address = input.nextLine();
        System.out.printf("Please type in City %n");
        city = input.nextLine();
        System.out.printf("Please type in a Phone Number%n");
        phoneNum = input.nextLine();

        cityBook.add(firstName, lastName, address, city, phoneNum);
    } //end of userCreateNode method

    public static void userModifyNode(PhonebookManager cityBook)
    {

        Scanner input = new Scanner(System.in);
        // This value changes if the user enters an invalid char
        boolean validSelection = true;
        do
        {
            System.out.println("Here are the phonebook entries: \n");
            cityBook.display(cityBook.front);
            System.out.println("\n\nPlease type in the field you would like to modify: " +
                    "\n |f| first name" +
                    "\n |l| last name" +
                    "\n |a| address" +
                    "\n |c| city" +
                    "\n |p| phone number");
            userSelection = input.nextLine().charAt(0);
            userSelection = Character.toLowerCase(userSelection);

            //depending on users selection of what they'd like to modify,
            //the switch case statement calls the respective method
            //that corresponds to the modifiable object
            switch (userSelection)
            {
                case 'f':
                    cityBook.modifyNameFirst(cityBook);
                    break;
                case 'l':
                    cityBook.modifyNameLast(cityBook);
                    break;
                case 'a':
                    cityBook.modifyAddress(cityBook);
                    break;
                case 'c':
                    cityBook.modifyCity(cityBook);
                    break;
                case 'p':
                    cityBook.modifyPhoneNumber(cityBook);
                    break;
                default:
                    System.out.printf("%nInvalid Selection.%n%n");
                    validSelection = false;
                    break;
            } // end of switch case

        } while (!validSelection); //keep repeating this loop if user mistypes

    } // end of userModifyNode

    // userRemoveNode method, intakes index int of the entry to be removed
    // and then removes it
    public static void userRemoveNode(PhonebookManager cityBook)
    {
        // flags to ensure user inputs are valid
        boolean noException = false;
        boolean userIndexWithinBounds = false;
        int indexToRemove = -1;
        Scanner input = new Scanner(System.in);

        do
        {
            // try/catch will ensure the user enters a number
            try
            {
                System.out.printf("%nPlease enter the number of the entry to remove:");
                indexToRemove = input.nextInt();
                input.nextLine();
                if (indexToRemove > 0 && indexToRemove <= cityBook.size())
                {
                    userIndexWithinBounds = true;
                } // end of if
                else
                {
                    userIndexWithinBounds = false;
                } // end of else
                noException = true;
            } // end of try
            catch (Exception e)
            {
                // empty because code will loop
            } // end of catch
        } while(!noException && !userIndexWithinBounds);
        cityBook.remove(indexToRemove - 1);
    } // end of userRemoveNode

    // userString method, intakes user's string entry and returns it
    // Can be used for any field of a ListNode object
    public static String userString()
    {
        Scanner input = new Scanner(System.in);
        String userEntry = "";
        boolean exceptionTriggered = true;
        do
        {
            System.out.println("Please type your entry: ");
            userEntry = input.nextLine();

        } while (userEntry.equals(""));
        return userEntry;
    } // end of userString

    // pickRandomNum method, returns random number as int
    // This is just for fun, so the phone numbers can be randomized
    public static int random7digits()
    {
        //Computer picks number randomly of 7 digits
        // 1000000 is added to ensure digit value is met
        Random rand = new Random();
        int randomNumber = rand.nextInt(9000000) + 1000000;
        return randomNumber;
    } // end of pickRandomNumber method

} // end of PhonebookMenu class
