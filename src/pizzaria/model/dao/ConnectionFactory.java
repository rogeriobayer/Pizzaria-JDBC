package pizzaria.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection getConnection() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/sales?allowPublicKeyRetrieval=true&useTimezone=true&serverTimezone=UTC&useSSL=false", "root", "123risi");//"rrw@and14"
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
