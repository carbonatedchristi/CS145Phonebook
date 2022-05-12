//Programmers: Christina Mymrin
//             Hannah Hendrickson
// Assignment 2 PhoneBook
// Class: CS145 Hybrid01
       //manager will allow you to either add an entry
         //(name, address, city, phone #) to the end and then sort it,    } // end of PhoneBookManager
 //or alphabetically by last name.  You can also modify the entry,
 //delete entries, or move them from the Bellingham to the Seattle
 //phone book (optional).  Finally, you should be able to print out
 //your list in a nice format.

package PhoneBook;

import java.util.Scanner;

public class PhonebookManager
{

    protected static ListNode front;

    /*
    public PhonebookManager()
    {
        this.front = nodeAt(0);
    } // end of PhonebookManager constructor
    */

    // add method, simply adds new node to end of list
    public static void add(String nameFirst, String nameLast,
                           String address, String city, String number)
    {
        ListNode node = new ListNode(nameFirst, nameLast, address, city, number);

        if (front == null)
        {
            front = node;
        }
        else
        {
            ListNode current = front;
            while (current.next != null)
            {
                current = current.next;
            } // end of while loop
            current.next = node;
        } // end of if/else
    } // end of add method

    /* TODO will probably delete this method, instead we'll have two add methods and a sorting method
    // 1st add method will put the new entry at the end of the list
    // 2nd add method will add the new entry at an index
    //adds a given phonebook entry and places it in the list in alphabetical order
    public void add(String nameFirst, String nameLast,
                    String address, String city, String number, int extraValue) {
        int index = 0;
        if (front == null) {
            // if list is empty, adds first value
            add(nameFirst, nameLast, address, city, number); // Deleted the 0 that was the last value
        } else {
            ListNode current = front;
            //we use this loop to compare the given last name to each entry
            //if the given last name comes before the current name we insert the given name
            do {
                // I believe compareTo method determines if the current last name comes first alphabetically, which would return a -1
                if (nameLast.compareTo(current.nameLast) <  0 ) {
                    add(nameFirst, nameLast, address, city, number, index);
                    return;
                } // end of if
                current = current.next;
                index++;
            } while (current.next != null);
            current.next = new ListNode(nameFirst, nameLast, address, city, number);
        } // end of if/else
    } // end of add method
    */

    // remove method, deletes node at the given index
    public void remove(int index)
    {
        ListNode current;
        if (index == 0)
        {
            front = front.next;
        }
        else if(nodeAt(index).next == null)
        {
            nodeAt(index -1).next = null;
        }
        else
        {
            current = nodeAt(index - 1);
            current.next = current.next.next;
        } // end of if/else
    } // end of remove method


    //TODO: this isnt included in the main method, however it does have structures for line 116 usermodifynode() method
    // in the PhonebookMenu class, so keep for now for reference
    //modifyNameLast method, changes the last name in the entry of the given index
    public static String modifyNameLast()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("pb managPlease enter the current first name of the entry you would like to modify:");
        String userSelection = input.next();
        userSelection = userSelection.toLowerCase();
        String nameLast = "";
        if (userSelection == nameLast) {
            System.out.println("The last name was found. Please enter the new last name: ");
            nameLast =  input.next();
            return nameLast;
        }
       // ListNode current = nodeAt(index);

       // current.nameLast = nameLast;
        return userSelection;
    } // end of modifyNameLast method

    // modifyNameFirst method, changes first name in the entry of given index
    public void modifyNameFirst(String nameFirst, int index)
    {
        ListNode current = nodeAt(index);

        current.nameFirst = nameFirst;
    } // end of modifyNameFirst method


    // modifyCity method, changes city name in the entry of given index
    public void modifyCity(String city, int index)
    {
        ListNode current = nodeAt(index);
        current.city = city;
    } // end of modifyCity method

    //modifies num of the given entry to the given string
    public void modifyNumber(String number, int index)
    {
        ListNode current = nodeAt(index);
        current.number = number;
    } // end of modifyNumber method


    //returns a reference to the phonebook entry at the given index
    public ListNode nodeAt(int index)
        throws NullPointerException
    {
        ListNode current = front;

        for (int i = 0; i < index; i++)
        {
            if (current.next == null)
            {
                // cuts the method short if the next node is null
                // this avoids NullPointerException
                return current;
            } // end of if
            current = current.next;
        } // end of for loop
        return current;
    } // end of nodeAt method

    //returns the index num of the entry containing the given last name
    //returns -1 if phonebook is empty or if no entry found
    public int getEntry(String nameLast)
    {
        ListNode current = front;
        int index = 0;

        if (front == null)
        {
            return -1;
        } // end of if

        do
        { //iterate through list and check if given last name is found
            if (nameLast.equalsIgnoreCase(current.nameLast)) {

                return index;
            } // end of if
            current = current.next;
            index++;
        } while (current.next != null);

        return -1;
    } // end of getEntry method

    //displays all of the contents of the linked list while theres no null
    protected static void display(ListNode front)
    {
        ListNode current = front;
        int i = 1;
        // iterates through the linked list, adds a number to each entry
        while (current != null)
        {
            System.out.print(i + ". " + current.nameLast + ", " + current.nameFirst + " (" +
                    current.address + ", " + current.city + ", " + current.number + ")\n");

            //moves the front to the next node after previous node has been printed
            current = current.next;
            i++;
        } // end of while loop
    } // end of display method

    // size method, returns the number of entries in the phonebook
    public int size() {
        int count = 0;
        ListNode current = front;
        while (current != null) {
            current = current.next;
            count++;
        } // end of while
        return count;
    } // end of size method

} // end of PhonebookManager class

