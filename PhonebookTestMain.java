//Programmers: Christina Mymrin
//             Hannah Hendrickson
// Assignment 2 PhoneBook
// Class: CS145 Hybrid01


public class PhonebookTestMain {

    public static void main(String[] args) {
        PhonebookManager bellingham = new PhonebookManager("Bellingham");
        PhonebookManager seattle = new PhonebookManager("Seattle");

        // TODO change PBNode to either PhonebookNode or ListNode, depending on what the actual class name ends up being
        //bellingham.add(new ListNode("David", "LastName", "1337 Weezer St.", "Bellingham", "682442020"));

        //seattle.add(new ListNode("Rebecca", "222 Weezer St.", "Seattle", 2026208800));

        System.out.println("I ---------");
        System.out.println();
        System.out.println(bellingham);
        System.out.println(seattle);

        //bellingham.transferTo(seattle, bellingham.get("David"));
        //bellingham.transferTo(seattle, bellingham.get("Rebecca"));

        //seattle.modifyNameFirst(seattle.get("David"), "Zach"); //should replace davids name with zach
    } // end of main method
} // end of PhonebookTestMain
