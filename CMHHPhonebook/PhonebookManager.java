//Programmers: Christina Mymrin
//             Hannah Hendrickson
// Assignment 2 PhoneBook
// Class: CS145 Hybrid01
// Date: 05/17/2022
// Purpose: This program creates a linkedlist for use as a phonebook.
// A user can add, remove, modify, and search for entries via a menu.
// The menu can also view the entire phonebook printed to the console.
// We both used IntelliJ for our IDE and GitHub for version control.


package CMHHPhonebook;

public class PhonebookManager
{
    protected static ListNode front;

    // display method, prints the formatted contents of each node in list
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
    public static int size()
    {
        int count = 0;
        ListNode current = front;
        while (current != null)
        {
            current = current.next;
            count++;
        } // end of while
        return count;
    } // end of size method

    // nodeAt method, returns the node at the given index
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

    // add method, simply adds new node to end of list
    public static void add(String nameFirst, String nameLast,
                           String address, String city, String number)
    {
        ListNode node = new ListNode(nameFirst, nameLast, address, city, number);

        if (front == null)
        {
            front = node;
        } // end of if
        else
        {
            ListNode current = front;
            while (current.next != null)
            {
                current = current.next;
            } // end of while loop
            current.next = node;
        } // end of else
    } // end of add method

    // remove method, deletes node at the given index
    public void remove(int index)
    {
        ListNode current;
        if (index == 0)
        {
            front = front.next;
        } // end of if
        else if (nodeAt(index).next == null)
        {
            nodeAt(index - 1).next = null;
        } // end of else if
        else
        {
            current = nodeAt(index - 1);
            current.next = current.next.next;
        } // end of else
    } // end of remove method

    //*************************************************\\
    //                MODIFY METHODS                   \\
    //*************************************************\\

    // modifynameFirst method, changes first name to another String
    public void modifyNameFirst(PhonebookManager cityBook)
    {
        String nameToChange;
        String userString = "";
        int nodeIndex = -1;
        boolean changeSuccessful = false;
        do
        {
            System.out.println("First you must select the first name to change.");
            nameToChange = PhonebookMenu.userString();
            nodeIndex = cityBook.getNameFirst(nameToChange);
            if (nodeIndex != -1)
            {
                System.out.println("Please enter the new first name.");
                userString = PhonebookMenu.userString();
                nodeAt(nodeIndex).nameFirst = userString;
                changeSuccessful = true;
            } // end of if
        } while (!changeSuccessful);
    }//end modifyNameFirst method

    //modifyNameLast method, changes user's selected last name to another String
    public void modifyNameLast(PhonebookManager cityBook)
    {
        String nameToChange;
        String userString = "";
        int nodeIndex = -1;
        boolean changeSuccessful = false;
        do
        {
            System.out.println("First you must select the last name to change.");
            nameToChange = PhonebookMenu.userString();
            nodeIndex = cityBook.getNameLast(nameToChange);
            if (nodeIndex != -1)
            {
                System.out.println("Please enter the new last name.");
                userString = PhonebookMenu.userString();
                nodeAt(nodeIndex).nameLast = userString;
                changeSuccessful = true;
            } // end of if
        } while (!changeSuccessful);
    } //end of modifyNameLast method

    //modifyAddress method, changes user's selected address to another String
    public void modifyAddress(PhonebookManager cityBook)
    {
        String nameToChange;
        String userString = "";
        int nodeIndex = -1;
        boolean changeSuccessful = false;
        do
        {
            System.out.println("First you must select the address to change.");
            nameToChange = PhonebookMenu.userString();
            nodeIndex = cityBook.getAddress(nameToChange);
            if (nodeIndex != -1)
            {
                System.out.println("Please enter the new address.");
                userString = PhonebookMenu.userString();
                nodeAt(nodeIndex).address = userString;
                changeSuccessful = true;
            } // end of if
        } while (!changeSuccessful);
    }//end modifyAddress method

    // modifyCity method, changes city name in the entry of given index
    public void modifyCity(PhonebookManager cityBook)
    {
        //Scanner input = new Scanner(System.in);
        String nameToChange;
        String userString = "";
        int nodeIndex = -1;
        boolean changeSuccessful = false;
        do
        {
            System.out.println("First you must select the city to change.");
            nameToChange = PhonebookMenu.userString();
            nodeIndex = cityBook.getCity(nameToChange);
            if (nodeIndex != -1)
            {
                System.out.println("Please enter the new city.");
                userString = PhonebookMenu.userString();
                nodeAt(nodeIndex).city = userString;
                changeSuccessful = true;
            } // end of if
        } while (!changeSuccessful);
    }//end of modifyCity method

    // modifyPhoneNumber method, changes a phone number in the phonebook
    public void modifyPhoneNumber(PhonebookManager cityBook)
    {
        //Scanner input = new Scanner(System.in);
        String nameToChange;
        String userString = "";
        int nodeIndex = -1;
        boolean changeSuccessful = false;
        do
        {
            System.out.println("First you must select the phone number to change.");
            nameToChange = PhonebookMenu.userString();
            nodeIndex = cityBook.getPhoneNumber(nameToChange);
            if (nodeIndex != -1)
            {
                System.out.println("Please enter the new phone number.");
                userString = PhonebookMenu.userString();
                nodeAt(nodeIndex).number = userString;
                changeSuccessful = true;
            } // end of if
        } while (!changeSuccessful);
    }//end modifyPhoneNumber method


    //*************************************************\\
    //                  GET METHODS                    \\
    //*************************************************\\

    // getNameFirst method, returns the index num of the first name containing the given first name
    //returns -1 if phonebook is empty or if no entry found
    public int getNameFirst(String nameFirst)
    {
        ListNode current = front;
        int index = 0;

        if (current == null)
        {
            return -1;
        } // end of if

        do
        { //iterate through list and check if first name exists in the phonebook list
            if (nameFirst.equalsIgnoreCase(current.nameFirst))
            {
                return index;
            } // end of if
            current = current.next;
            index++;
        } while (current.next != null);
        return -1;
    } // end of getNameFirst method

    // getNameLast method, returns the index num of the last name containing the given last name
    //returns -1 if phonebook is empty or if no entry found
    public int getNameLast(String nameLast)
    {
        ListNode current = front;
        int index = 0;

        if (current == null)
        {
            return -1;
        } // end of if

        do
        { //iterate through list and check if the last name exists in the phonebook list
            if (nameLast.equalsIgnoreCase(current.nameLast))
            {
                return index;
            } // end of if
            current = current.next;
            index++;
        } while (current.next != null);
        return -1;
    } // end of getNameLast method

    // getAddress method, returns the index num of the address containing the given address
    //returns -1 if phonebook is empty or if no entry found
    public int getAddress(String address)
    {
        ListNode current = front;
        int index = 0;

        if (current == null)
        {
            return -1;
        } // end of if

        do
        { //iterate through list and check if the address exists in the phonebook list
            if (address.equalsIgnoreCase(current.address))
            {
                return index;
            } // end of if
            current = current.next;
            index++;
        } while (current.next != null);
        return -1;
    } // end of getAddress method

    // getCity method, returns the index num of the City containing the given city
    //returns -1 if phonebook is empty or if no entry found
    public int getCity(String city)
    {
        ListNode current = front;
        int index = 0;

        if (current == null)
        {
            return -1;
        } // end of if

        do { //iterate through list and check if city exists in the phonebook list
            if (city.equalsIgnoreCase(current.city)) {
                return index;
            } // end of if
            current = current.next;
            index++;
        } while (current.next != null);
        return -1;
    } // end of getCity method

    // getPhoneNumber method, returns the index num of the phone num containing the given phone num
    //returns -1 if phonebook is empty or if no entry found
    public int getPhoneNumber(String number)
    {
        ListNode current = front;
        int index = 0;

        if (current == null)
        {
            return -1;
        } // end of if

        do
        { //iterate through list and check if phone number exists in the phonebook list
            if (number.equalsIgnoreCase(current.number))
            {
                return index;
            } // end of if
            current = current.next;
            index++;
        } while (current.next != null);
        return -1;
    } // end of getPhoneNumber method

} //end of PBManager class
