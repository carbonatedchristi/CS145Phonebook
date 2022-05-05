public class PhonebookTestMain {

    // TODO delete these hardcoded values
    public static void main(String[] args) {
        PhonebookManager bellingham = new PhonebookManager("Bellingham");
        PhonebookManager seattle = new PhonebookManager("Seattle");

        bellingham.add(new PBNode("David", "1337 Weezer St.", "Bellingham", 682442020));

        seattle.add(new PBNode("Rebecca", "222 Weezer St.", "Seattle", 2026208800));

        System.out.println("I ---------");
        System.out.println();
        System.out.println(bellingham);
        System.out.println(seattle);

        bellingham.transferTo(seattle, bellingham.get("David"));
        bellingham.transferTo(seattle, bellingham.get("Rebecca"));

        seattle.editName(seattle.get("David"), "Zach"); //should replace davids name with zach
    } // end of main method
} // end of PhonebookTestMain
