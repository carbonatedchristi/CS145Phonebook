//Programmers: Christina Mymrin
//             Hannah Hendrickson
// Assignment 2 PhoneBook
// Class: CS145 Hybrid01

package PhoneBook;
public class PhonebookTestMain {

    public static void main(String[] args) {
        PhonebookManager bellingham = new PhonebookManager("Bellingham");
        PhonebookManager seattle = new PhonebookManager("Seattle");

        bellingham.add("First", "Last", "Address", "City", "ZipCode");

        System.out.println("I ---------");
        System.out.println();
        System.out.println(bellingham);
        System.out.println(seattle);

        //bellingham.transferTo(seattle, bellingham.get("David"));
        //bellingham.transferTo(seattle, bellingham.get("Rebecca"));

        //seattle.modifyNameFirst(seattle.get("David"), "Zach"); //should replace davids name with zach
    } // end of main method

    // TODO menu methods

} // end of PhonebookTestMain
