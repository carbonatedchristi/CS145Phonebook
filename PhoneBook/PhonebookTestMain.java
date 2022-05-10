//Programmers: Christina Mymrin
//             Hannah Hendrickson
// Assignment 2 PhoneBook
// Class: CS145 Hybrid01


package PhoneBook;
public class PhonebookTestMain
{
    public static void main(String[] args)
    {

            //PBManager bellingham = new PBManager("Bellingham");
            PhonebookManager bellingham = new PhonebookManager();
            bellingham.add("firstname1", "lastname1", "address1", "city1", "number1");
            bellingham.add("firstname2", "lastname2", "address2", "city2", "number2");
            bellingham.add("firstname3", "lastname3", "address3", "city3", "number3");

            System.out.println("Here are the entries for Bellingham!: ");
            bellingham.display(bellingham.front);

            System.out.println();
            System.out.println(bellingham.getEntry("lastname2"));

    } // end of main method

    // TODO menu methods

} // end of PhonebookTestMain
