import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

/*
AddressBook - this class represents and contains a possibly every growing and/or shrinking "list" of AddressEntries.
It allows for various operations such as searwch/find, addition and removal of AddressEntries.
 */
public class AdressBook {

    /*
    using linked list to store the addresEntry for better optimization
     */
    private LinkedList<AdressEntry> addressEntryList;

    public List getAddressEntryList(){
        return addressEntryList;
    }

    /*
    default constructor that initializes the list
     */
    public AdressBook() {
        addressEntryList = new LinkedList<>();
    }

    /*
    function that ask file name from the user, open the files
    and if the files opens successfully reads addressEntry from file

    File format:
    FirstName,LastName,Street,City,State,ZipCode,Phone No.,EmailID
    FirstName,LastName,Street,City,State,ZipCode,Phone No.,EmailID
     */
    public void load_from_file() {
        // prompting file name from user
        System.out.print("Enter in FileName:\n>");

        // taking user input of file name
        String filename = Menu.sc.next();
        Scanner input;

        // try to open file, if fails throws exception and returns to main menu
        try {
            input = new Scanner(new FileReader(filename));
        } catch (FileNotFoundException e) {
            System.out.println("Unable to open file!!");
            System.out.println();
            return;
        }

        int count = 0;  // variable to count number of address entry read

        /* reading data until end of file */
        while (input.hasNextLine()) {
            String firstName = "", lastName = "", street = "", city = "", state = "", email = "", phone = "";
            int zip = 0;
            String Line = null;
            if (input.hasNextLine())
                Line = input.nextLine();
            String arr[] = Line.split(",");
            addressEntryList.add(new AdressEntry(arr[0], arr[1], arr[2], arr[3], arr[4], Integer.parseInt(arr[5]), arr[6], arr[7]));
            count++;
        }

        /*
            printing number of address entry variables
            and printing total number of AddressEntry in the list
         */
        System.out.println("Read in " + count + " new Addresses, successfully loaded, currently "
                + addressEntryList.size() + " Addresses");
        input.close();
        System.out.println();
    }

    /*
    Adding new AdressEntry, passed as parameter
    if the AdressEntry do not exist.
    Else print "Record already exists"
     */
    public boolean add(AdressEntry e) {
        if (addressEntryList.contains(e)) {
            System.out.println("Record already exists!!");
            System.out.println(addressEntryList.get((addressEntryList.indexOf(e))));
            System.out.println();
            return false;
        } else {
            addressEntryList.add(e);
            addressEntryList.sort(Comparator.comparing(AdressEntry::getLastName));
            System.out.print("Thank you the following contact has been added to your address book:\n   ");
            System.out.println(e);
        }
        System.out.println();
        return true;
    }

    /*
    Function that takes last name as parameter and calls find
    methods to print all the adress entry starting with the provided last name
    and take the number of choice that the user wants to delete
     */
    public void remove(String lastName) {
        /*
        calling find function and initializing temp list with
        return value of find function
         */
        List<AdressEntry> temp = find(lastName, 1);
        System.out.print(">");

        /*
        takes the number which the user wants to delete
         */
        int n;
        n = Menu.sc.nextInt();

        /*
        validates the input, if it is between the range
         */
        if (n <= 0 || n > temp.size()) {
            System.out.println("Invalid Input!!\n");
            System.out.println();
            return;
        }

        /*
        confirming that the user wants to delete the provided
        choice
         */
        String c;
        System.out.print("Hit y to remove the following entry or n to return to main menu:\n   ");
        System.out.println(temp.get(n - 1));
        System.out.print(">");
        c = Menu.sc.next();

        /*
        if the choice is not "y" or "Y", return to main menu
        without deleting
         */
        if (!c.equalsIgnoreCase("y"))
            return;

        /*
        else remove the AdressEntry from the list
         */
        addressEntryList.remove(temp.get(n - 1));

        /* print the name saying the file is deleted successfully */
        System.out.println("You have successfully removed the " + temp.get(n - 1).getFirstName() + " "
                + temp.get(n - 1).getLastName() + " contact");
        System.out.println();
    }

    /*
    function that takes lastname or beginning part of it
    and a mode. 1 -> when find is called from menu
    and 2 -> when find is called from remove time

    it iterates over the linked list and returns a linked list
    consisting of the required AdressEntry and and also prints it
     */
    public List<AdressEntry> find(String lastName, int mode) {
        List<AdressEntry> temp = new LinkedList<>();

        /*
        iterating over the list and adding the AdressEntry if the
        last name begins with provided lastName parameter
         */
        for (AdressEntry i : addressEntryList) {
            if (i.getLastName().substring(0, lastName.length()).equalsIgnoreCase(lastName)) {
                temp.add(i);
            }
        }

        /*
        if mode = 1, print the line which prints the name to be removed
         */
        if (mode == 1) {
            System.out.println("The following " + temp.size()
                    + " entries were found in the address book, select number of entry you wish to remove:");
        }
        /*
        else print the line when find function is called by user
         */
        else {
            System.out.println("The following " + temp.size()
                    + " entries were found in the address book for a last name starting with " + lastName + ":");
        }

        /*
        printing the AdressEntry in temp list with numbering
         */
        int count = 1;
        for (AdressEntry i : temp) {
            System.out.print(count + ": ");
            System.out.println(i);
            count++;
        }
        System.out.println();

        /*
        returning local linked list
         */
        return temp;
    }

    /*
    printing all the AdressEntry in the list
     */
    public void listing() {
        int count = 1;
        for (AdressEntry i : addressEntryList) {
            System.out.print(count + ": ");
            System.out.println(i);
            count++;
        }
        System.out.println();
    }

    public AdressEntry getAddress(int i){
        if(i<addressEntryList.size())
            return addressEntryList.get(i);
        else
            return null;
    }

    public boolean lessThan(AdressBook e){
        return addressEntryList.size()<e.getAddressEntryList().size();
    }

    public boolean greaterThan(AdressBook e){
        return addressEntryList.size()>e.getAddressEntryList().size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdressBook that = (AdressBook) o;
        return Objects.equals(addressEntryList, that.addressEntryList);
    }

}
