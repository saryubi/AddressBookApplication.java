public class AddressBookApplication {
    public static void main(String[] args) {
        String s;

        /* initializing AdressBook object */
        AdressBook a = new AdressBook();

        /* printing until user enters f */
        do {
            s = Menu.print();   // printing menu
            s = s.toLowerCase();

            /* and calling respective AdressBook application */
            if (s.equals("a")) {
                a.load_from_file();
            } else if (s.equals("b")) {
                a.add(new AdressEntry(Menu.prompt_FirstName(),
                        Menu.prompt_LastName(),
                        Menu.prompt_Street(),
                        Menu.prompt_City(),
                        Menu.prompt_State(),
                        Menu.prompt_Zip(),
                        Menu.prompt_Phone(),
                        Menu.prompt_Email()));
            } else if (s.equals("c")) {
                a.remove(Menu.prompt_LastName_remove());
            } else if (s.equals("d")) {
                a.find(Menu.prompt_LastName_find(), 0);
            } else if (s.equals("e")) {
                a.listing();
            } else if (!s.equals("f")) {
                System.out.println("Invalid Input!!\n");
            }
        } while (!s.equals("f"));
        System.out.println("Goodbye!");
    }
}
