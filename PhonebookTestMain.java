public class PhonebookTestMain {

    public static void main(String[] args) {
        PBManager bellingham = new PBManager("Bellingham");
        PBManager seattle = new PBManager("Seattle");

        bellingham.add(new PBNode("David", "1337 Weezer St.", "Bellingham", 6882442020));

        seattle.add(new PBNode("Rebecca", "222 Weezer St.", "Seattle", 2026208800));

        System.out.println("I ---------");
        System.out.println();
        System.out.println(bellingham);
        System.out.println(seattle);

        bellingham.transferTo(seattle, bellingham.get("David"));
        bellingham.transferTo(seattle, bellingham.get("Rebecca"));

        seattle.editName(seattle.get("David"), "Zach"); //should replace davids name with zach
    }
}
