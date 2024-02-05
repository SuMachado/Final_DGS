package pt.org.upskill.db;

import java.util.ArrayList;
import java.util.List;

public class ConnectionEmployee {
    //This is the size of the connection pool.
    private final Integer connectionPoolCount = 1;
    //
    private Integer connectionPoolRequest = 0;
    private static ConnectionEmployee ce;
    private final List<DatabaseConnection> dbConnectionList = new ArrayList<>();
    /*
        public static ConnectionEmployee getConnectionEmployee() {
            if (ce == null) {
                ce = new ConnectionEmployee();
            }
            return ce;
        }
    */
    public DatabaseConnection getDatabaseConnection() {
        DatabaseConnection c;
        if (++connectionPoolRequest > connectionPoolCount) {
            connectionPoolRequest = 1;
        }
        if (connectionPoolRequest > dbConnectionList.size()) {
            c = new DatabaseConnection(
                    "jdbc:oracle:thin:@upskill.dnsfor.me:1521/freepdb1",
                    "upskill17",
                    "qwerty");
            dbConnectionList.add(c);
        }
        else {
            c = dbConnectionList.get(connectionPoolRequest-1);
        }
        return c;
    }
}
