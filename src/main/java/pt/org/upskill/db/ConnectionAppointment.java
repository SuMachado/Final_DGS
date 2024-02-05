package pt.org.upskill.db;

import java.util.ArrayList;
import java.util.List;

public class ConnectionAppointment {
    //This is the size of the connection pool.
    private final Integer connectionPoolCount = 1;
    //
    private Integer connectionPoolRequest = 0;
    private static ConnectionAppointment cf;
    private final List<DatabaseConnection> dbConnectionList = new ArrayList<>();

    public static ConnectionAppointment  getConnectionFactory() {
        if (cf == null) {
            cf = new ConnectionAppointment();
        }
        return cf;
    }

    public DatabaseConnection getDatabaseConnection() {
        DatabaseConnection c;
        if (++connectionPoolRequest > connectionPoolCount) {
            connectionPoolRequest = 1;
        }
        if (connectionPoolRequest > dbConnectionList.size()) {
            c = new DatabaseConnection(
                    "jdbc:oracle:thin:@upskill.dnsfor.me:1521/freepdb1",
                    "upskill14",
                    "qwerty");
            dbConnectionList.add(c);
        }
        else {
            c = dbConnectionList.get(connectionPoolRequest-1);
        }
        return c;
    }
}
