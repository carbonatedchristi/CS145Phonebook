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
        bellingham.sort();
        bellingham.display(bellingham.front);

    } // end of main method

    // TODO menu methods

} // end of PhonebookTestMain
