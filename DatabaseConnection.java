package leaveManagement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DatabaseConnection {

    private static final String URL = "jdbc:mysql://" + getEnvOrDefault("DB_HOST", "localhost") + ":" 
            + getEnvOrDefault("DB_PORT", "3306") + "/" 
            + getEnvOrDefault("DB_NAME", "leave_employee_management") 
            + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
            
    private static final String USERNAME = getEnvOrDefault("DB_USER", "root");
    private static final String PASSWORD = System.getenv("DB_PASS");

    private DatabaseConnection() {}

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver not found", e);
        }
    }

    private static String getEnvOrDefault(String key, String defaultValue) {
        String value = System.getenv(key);
        return (value != null && !value.trim().isEmpty()) ? value : defaultValue;
    }
}