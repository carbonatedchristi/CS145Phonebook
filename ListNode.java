//Programmers: Christina Mymrin
//             Hannah Hendrickson
// Assignment 2 PhoneBook
// Class: CS145 Hybrid01

// TODO all classes need to be in a package to properly use protected keyword

// TODO I think a next method needs to be created
    public class ListNode {
        // node should contain at least name, address, city, and phone number fields in the phonebook node

        private ListNode front;
        protected String nameFirst;
        protected String nameLast;
        protected String address;
        protected String city;
        protected String number; // phone number, maybe rename "number" to "phone"
        public ListNode next;


        public ListNode() {
            front = null;
        } // end of ListNode constructor

        //constructs new node to store the phonebook info and no next node
        public ListNode(String nameFirst, String nameLast,
                        String address, String city, String number) {
            this.nameFirst = nameFirst;
            this.nameLast = nameLast;
            this.address = address;
            this.city = city;
            this.number = number;
            this.next = null;
        } // end of ListNode constructor

        //constructs a new node to store phonebook info and references change to first node
        public ListNode(String nameFirst, String nameLast, String address, String city, String number, ListNode next) {
        this.nameFirst = nameFirst;
        this.nameLast = nameLast;
        this.address = address;
        this.city = city;
        this.number = number;
        this.next = next;
        } // end of ListNode constructor

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

        /* TODO Probably delete, a copy was make in PhonebookManager
    //adds a given phonebook entry and places it in the list in alphabetical order
    public void add(String nameFirst, String nameLast, String address, String city, String number) {
        int index = 0;

        if (front == null) { //check to see if list is empty
            add(nameFirst, nameLast, address, city, number, 0); //<--- figure out purpose of the 0 maybe placeholder?
        } else {
            ListNode current = front;
            //we use this loop to compare the given last name to each entry
            //if the given last name comes before the current name we insert the given name
            do {
                if (nameLast.compareTo(current.nameLast) <  0 ) {
                    add(nameFirst, nameLast, address, city, number, index);
                    return;
                } // end of if

                current = current.next;
                index++;
            } while (current.next != null);
            current.next = new ListNode(nameFirst, nameLast, address, city, number)

        } // end of if/else

    } // end of add method
        */

        /* TODO probably delete, a copy is in PhonebookManager
    public void remove(int index) {
        if (index ==0) {
            front = front.next;
        } else {
            ListNode current = nodeAt(index - 1);
            current.next = current.next.next; //<-- maybe rename .next to make less confusing
        } // end of if/else
    } // end of remove method
        */

    /* TODO probably delete, copied into PhonebookManager
    //returns a reference to the phonebook entry at the given index
    private ListNode nodeAt(int index) {
        ListNode current = front;
        for (int i = 0; i < index; i++) {
            current = current.next;
        } // end of for loop
        return current;
    } // end of nodeAt method
    */

    //returns the index num of the entry containing the given last name
    //returns -1 if phonebook is empty or if no entry found
    public int getEntry(String nameLast) {
        ListNode current = front;
        int index = 0;

        if (front == null) {
            return -1;
        } // end of if
        do { //iterate through list and check if given last name is found
            if (nameLast.equalsIgnoreCase(current.nameLast)) {
                return index;
            } // end of if
            index++;
        } while (current.next != null);

        return -1;
    } // end of getEntry method

    /* TODO possibly delete, all modify methods copied into PhonebookManager
    //modifies the last name of the given entry to the given String
    public void modifyNameLast(String nameLast, int index) {
        ListNode current = nodeAt(index);

        current.nameLast = nameLast;
    } // end of modifyNameLast method

    //modifies the firstname name of the given entry to the given string
    public void modifyNameFirst(String nameFirst, int index) {
        ListNode current = nodeAt(index);

        current.address = address;
    } // end of modifyNameFirst method
//modifies the city of the given entry to the given string

    public void modifyCity(String city, int index) {
        ListNode current = nodeAt(index);

        current.city = city;
    } // end of modifyCity method

    //modifies num of the given entry to the given string
    public void modifyNumber(String number, int index) {
        ListNode current = nodeAt(index);

        current.number = number;
    } // end of modifyNumber method
    */


    //toString method that lists all entries in a phonebook
    public String toString() {
        if (front == null) {
            return "The phonebook is empty!";

        } else {
            String result = front.nameLast + ", " + front.nameFirst + " | " + front.address;
            ListNode current = front.next;
            while (current != null) {
                // I think this method is supposed to print the entire contents of an entry
                // The person who wrote the code we copied from didn't like pressing the enter key lol
                // TODO maybe add Address values to result String
                // I added \n so the code would compile
                result = "\n" + current.nameLast + ", " + current.nameFirst + " | " + "\n";
                        current = current.next;
            } // end of while loop
            return result;
        } // end of if/else
    } // end of toString method

    // toString method that returns the
    public String toString (int index) {
        ListNode current = nodeAt(index);
        // Same issue as previous toString method
        // TODO maybe add Address values here too
        return current.nameLast + ", " + current.nameFirst + " | " + "\n";
    } // end of toString method
} // end of ListNode

    // node should contain at least name, address, city, and phone number fields in the phonebook node

