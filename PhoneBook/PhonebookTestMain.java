//Programmers: Christina Mymrin
//             Hannah Hendrickson
// Assignment 2 PhoneBook
// Class: CS145 Hybrid01


package PhoneBook;
import java.util.Scanner;
import java.lang.Character;

public class PhonebookTestMain
{
    public static void main(String[] args)
    {
        /*
        Scanner input = new Scanner(System.in);

        while (userInput(input))
        {

        }
        */

        //PBManager bellingham = new PBManager("Bellingham");
        PhonebookManager bellingham = new PhonebookManager();
        bellingham.add("BeastBoy", "Zebra", "address1", "city1", "number1");
        bellingham.add("Harley", "Yvette", "address2", "city2", "number2");
        bellingham.add("firstname3", "Zanzibar", "address3", "city3", "number3");
        bellingham.add("Egg", "Brain", "666 ave", "Bellingham", "12345");
        bellingham.add("Birdie", "IsADog", "1 Canine Drive", "Bham", "00000");
        bellingham.add("Ginkgo", "IsACat", "OriginalAddress", "CardboardBox", "123243");


        System.out.println("Here are the entries for Bellingham!: ");
        bellingham.display(bellingham.front);

        System.out.println();
        //System.out.println(bellingham.getEntry("lastname2"));
        //bellingham.sort();

        System.out.println("Swapped the first two entries: ");
        bellingham.powerSwap(bellingham.front, bellingham.nodeAt(3), bellingham.nodeAt(4));
        bellingham.display(bellingham.front);

    } // end of main method

    private static boolean userInput(Scanner input)
    {
        boolean userConfirm = false;
        char userResponse;
        System.out.printf("Would you like to use a phonebook?");

        do
        {
            System.out.println("Please type \"y\" or \"n\".");
            userResponse = input.next().charAt(0);
            userResponse = Character.toLowerCase(userResponse);

            if (Character.toLowerCase(userResponse) == 'y')
            {
                userConfirm = true;
            }
            else if (Character.toLowerCase(userResponse) == 'n')
            {
                userConfirm = false;
            } // end of if/else
        } while (Character.toLowerCase(userResponse) != 'y' ||
                 Character.toLowerCase(userResponse) != 'n');
        return userConfirm;
    } // end of userInput method

    private static char menu(Scanner input)
    {
        char userSelection = 'z';

        System.out.printf("Please make a selection and type the corresponding letter.%n%n");
        System.out.println("|v| View the phonebook.");
        System.out.println("|a| Add an entry to the phonebook.");
        System.out.println("|s| Sort the phonebook by last name.");
        System.out.println("|r| Remove an entry from the phonebook.");
        System.out.println("|m| Modify an entry in the phonebook.");

        do
        {
            userSelection = input.nextLine().charAt(0);
            userSelection = Character.toLowerCase(userSelection);


        } while(userSelection != 'a' || userSelection != 's' ||
                userSelection != 'r' || userSelection != 'm');

        return userSelection;
    } // end of menu method

    private void menuAction(char userSelection, Scanner input)
    {
        switch (userSelection)
        {
            case 'v':
                PhonebookManager.display(PhonebookManager.front);
                break;
            case 'a':
                userCreateNode(input);
        }
    } // end of menuSelect

    public static void userCreateNode(Scanner input)
    {
        String firstName;
        String lastName;
        String address;
        String city;
        String phoneNum;

        System.out.printf("%n%n|First Name|%n");
        firstName = userString(input);
        System.out.printf("%n%n|Last Name|%n");
        lastName = userString(input);
        System.out.printf("%n%n|Address|%n");
        address = userString(input);
        System.out.printf("%n%n|City|%n");
        city = userString(input);
        System.out.printf("%n%n|Phone Number|%n");
        phoneNum = userString(input);

        PhonebookManager.add(firstName, lastName, address, city, phoneNum);
    } // end of userCreateNode method

    public static String userString(Scanner input)
    {
        String userEntry = "";
        boolean exceptionTriggered = true;
        do
        {
            try
            {
                System.out.println("Please type your entry: ");
                userEntry = input.nextLine();
                exceptionTriggered = false;
            }
            catch (Exception e)
            {
                // empty because code will loop
            } // end of try/catch


        } while (!exceptionTriggered);
        return userEntry;
    } // end of userString

} // end of PhonebookTestMain
