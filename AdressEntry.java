
/*
AddressEntry - this class represents a single Address/Contact information entry in the AddressBook
It should contain contructors, at least one constructor…one that accepts a first, last name,
street, city, state, zip, email, phone.

contain separate class varaibles representing all the information in an AddressEntry contact.

It should contain setX() and getX() methods where X are the class variables. (for example,
setName(***) and getName() where *** are appropriate parameter(s) )
 */
public class AdressEntry implements Comparable<AdressEntry> {

    /* member variables */
    private String firstName, lastName, street, city, state, email, phone;
    private int zip;

    /*
    default constructor
     */
    public AdressEntry() {
        setFirstName("N/A");
        setLastName("N/A");
        setStreet("N/A");
        setCity("N/A");
        setState("N/A");
        setEmail("N/A");
        setPhone("N/A");
        setZip(-1);
    }

    /*
    parameterized constructor
     */
    public AdressEntry(String firstName, String lastName, String street,String city, String state, int zip, String phone,
                       String email) {
        setFirstName(firstName);
        setLastName(lastName);
        setStreet(street);
        setCity(city);
        setState(state);
        setEmail(email);
        setPhone(phone);
        setZip(zip);
    }

    /*
    Accessors and Mutators
     */
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    /*
    toString method that return the member variables in formatted manner
     */
    @Override
    public String toString() {
        return String.format("%s %s\n   %s\n   %s, %s %d\n   %s\n   %s", getFirstName(), getLastName(), getStreet(), getCity(),
                getState(), getZip(), getEmail(), getPhone());
    }

    /*
    compares two AdressEntry last name and returns the greater one
     */
    @Override
    public int compareTo(AdressEntry o) {
        return getLastName().compareTo(o.getLastName());
    }

    /*
    to check for the equality of two AdressEntry object
     */
    public boolean equals(Object e) {
        if(!(e instanceof  AdressEntry))
            return false;
        AdressEntry o = (AdressEntry)e;
        return lastName.equals(o.getLastName()) && firstName.equals(o.getFirstName()) && street.equals(o.getStreet())
                && city.equals(o.getCity()) && state.equals(o.getState()) && phone.equals(o.getPhone())
                && email.equals(o.getEmail()) && zip == o.getZip();
    }
}
