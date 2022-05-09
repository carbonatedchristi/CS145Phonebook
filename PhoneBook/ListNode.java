package PhoneBook;
//add names/class and stuff
//TODO: move add, display, node nodeAt() methods to pbmanager
public class ListNode {

    //changed: rewrote some methods, also most notably changed
    //         the access modifiers to the most protected/protected
    //         they can be! also i believe some variable names were
    //         changed so sorry if its confusing at all :(
    /* TODO or maybe just a note idk: i have not tested the code from lines 61-98
     * (the size, getentry, nodeat methods). Could be something to test next in main! :)
     */


    //cant be protected: maybe initialize it in a method rather than global
    protected node front;

    //a class that creates the node
    protected class node {
        protected String nameFirst;
        protected String nameLast;
        protected String address;
        protected String city;
        protected String number;
        protected node next;

        //node constructor method
        protected node(String nameFirst, String nameLast, String address, String city, String number) {
            this.nameFirst = nameFirst;
            this.nameLast = nameLast;
            this.address = address;
            this.city = city;
            this.number = number;
        }

    } // end of protected node class


    //adds a new entry to the linked list
    protected void add(String nameFirst, String nameLast, String address, String city, String number)
    {
        //physically creates the space for new node:
        node newnode = new node(nameFirst, nameLast, address, city, number);

        // moves front to the newly created node
        newnode.next = front;
        front = newnode;
    }

    //displays all of the cotents of the linked list while theres no null
    protected void display(node front) {
        while (front != null)
        {
            System.out.print(front.nameFirst + " " + front.nameLast + " " +
                    front.address + " " + front.city + " " + front.number + " \n");

            //moves the front to the next node after previous node has been printed
            front = front.next;
        }
    }

    // size method, returns the number of entries in the phonebook
    public int size(node front) {
        //this.front = front;
        int count = 0;
        node current = front;
        while (current != null) {
            current = current.next;
            count++;
        } // end of while
        return count;
    } // end of size method


    //returns the index num of the entry containing the given last name
    //returns -1 if phonebook is empty or if no entry found
    public int getEntry(String nameLast) {
        node current = front;
        int index = 0;

        if (front == null) {
            return -1;
        } // end of if
        do { //iterate through list and check if given last name is found
            if (nameLast.equalsIgnoreCase(current.nameLast)) {

                return index;
            } // end of if
            current = current.next;
            index++;
        } while (current.next != null);

        return -1;
    } // end of getEntry method

    //returns a reference to the phonebook entry at the given index
    protected node nodeAt(int index) {
        node current = front;
        for (int i = 0; i < index; i++) {
            current = current.next;
        } // end of for loop
        return current;
    } // end of nodeAt method

    //toString method that lists all entries in a phonebook
    public String toString() {
        if (front == null) {
            return "The phonebook is empty!";

        } else {
            String result = front.nameLast + ", " + front.nameFirst + " | " + front.address;
            node current = front.next;
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
        node current = nodeAt(index);
        // Same issue as previous toString method
        // TODO maybe add Address values here too
        return current.nameLast + ", " + current.nameFirst + " | " + "/n";
    } // end of toString method
} // end of ListNode

// node should contain at least name, address, city, and phone number fields in the phonebook node
