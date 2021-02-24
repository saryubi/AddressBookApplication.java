import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdressBookTest {

    AdressBook a = new AdressBook();

    @Test
    void testgetAddressEntryList() {
        a = new AdressBook();
        a.add(new AdressEntry());
        assertEquals(a.getAddressEntryList().size(),1);
    }

    @Test
    void testadd() {
        a = new AdressBook();
        a.add(new AdressEntry());
        assertEquals(a.add(new AdressEntry()),false);
    }

    @Test
    void testfind() {
        a = new AdressBook();
        a.add(new AdressEntry("Arian","Aryubi","4160 High Ridge pl","Castro Valley","CA",94552,"510-565-5475","arianaryubi@gmail.com"));
        assertEquals(a.find("Ary",0).size() ,1);
    }

    @Test
    void testgetAddress() {
        a = new AdressBook();
        a.add(new AdressEntry("Arian","Aryubi","4160 High Ridge pl","Castro Valley","CA",94552,"510-565-5475","arianaryubi@gmail.com"));
        AdressEntry e = new AdressEntry("Arian","Aryubi","4160 High Ridge pl","Castro Valley","CA",94552,"510-565-5475","arianaryubi@gmail.com");
        assertEquals(a.getAddress(0),e);
    }

    @Test
    void testlessThan1() {
        a = new AdressBook();
        a.add(new AdressEntry("Arian","Aryubi","4160 High Ridge pl","Castro Valley","CA",94552,"510-565-5475","arianaryubi@gmail.com"));
        a.add(new AdressEntry("Davante","Adams","613 Austin Way","Austin","Texas",78663,"808-765-4563","dadams@yahoo.com"));
        AdressBook b = new AdressBook();
        b.add(new AdressEntry("George","Kittle","7896 Greenville Cir","Castro Valley","CA",94552,"510-333-5790","george_kit@hotmail.com"));
        assertTrue(b.lessThan(a));
    }

    @Test
    void testlessThan2() {
        a = new AdressBook();
        a.add(new AdressEntry("Arian","Aryubi","4160 High Ridge pl","Castro Valley","CA",94552,"510-565-5475","arianaryubi@gmail.com"));
        a.add(new AdressEntry("Davante","Adams","613 Austin Way","Austin","Texas",78663,"808-765-4563","dadams@yahoo.com"));
        AdressBook b = new AdressBook();
        b.add(new AdressEntry("Davante","Adams","613 Austin Way","Austin","Texas",78663,"808-765-4563","dadams@yahoo.com"));
        b.add(new AdressEntry("George","Kittle","7896 Greenville Cir","Castro Valley","CA",94552,"510-333-5790","george_kit@hotmail.com"));
        assertFalse(b.lessThan(b));
    }

    @Test
    void testgreaterThan1() {
        a = new AdressBook();
        a.add(new AdressEntry("Arian","Aryubi","4160 High Ridge pl","Castro Valley","CA",94552,"510-565-5475","arianaryubi@gmail.com"));
        a.add(new AdressEntry("Davante","Adams","613 Austin Way","Austin","Texas",78663,"808-765-4563","dadams@yahoo.com"));
        AdressBook b = new AdressBook();
        b.add(new AdressEntry("George","Kittle","7896 Greenville Cir","Castro Valley","CA",94552,"510-333-5790","george_kit@hotmail.com"));
        assertTrue(a.greaterThan(b));
    }

    @Test
    void testgreaterThan2() {
        a = new AdressBook();
        a.add(new AdressEntry("Arian","Aryubi","4160 High Ridge pl","Castro Valley","CA",94552,"510-565-5475","arianaryubi@gmail.com"));
        a.add(new AdressEntry("Davante","Adams","613 Austin Way","Austin","Texas",78663,"808-765-4563","dadams@yahoo.com"));
        AdressBook b = new AdressBook();
        b.add(new AdressEntry("Davante","Adams","613 Austin Way","Austin","Texas",78663,"808-765-4563","dadams@yahoo.com"));
        b.add(new AdressEntry("George","Kittle","7896 Greenville Cir","Castro Valley","CA",94552,"510-333-5790","george_kit@hotmail.com"));
        assertFalse(a.greaterThan(b));
    }


    @Test
    void testEqual1() {
        a = new AdressBook();
        a.add(new AdressEntry("Arian","Aryubi","4160 High Ridge pl","Castro Valley","CA",94552,"510-565-5475","arianaryubi@gmail.com"));
        a.add(new AdressEntry("Davante","Adams","613 Austin Way","Austin","Texas",78663,"808-765-4563","dadams@yahoo.com"));
        AdressBook b = new AdressBook();
        b.add(new AdressEntry("Davante","Adams","613 Austin Way","Austin","Texas",78663,"808-765-4563","dadams@yahoo.com"));
        b.add(new AdressEntry("George","Kittle","7896 Greenville Cir","Castro Valley","CA",94552,"510-333-5790","george_kit@hotmail.com"));
        assertNotEquals(a,b);
    }

    @Test
    void testEqual2() {
        a = new AdressBook();
        a.add(new AdressEntry("Arian","Aryubi","4160 High Ridge pl","Castro Valley","CA",94552,"510-565-5475","arianaryubi@gmail.com"));
        a.add(new AdressEntry("Davante","Adams","613 Austin Way","Austin","Texas",78663,"808-765-4563","dadams@yahoo.com"));
        AdressBook b = new AdressBook();
        b.add(new AdressEntry("Davante","Adams","613 Austin Way","Austin","Texas",78663,"808-765-4563","dadams@yahoo.com"));
        b.add(new AdressEntry("Arian","Aryubi","4160 High Ridge pl","Castro Valley","CA",94552,"510-565-5475","arianaryubi@gmail.com"));
        assertEquals(a,b);
    }
}