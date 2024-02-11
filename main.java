import java.util.Random;
import java.util.Scanner;

public class EmailApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Getting user input details
        System.out.print("Enter the new hire's first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter the new hire's last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter the new hire's department (1 for sales, 2 for development, 3 for accounting, 0 for none): ");
        int departmentChoice = scanner.nextInt();
        scanner.nextLine(); 

        // Create a new Email object
        Email newHireEmail = new Email(firstName, lastName, departmentChoice);

        // Display information
        System.out.println("\nNew hire information:");
        System.out.println(newHireEmail.showInfo());

        scanner.close();
    }
}

class Email {

    private String firstname;
    private String lastname;
    private String email;
    private String companyname = "googlecompany.com";
    private String department;
    private String password;
    private int defaultpasswordlength = 10;
    private int mailboxCapacity = 800; // Default mailbox capacity
    private String alternateEmail;

    public Email(String firstname, String lastname, int departmentChoice) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.department = setDepartment(departmentChoice);
        this.password = randomPassword(defaultpasswordlength);
        this.email = firstname.toLowerCase() + "." + lastname.toLowerCase() + "@" + department + "." + companyname;
    }

    private String setDepartment(int choice) {
        switch (choice) {
            case 1:
                return "sales";
            case 2:
                return "development";
            case 3:
                return "accounting";
            default:
                return "none";
        }
    }

    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        char[] password = new char[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int rand = random.nextInt(passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    public String getName() {
        return firstname + " " + lastname;
    }

    public String getEmail() {
        return email;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String showInfo() {
        return "Name: " + getName() +
                "\nEmail: " + getEmail() +
                "\nMailbox Capacity: " + getMailboxCapacity() + "mb";
    }
}
