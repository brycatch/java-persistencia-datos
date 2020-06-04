package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMySql {
    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_mensajes?serverTimezone=UTC", "root", "");
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return connection;
    }

}
