package finalexam.task3;

public class FactoryTester {

    public static void main(String[] args) {
        PaperFactory factory = new PaperFactory();

        Person person1 = new Person("Alice", "Johnson", "123456789");
        Person person2 = new Person("Bob", "Williams", "987654321");

        factory.addPerson(person1);
        factory.addPerson(person2);

        System.out.println("Factory staff after adding persons: " + factory.getStaff());

        try {
            factory.saveStaffToFile("staff.dat");
            factory.deletePerson(person1);
            factory.deletePerson(person2);
            System.out.println("Factory staff after deleting persons: " + factory.getStaff());

            factory.loadStaffFromFile("staff.dat");
            System.out.println("Factory staff after loading from file: " + factory.getStaff());
        } catch (java.io.IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
