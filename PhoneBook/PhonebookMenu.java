package PhoneBook;
import java.util.Scanner;

public class PhonebookMenu
{
    protected static char userSelection;
    protected static boolean userConfirm = false;
    protected static boolean userAddEntry = false;
    protected static boolean userRemoveEntry = false;
    Scanner input = new Scanner(System.in);

    protected static boolean userInput(Scanner input)
    {

        char userResponse;
        System.out.printf("Would you like to use a phonebook? ");

                //ask user if they'd like to open phonebook
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
            }
                //if user does not want to see the menu, do nothing
            else if (Character.toLowerCase(userResponse) == 'n')
            {
                userConfirm = false;
            } // end of if/else

            //repeats the above if the user types something other than y or n
        } while (Character.toLowerCase(userResponse) != 'y' ||
                 Character.toLowerCase(userResponse) != 'n');
        return false;
    } // end of userInput method

    protected static void menu(Scanner input) {
        char userSelection;

        System.out.printf("Please make a selection and type the corresponding letter.%n%n");
        System.out.println("|v| View the phonebook.");
        System.out.println("|a| Add an entry to the phonebook.");
        System.out.println("|s| Sort the phonebook by last name.");
        System.out.println("|r| Remove an entry from the phonebook.");
        System.out.println("|m| Modify an entry in the phonebook.");
////////////////reput whatever for the case s, r, m, (the prints are to test if it works)//////////////////////////////////
        do {

            userSelection = input.next().charAt(0);
            userSelection = Character.toLowerCase(userSelection);
            switch (userSelection) {
                case 'v':
                    //System.out.print("view");
                    PhonebookManager.display(PhonebookManager.front); //////////////not working here :(//////////////
                   //bellingham.display(bellingham.front);
                    break;
                case 'a':
                    userAddEntry = true;
                    //returns to main, where add method will start running
                    return;
                case 's':
                    System.out.print("Sort");
                case 'r':
                    userRemoveEntry = true;
                    System.out.print("Remove");
                case 'm':
                    System.out.print("Modify");
            }

        } while (userSelection != 'v' || userSelection != 'a' ||
                userSelection != 's' || userSelection != 'r' ||
                userSelection != 'm');
    }


    public static void userCreateNode(Scanner input)
    {
        String firstName;
        String lastName;
        String address;
        String city;
        String phoneNum;

        System.out.printf("%n%nPlease type in a First Name %n");
        firstName = input.next();
        System.out.printf("Please type in a Last Name %n");
        lastName = input.next();
        System.out.printf("Please type in an Address %n");
        address = input.next();
        System.out.printf("Please type in City %n");
        city = input.next();
        System.out.printf("Please type in a Phone Number%n");
        phoneNum = input.next();

        PhonebookManager.add(firstName, lastName, address, city, phoneNum);
    } // end of userCreateNode method

    public static void userRemoveNode(Scanner input) {

    }
/* commented out to test above methods
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
*/
} // end of PhonebookTestMain
