//Programmers: Christina Mymrin
//             Hannah Hendrickson
// Assignment 2 PhoneBook
// Class: CS145 Hybrid01

package PhoneBook;

public class PhonebookTestMain {

    public static void main(String[] args) {
        PhonebookManager bellingham = new PhonebookManager("Bellingham");
        //PhonebookManager seattle = new PhonebookManager("Seattle");

        bellingham.add("FirstName1", "LastName1", "Address1", "City1", "ZipCode1");
        bellingham.add("FirstName2", "LastName2", "Address2", "City2", "ZipCode2");
        bellingham.add("FirstName3", "LastName3", "Address3", "City3", "ZipCode3");
        bellingham.add("FirstName4", "LastName4", "Address4", "City4", "ZipCode4");
        bellingham.add("FirstName5", "LastName5", "Address5", "City5", "ZipCode5");

        System.out.println("Here are the Phone Book entries for Bellingham:");
        System.out.println();
        // This doesn't work :(
        bellingham.display();


        //bellingham.transferTo(seattle, bellingham.get("David"));
        //bellingham.transferTo(seattle, bellingham.get("Rebecca"));

        //seattle.modifyNameFirst(seattle.get("David"), "Zach"); //should replace davids name with zach
    } // end of main method

    // TODO menu methods

} // end of PhonebookTestMain
