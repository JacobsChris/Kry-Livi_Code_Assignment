package Database;

import junit.framework.TestCase;

import java.util.ArrayList;

import static Database.connection.retrieveDatabase;

public class ConnectionTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
    }

    public void testRetrieveDatabase() {
        ArrayList<Entry> data = retrieveDatabase();
        assertEquals(null, data);
    }
}