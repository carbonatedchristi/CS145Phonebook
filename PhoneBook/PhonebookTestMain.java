//Programmers: Christina Mymrin
//             Hannah Hendrickson
// Assignment 2 PhoneBook
// Class: CS145 Hybrid01


package PhoneBook;
import java.util.Scanner;
import java.lang.Character;

import static PhoneBook.PhonebookMenu.*;

public class PhonebookTestMain {

    public static void main(String[] args) {

           Scanner input = new Scanner(System.in);

        //  while (userInput(input))
        // menu method from PBMenu class
        userInput(input);

        //if user responds with yes, open the menu method
        if (userConfirm == true) {
            menu(input);
                //bool from PBMenu, when flickered true, will start the createnode process
                if (userAddEntry == true) {
                    userCreateNode(input);
                }

              //  if (userRemoveEntry == true) {

              //  }
           // menuSelect(input);
        }
        //  }


        //test entries:
        PhonebookManager bellingham = new PhonebookManager();
        bellingham.add("BeastBoy", "Zebra", "address1", "city1", "number1");
        bellingham.add("Harley", "Yvette", "address2", "city2", "number2");
        bellingham.add("firstname3", "Zanzibar", "address3", "city3", "number3");
        bellingham.add("Egg", "Brain", "666 ave", "Bellingham", "12345");
        bellingham.add("Birdie", "IsADog", "1 Canine Drive", "Bham", "00000");
        bellingham.add("Ginkgo", "IsACat", "OriginalAddress", "CardboardBox", "123243");


        System.out.println("Here are the entries for Bellingham!: ");
        bellingham.display(bellingham.front);

        System.out.println(); //--< maybe remove; looks like its just a blank

    } // end of main method
}
