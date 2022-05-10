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

public class PhonebookManager
{

    protected static ListNode front;

    public PhonebookManager()
    {
        this.front = nodeAt(0);
    } // end of PhonebookManager constructor

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
        else
        {
            current = nodeAt(index - 1);
            current.next = current.next.next;
        } // end of if/else
    } // end of remove method

    // modifyNameLast method, changes the last name in the entry of the given index
    public void modifyNameLast(String nameLast, int index)
    {
        ListNode current = nodeAt(index);

        current.nameLast = nameLast;
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
        while (current != null)
        {
            System.out.print(current.nameLast + ", " + current.nameFirst + " (" +
                    current.address + ", " + current.city + ", " + current.number + ")\n");

            //moves the front to the next node after previous node has been printed
            current = current.next;
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

    protected void sort()
    {
        ListNode current = front;
        ListNode nodeToCompare;


        while (current != null)
        {
            nodeToCompare = current.next;
            while (nodeToCompare != null)
            {
                if (current.nameLast.compareToIgnoreCase(nodeToCompare.nameLast) < 0)
                {
                    // supposed to swap the next values
                    current.setNext(nodeToCompare.next);
                    nodeToCompare.setNext(current);
                } // end of if

                //nodeToCompare = nodeToCompare.next;
            } // end of inner while

            current = current.next;
        } // end of outer while

/*
        // first loop checks the first variable against all others
        // second loop iterates the checked variable
        int i = 0;
        int j;
        for (current = nodeAt(i); current != null; i++)
        {
            nodeToCompare = current.next;
            j = i;
            for (nodeToCompare = nodeAt(j+1); nodeToCompare != null; j++)
            {
                if (current.getLast().compareToIgnoreCase(nodeToCompare.getLast()) > 0)
                {
                    current.setNext(nodeToCompare.next);
                    nodeToCompare.setNext(current);
                    nodeToCompare = nodeToCompare.next;
                } // end of if
                nodeToCompare = nodeToCompare.next;
            } // end of while loop
        } // end of for loop
*/

    } // end of sort method

    public static void powerSwap(ListNode front, ListNode nodeX, ListNode nodeY)
    {
        // First we search the linked list for the nodes we want to swap
        ListNode p = front;
        ListNode prev = null;

        while (p != null && p != nodeX)
        {
            prev = p;
            p = p.next;
        } // end of while loop
        ListNode pX = p;
        ListNode prevX = prev;

        p = front;
        prev = null;
        while (p != null && p != nodeY)
        {
            prev = p;
            p = p.next;
        } // end of while loop
        ListNode pY = p;
        ListNode prevY = prev;

        // Now we swap everything
        ListNode temp;
        temp = pY.next;
        pY.next = pX.next;
        pX.next = temp;

        if (prevX == null)
        {
            front = pY;
            pY.next = pX;
        } // end of if
        if (prevY == null)
        {
            pX = front;
            prevX.next = prevY;
        } // end of if
        if (prevX != null && prevY != null)
        {
            prevX.next = pY;
            prevY.next = pX;
        } // end of if

    } // end of powerSort method

    // swap method, intakes two nodes and swaps their positions
    public static void swap(ListNode node1, ListNode node2)
    {
        node1.setNext(node2.next);
        node2.setNext(node1);
    } // end of swap method

} // end of PhonebookManager class

