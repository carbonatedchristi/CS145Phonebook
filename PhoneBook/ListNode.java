//Programmers: Christina Mymrin
//             Hannah Hendrickson
// Assignment 2 PhoneBook
// Class: CS145 Hybrid01
// Date: 05/13/2022
// Purpose: This program creates a linkedlist for use as a phonebook.
// A user can add, remove, modify, and search for entries via a menu.
// The menu can also view the entire phonebook printed to the console.

package PhoneBook;

public class ListNode {

    protected ListNode front;
    protected String nameFirst;
    protected String nameLast;
    protected String address;
    protected String city;
    protected String number;
    protected ListNode next;

    //ListNode constructor method
    public ListNode(String nameFirst, String nameLast, String address, String city, String number) {
        this.nameFirst = nameFirst;
        this.nameLast = nameLast;
        this.address = address;
        this.city = city;
        this.number = number;
    } // end of ListNode constructor

    //returns a reference to the phonebook entry at the given index
    public ListNode nodeAt(int index)
    {
        ListNode current = front;
        for (int i = 0; i < index; i++) {
            current = current.next;
        } // end of for loop
        return current;
    } // end of nodeAt method

    //toString method that lists all entries in a phonebook
    public String toString()
    {
        if (front == null) {
            return "The phonebook is empty!";

        } // end of if
        else {
            String result = front.nameLast + ", " + front.nameFirst + " | " + front.address;
            ListNode current = front.next;
            while (current != null) {
                result = "\n" + current.nameLast + ", " + current.nameFirst + " | " + "\n";
                current = current.next;
            } // end of while loop
            return result;
        } // end of else
    } // end of toString method

    // toString method, returns string representation of node at given index
    public String toString(int index)
    {
        ListNode current = nodeAt(index);

        return current.nameLast + ", " + current.nameFirst + " (" +
                current.address + ", " + current.city + ", " + current.number;
    } // end of toString method

    // setNext method, nets the next value of the node called upon
    public void setNext(ListNode newNext) {
        this.next = newNext;
    } // end of setNext method


    //***********************************************\\
    //  get methods: returns the string when called  \\
    //***********************************************\\

    public String getNameLast() {
        return this.nameLast;
    } // end of getLast

    public String getNameFirst() {
        return this.nameFirst;
    } // end of getFirst

    public String getAddress() {
        return this.address;
    } //end of getAddress

    public String getCity() {
        return this.city;
    } //end of getCity

    public String getNumber() {
        return this.number;
    } //end of getNumber

} //end of ListNode class
