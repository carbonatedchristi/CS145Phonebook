public class ListNode {

    public class ListNode {
        // node should contain at least name, address, city, and phone number fields in the phonebook node

        private PhonebookNode front;

        public String nameFirst;
        public String nameLast;
        public String city;
        public String number;
        public PhonebookNode next;

        public PhonebookNode() {
            front = null;
        }

        //constructs new node to store the phonebook info and no next node
        public PhonebookNode(String nameFirst, String nameLast, String address, String city, String number) {
            this.nameFirst = nameFirst;
            this.nameLast = nameLast;
            this.address = address;
            this.city = city;
            this.number = number;
            this.next = null;
        }

        //constructs a new node to store phonebook info and reference to the ???
        public PhonebookNode(String nameFirst, String nameLast, String address, String city, String number)
        this.nameFirst = nameFirst;
        this.nameLast = nameLast;
        this.address = address;
        this.city = city;
        this.number = number;
        this.next = next;
    }

    public int size() {
        int count = 0;
        PhonebookNode current = front;
        while (current != null) {
            current = current.next;
            count++;
        }
        return count;
    }

    //adds a given phonebook entry and places it in the list in alphabetical order
    public void add(String nameFirst, String nameLast, String address, String city, String number) {
        int index = 0;

        if (front == null) { //check to see if list is empty
            add(nameFirst, nameLast, address, city, number, 0);
        } else {
            PhonebookNode current = front;
            //we use this loop to compare the given last name to each entry
            //if the given last name comes before the current name we insert the given name
            do {
                if (nameLast.compareTo(current.nameLast) <  0 ) {
                    add(nameFirst, nameLast, address, city, number, index);
                    return;
                }

                current = current.next;
                index++
            } while (current.next != null);
            current.next = new PhonebookNode(nameFirst, nameLast, address, city, number)

        }

    }

    public void remove(int index) {
        if (index ==0) {
            front = front.next;
        } else {
            PhonebookNode current = nodeAt(index - 1);
            current.next = current.next.next;
        }
    }

    //returns a reference to the phonebook entry at the given index
    private PhonebookNode nodeAt(int index) {
        PhonebookNode current = front;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    //returns the index num of the entry containing the given last name
//returns -1 if phonebook is empty or if no entry foudn
    public int getEntry(String nameLast) {
        PhonebookNode current = front;
        int index = 0;

        if (front == null) {
            return -1;
        }
        do { //iterate through list and check if given last name is found
            if (current.nameLast.toLowerCase().equals(nameLast.toLowerCase())) {
                return index;
            }
            index++
        } while (current.next != null);

        return -1;
    }

    //modifies the last name of the given entry to the given String
    public void modifyNameLast(String nameLast, int index) {
        PhonebookNode current - nodeAt(index);

        current.nameLast = nameLast;
    }

    //modifies the firstname name of the given entry to the given string
    public void modifyNameFirst(String nameFirst, int index) {
        PhonebookNode current - nodeAt(index);

        current.address = address;
    }
//modifies the city of the given entry to the given string

    public void modifyCity(String city, int index) {
        PhonebookNode current - nodeAt(index);

        current.city = city;
    }

    //modifies num of the given dentry to the given string
    public void modifyNumber(String number, int index) {
        PhonebookNode current = nodeAt(index);

        current.number = number;
    }

//returns a string that lists all entries in the phonebook

    public String toString() {
        if (front == null) {
            return "The phonebook is empty!";

        } else {
            String result = front.nameLast + ", " + front.nameFirst + " | " + front.address;
            PhonebookNode current = front.next;
            while current ( != null) {
                result += "\n" + current.nameLast + ", " + current.nameFirst + " | " + ////////////////figure out what here
                        current = current.next;
            }
            return result;
        }
    }

    public String toString (int index) {
        PhonebookNode current -nodeAt(index);
        String result = current.nameLast + ", " + current.nameFirst + " | " + current.nameFirst; ///////uncertain
        return result;
    }
}

    // node should contain at least name, address, city, and phone number fields in the phonebook node

