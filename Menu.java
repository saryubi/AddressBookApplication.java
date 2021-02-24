import java.util.Scanner;

public class Menu {
    // static scanner variable used all over the program
    static Scanner sc = new Scanner(System.in);

    /*
    printing the menu and taking userinput from user
     */
    public static String print() {
        System.out.println("*****************************\r\n" + "Please enter in your menu selection\r\n"
                + "a) Loading From File\r\n" + "b) Addition\r\n" + "c) Removal\r\n" + "d) Find\r\n" + "e) Listing\r\n"
                + "f) Quit\r\n" + "*****************************");
        System.out.print(">");
        String in = sc.next();
        return in;
    }

    /*
    prompt_* function for all variables
     */

    public static String prompt_FirstName() {
        System.out.print("First Name:\n>");
        sc.nextLine();
        String fname = sc.nextLine();
        return fname;
    }

    public static String prompt_LastName() {
        System.out.print("Last Name:\n>");
        String lname = sc.nextLine();
        return lname;
    }

    public static String prompt_Street() {
        System.out.print("Street:\n>");
        String street = sc.nextLine();
        return street;
    }

    public static String prompt_City() {
        System.out.print("City:\n>");
        String city = sc.nextLine();
        return city;
    }

    public static String prompt_State() {
        System.out.print("State:\n>");
        String state = sc.nextLine();
        return state;
    }

    public static int prompt_Zip() {
        System.out.print("Zip:\n>");
        int zip = sc.nextInt();
        return zip;
    }

    public static String prompt_Phone() {
        System.out.print("Phone: xxx-aaa-bbbb\n>");
        sc.nextLine();
        String phone = sc.nextLine();
        return phone;
    }

    public static String prompt_Email() {
        System.out.print("Email:\n>");
        String email = sc.nextLine();
        return email;
    }

    public static String prompt_LastName_remove() {
        System.out.print("Enter in Last Name of contact to remove:\n>");
        sc.nextLine();
        String lname = sc.nextLine();
        return lname;
    }

    public static String prompt_LastName_find() {
        System.out.print("Enter in all or the begining of the Last Name of the contact you wish to find:\n>");
        sc.nextLine();
        String lname = sc.nextLine();
        return lname;
    }

}
