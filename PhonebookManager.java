//Programmers: Christina Mymrin
//             Hannah Hendrickson
// Assignment 2 PhoneBook
// Class: CS145 Hybrid01


public class PhonebookManager {

    private ListNode front;

    // PhonebookManager constructor
    public PhonebookManager(String city) {
        // TODO
    } // end of PhonebookManager constructor


    //adds a given phonebook entry and places it in the list in alphabetical order
    public void add(String nameFirst, String nameLast, String address, String city, String number) {
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

    // remove method, deletes node at the given index
    public void remove(int index) {
        if (index ==0) {
            front = front.next;
        } else {
            ListNode current = nodeAt(index - 1);
            current.next = current.next.next; //<-- maybe rename .next to make less confusing
        } // end of if/else
    } // end of remove method

    // modifyNameLast method, changes the last name in the entry of the given index
    public void modifyNameLast(String nameLast, int index) {
        ListNode current = nodeAt(index);

        current.nameLast = nameLast;
    } // end of modifyNameLast method

    // modifyNameFirst method, changes first name in the entry of given index
    public void modifyNameFirst(String nameFirst, int index) {
        ListNode current = nodeAt(index);

        current.address = address;
    } // end of modifyNameFirst method


    // modifyCity method, changes city name in the entry of given index
    public void modifyCity(String city, int index) {
        ListNode current = nodeAt(index);

        current.city = city;
    } // end of modifyCity method

    //modifies num of the given entry to the given string
    public void modifyNumber(String number, int index) {
        ListNode current = nodeAt(index);

        current.number = number;
    } // end of modifyNumber method



    //manager will allow you to either add an entry
    //(name, address, city, phone #) to the end and then sort it,
    //or alphabetically by last name.  You can also modify the entry,
    //delete entries, or move them from the Bellingham to the Seattle
    //phone book (optional).  Finally, you should be able to print out
    //your list in a nice format.


} // end of PhoneBookManager