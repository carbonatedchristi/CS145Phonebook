//Programmers: Christina Mymrin
//             Hannah Hendrickson
// Assignment 2 PhoneBook
// Class: CS145 Hybrid01
// Date: 05/13/2022
// Purpose: This program creates a linkedlist for use as a phonebook.
// A user can add, remove, modify, and search for entries via a menu.
// The menu can also view the entire phonebook printed to the console.

// Notes for PhonebookManager:

package PhoneBook;

import java.util.Scanner;

public class PhonebookManager
{
    protected static ListNode front;

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
        if (userSelection == nameLast)
        {
            System.out.println("The last name was found. Please enter the new last name: ");
            nameLast =  input.next();
            return nameLast;
        } // end of if
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

    //modifyNumber method, changes the number field at the given index
    public void modifyNumber(String number, int index)
    {
        ListNode current = nodeAt(index);
        current.number = number;
    } // end of modifyNumber method


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

    // getEntry method, returns the index num of the entry containing the given last name
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
            if (nameLast.equalsIgnoreCase(current.nameLast))
            {
                return index;
            } // end of if
            current = current.next;
            index++;
        } while (current.next != null);

        return -1;
    } // end of getEntry method

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
    public int size()
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

} // end of PhonebookManager class

