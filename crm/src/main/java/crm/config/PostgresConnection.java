package crm.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class PostgresConnection {
	public static Connection getConnection() throws Exception {
        String url = "jdbc:postgresql://localhost:5432/ssm_system";
        String user = "nhom1";
        String password = "123";

        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(url, user, password);
    }
}
