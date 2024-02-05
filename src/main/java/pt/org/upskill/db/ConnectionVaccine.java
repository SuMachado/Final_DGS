package pt.org.upskill.db;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ConnectionVaccine {
    //This is the size of the connection pool.
    private final Integer connectionPoolCount = 1;
    //
    private Integer connectionPoolRequest = 0;
    private static ConnectionVaccine cv;
    private final List<DatabaseConnection> dbConnectionList = new ArrayList<>();
/*
    public static ConnectionFactory getConnectionFactory() {
        if (cf == null) {
            cf = new ConnectionFactory();
        }
        return cf;
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
                    "upskill01",
                    "qwerty");
            dbConnectionList.add(c);
        }
        else {
            c = dbConnectionList.get(connectionPoolRequest-1);
        }
        return c;
    }


}
