import java.util.ArrayList;
import java.util.Scanner;

public class ContactList {
    private ArrayList<Person> contacts;

    public ContactList() {
        this.contacts = new ArrayList<Person>();
    }

    public ArrayList<Person> getContacts() {
        return contacts;
    }

    public void addContact (Person contact) {
        contacts.add(contact);
    }

    public void printContacts () {
        for (Person contact: contacts) {
            System.out.println(contact);
        }
    }

    public void sort(int sortBy) {
        int len = contacts.size();

        for (int i = 0; i < len-1; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                String firstValue = "";
                String secondValue = "";
                // first name
                if (sortBy == 0) {
                    firstValue = contacts.get(j).getFirstName();
                    secondValue = contacts.get(j + 1).getFirstName();
                }
                else if (sortBy == 1) {
                    firstValue = contacts.get(j).getLastName();
                    secondValue = contacts.get(j + 1).getLastName();
                }
                else {
                    firstValue = contacts.get(j).getPhoneNumber();
                    secondValue = contacts.get(j + 1).getPhoneNumber();
                }

                // compareTo
                if (firstValue.compareTo(secondValue) > 0) {
                    Person temp = contacts.get(j);
                    contacts.set(j, contacts.get(j+1));
                    contacts.set(j+1, temp);
                }
            }
        }
    }

    // is a student function
    public void listStudents() {
        for (Person person: contacts) {
            if (person instanceof Student) {
                System.out.println(person);
            }
        }
    }

    // searching functions
    public Person searchByFirstName(String firstName) {
        for (Person person: contacts) {
            if (person.getFirstName().equals(firstName)) {
                return person;
            }
        }
        return null;
    }

    public Person searchByLastName(String lastName) {
        for (Person person: contacts) {
            if (person.getLastName().equals(lastName)) {
                return person;
            }
        }
        return null;
    }

    public Person searchByPhoneNumber(String phoneNumber) {
        for (Person person: contacts) {
            if (person.getPhoneNumber().equals(phoneNumber)) {
                return person;
            }
        }
        return null;
    }

    public void run () {
        printMenu();
        Scanner input = new Scanner(System.in);
        int response = input.nextInt();
        input.nextLine();
        while (response != 0) {
            // string variable

            String addContact = "";

            // add the contact

            if (response == 1) {
                // check what type they want
                System.out.println("Do you want to add a Student, Teacher, or a Person?");
                addContact = input.nextLine();
                if (addContact.equals("Student")) {
                    // variables

                    String firstName;
                    String lastName;
                    String phoneNumber;
                    int grade;

                    // check first name
                    System.out.println("First Name: ");
                    firstName = input.nextLine();

                    // check last name
                    System.out.println("Last Name: ");
                    lastName = input.nextLine();

                    // check phone number
                    System.out.println("Phone Number: ");
                    phoneNumber = input.nextLine();

                    // check grade
                    System.out.println("Grade: ");
                    grade = input.nextInt();
                    input.nextLine();

                    Person student = new Student(firstName, lastName, phoneNumber, grade);
                    this.addContact(student);
                }
                else if (addContact.equals("Teacher")) {
                    // variables

                    String firstName;
                    String lastName;
                    String phoneNumber;
                    int salary;

                    // check first name
                    System.out.println("First Name: ");
                    firstName = input.nextLine();

                    // check last name
                    System.out.println("Last Name: ");
                    lastName = input.nextLine();

                    // check phone number
                    System.out.println("Phone Number: ");
                    phoneNumber = input.nextLine();

                    // check salary
                    System.out.println("Salary: ");
                    salary = input.nextInt();
                    input.nextLine();

                    Person teacher = new Teacher(firstName, lastName, phoneNumber, salary);
                    this.addContact(teacher);
                }
                else {
                    // variables

                    String firstName;
                    String lastName;
                    String phoneNumber;

                    // check first name
                    System.out.println("First Name: ");
                    firstName = input.nextLine();

                    // check last name
                    System.out.println("Last Name: ");
                    lastName = input.nextLine();

                    // check phone number
                    System.out.println("Phone Number: ");
                    phoneNumber = input.nextLine();

                    Person person = new Person(firstName, lastName, phoneNumber);
                    this.addContact(person);
                }
            }

            // list by first

            else if (response == 2) {
                this.sort(0);
                this.printContacts();
            }

            // list by last
            else if (response == 3) {
                this.sort(1);
                this.printContacts();
            }

            // list by phone
            else if (response == 4) {
                this.sort(2);
                this.printContacts();
            }

            // list all students
            else if (response == 5) {
                this.listStudents();
            }

            // search by first
            else if (response == 6) {
                System.out.println("Enter the name: ");
                addContact = input.nextLine();
                Person person = this.searchByFirstName(addContact);
                if (person == null) {
                    System.out.println(addContact + " is not in the list");
                }
                else {
                    System.out.println(person);
                }
            }

            // search by last

            else if (response == 7) {
                System.out.println("Enter the name: ");
                addContact = input.nextLine();
                Person person = this.searchByLastName(addContact);
                if (person == null) {
                    System.out.println(addContact + " is not in the list");
                }
                else {
                    System.out.println(person);
                }
            }

            // search by phone number

            else if (response == 8) {
                System.out.println("Enter the number: ");
                addContact = input.nextLine();
                this.searchByPhoneNumber(addContact);
                Person person = this.searchByLastName(addContact);
                if (person == null) {
                    System.out.println(addContact + " is not in the list");
                }
                else {
                    System.out.println(person);
                }
            }

            printMenu();
            response = input.nextInt();
            input.nextLine();
        }
    }

    public static void main(String[] args) {
        ContactList contact = new ContactList();
        contact.run();
    }

    public static void printMenu() {
        System.out.println("\nMenu \n" +
                "1. Add Contact\n" +
                "2. List All Contacts By First Name\n" +
                "3. List All Contacts By Last Name\n" +
                "4. List All Contacts By Phone Number\n" +
                "5. List All Students\n" +
                "6. Search By First Name\n" +
                "7. Search By Last Name\n" +
                "8. Search By Phone Number\n" +
                "0. Exit\n");
    }
}
