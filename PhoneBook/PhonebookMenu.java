package PhoneBook;
import java.util.Scanner;

public class PhonebookMenu
{
    protected static char userSelection;
    protected boolean userRemoveEntry;

    protected static boolean userInput(Scanner input)
    {
        boolean userConfirm = false;
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

    // printMenu method, displays menu options
    public static void printMenu()
    {
        System.out.printf("Please make a selection and type the corresponding letter.%n%n");
        System.out.println("|v| View the phonebook.");
        System.out.println("|a| Add an entry to the phonebook.");
        System.out.println("|r| Remove an entry from the phonebook.");
        System.out.println("|m| Modify an entry in the phonebook.");
        System.out.println("|q| Quit the program");
    } // end of printMenu method

    protected static void menuSelect(PhonebookManager cityBook)
    {
        Scanner input = new Scanner(System.in);
        char userSelection = 'z';
        boolean validSelection = false;
////////////////reput whatever for the case s, r, m, (the prints are to test if it works)//////////////////////////////////
        do {

            userSelection = input.next().charAt(0);
            userSelection = Character.toLowerCase(userSelection);
            switch (userSelection)
            {
                case 'v':
                    System.out.printf("Here is the phonebook:%n%n");
                   cityBook.display(cityBook.front);
                    validSelection = true;
                    break;
                case 'a':
                    userCreateNode(cityBook);
                    validSelection = true;
                    return;
                case 'r':
                    userRemoveNode(cityBook);
                    validSelection = true;
                    break;
                case 'm':
                    userModifyNode(cityBook); //goes to modifynode method where user decides what string to modify
                    break;
                case 'q':
                    validSelection = true;
                    return;
                default:
                    System.out.printf("%nInvalid Selection.%n%n");
                    validSelection = false;
                    break;
            } // end of switch case

        } while (!validSelection);
    } // end of menu method


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
    } // end of userCreateNode method

    public static void userModifyNode(PhonebookManager cityBook) {

        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Here are the phonebook entries: \n");
            cityBook.display(cityBook.front);
            System.out.println("\n\nPlease type in the entry you would like to modify: " +
                    "\n |f| first name" +
                    "\n |l| last name" +
                    "\n |a| address" +
                    "\n |c| city" +
                    "\n |p| phone number");
            userSelection = input.next().charAt(0);
            userSelection = Character.toLowerCase(userSelection);
            ///////////////////TODO: put actual comparison methods here after each case sysoutprint
            switch (userSelection)
            {
                case 'f':
                    System.out.println("Please enter the current first name of the entry you would like to modify:");
                        //STRUCTURE:
                    //obtain userinput, make it lowercase
                    //compare that to a lowercase of the strings in the phonebook? (like if userinput = firstName)
                    //(cont) ask for new userinput for last name then set firstName = newUserInput. something like that
                    //last resort could be an override boolean? not gonna be pretty tho :(
                        //and then basically do that for all other types like lastname, address, etc.
                    return;
                case 'l':
                    System.out.println("Please enter the current last name of the entry you would like to modify:");

                    return;
                case 'a':
                    System.out.println("Please enter the current address of the entry you would like to modify:");
                    //validSelection = true;
                    return;
                case 'c':
                    System.out.println("Please enter the current city of the entry you would like to modify:");
                    //validSelection = true;
                    return;
                case 'p':
                    System.out.println("Please enter the current phone number of the entry you would like to modify:");
                    //validSelection = true;
                    return;
                default:
                    System.out.printf("%nInvalid Selection.%n%n");
                    //validSelection = false;
                    break;
            } // end of switch case


        } while (userSelection != 'f' || userSelection != 'l' || userSelection !='a' ||
                 userSelection != 'c' || userSelection != 'p');
    }

    public static void userRemoveNode(PhonebookManager cityBook)
    {
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
                noException = true;
            } // end of try
            catch (Exception e)
            {
                // empty because code will loop
            } // end of catch
        } while(!noException && !userIndexWithinBounds);
        cityBook.remove(indexToRemove - 1);
    } // end of userRemoveNode

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

} // end of PhonebookMenu
