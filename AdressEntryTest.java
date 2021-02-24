import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdressEntryTest {

    AdressEntry a;
    @Test
    void testgetFirstName() {
        a = new AdressEntry("Arian","Aryubi","4160 High Ridge pl","Castro Valley","CA",94552,"510-565-5475","arianaryubi@gmail.com");
        assertEquals(a.getFirstName(), ("Arian"));
    }

    @Test
    void testsetFirstName() {
        a = new AdressEntry("Arian","Aryubi","4160 High Ridge pl","Castro Valley","CA",94552,"510-565-5475","arianaryubi@gmail.com");
        a.setFirstName("Davante");
        assertEquals(a.getFirstName(),"Davante");
    }

    @Test
    void testgetLastName() {
        a = new AdressEntry("Arian","Aryubi","4160 High Ridge pl","Castro Valley","CA",94552,"510-565-5475","arianaryubi@gmail.com");
        assertEquals(a.getLastName(),"Aryubi");
    }

    @Test
    void testsetLastName() {
        a = new AdressEntry("Arian","Aryubi","4160 High Ridge pl","Castro Valley","CA",94552,"510-565-5475","arianaryubi@gmail.com");
        a.setLastName("Adams");
        assertEquals(a.getLastName(),"Adams");
    }

    @Test
    void testgetZip() {
        a = new AdressEntry("Arian","Aryubi","4160 High Ridge pl","Castro Valley","CA",94552,"510-565-5475","arianaryubi@gmail.com");
        assertEquals(a.getZip(),94552);
    }

    @Test
    void testsetZip() {
        a = new AdressEntry("Arian","Aryubi","4160 High Ridge pl","Castro Valley","CA",94552,"510-565-5475","arianaryubi@gmail.com");
        a.setZip(78663);
        assertEquals(a.getZip(),78663);
    }

    @Test
    void testToString() {
        a = new AdressEntry("Arian","Aryubi","4160 High Ridge pl","Castro Valley","CA",94552,"510-565-5475","arianaryubi@gmail.com");
        assertEquals(a.toString(),("Arian Aryubi\n" +
                "   4160 High Ridge pl\n" +
                "   Castro Valley, CA 94552\n" +
                "   arianaryubi@gmail.com\n" +
                "   510-565-5475"));
    }

    @Test
    void testcompareTo1() {
        a = new AdressEntry("Arian","Aryubi","4160 High Ridge pl","Castro Valley","CA",94552,"510-565-5475","arianaryubi@gmail.com");
        AdressEntry b = new AdressEntry("Davante","Adams","613 Austin Way","Austin","Texas",78663,"808-765-4563","dadams@yahoo.com");
        assertTrue(a.compareTo(b)>0);
    }

    @Test
    void testcompareTo2() {
        a = new AdressEntry("Arian","Aryubi","4160 High Ridge pl","Castro Valley","CA",94552,"510-565-5475","arianaryubi@gmail.com");
        AdressEntry b = new AdressEntry("Davante","Adams","613 Austin Way","Austin","Texas",78663,"808-765-4563","dadams@yahoo.com");
        assertTrue(b.compareTo(a)<0);
    }

    @Test
    void testEquals1() {
        a = new AdressEntry("Arian","Aryubi","4160 High Ridge pl","Castro Valley","CA",94552,"510-565-5475","arianaryubi@gmail.com");
        AdressEntry b = new AdressEntry("Davante","Adams","613 Austin Way","Austin","Texas",78663,"808-765-4563","dadams@yahoo.com");
        assertNotEquals(a, b);
    }

    @Test
    void testEquals2() {
        a = new AdressEntry("Arian","Aryubi","4160 High Ridge pl","Castro Valley","CA",94552,"510-565-5475","arianaryubi@gmail.com");
        AdressEntry b = new AdressEntry("Arian","Aryubi","4160 High Ridge pl","Castro Valley","CA",94552,"510-565-5475","arianaryubi@gmail.com");
        assertEquals(a, b);
    }
}