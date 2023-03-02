package org.example.jdbc;

import java.sql.*;

public class Jdbc {

    public static void main(String[] args) {
        Jdbc jdbc = new Jdbc();
        jdbc.createTable();
//        jdbc.getUsers();
//        jdbc.createUser();
//        jdbc.deleteUser();
    }

    public void createTable() {
        String QUERY = """
                DROP TABLE IF EXISTS USERS;
                CREATE TABLE USERS
                (
                    user_id     INT PRIMARY KEY AUTO_INCREMENT,
                    first_name  VARCHAR(250),
                    family_name VARCHAR(250),
                    email       VARCHAR(250) NOT NULL,
                    password    VARCHAR(250) NOT NULL
                );
                                
                insert into users (user_id, first_name, family_name, email, password) values (default, 'Vasya', 'Pupkin', 'pupkin@gmail.com', '123456');
                insert into users (user_id, first_name, family_name, email, password) values (default, 'Masha', 'Pupkina', 'pupkina@gmail.com', '123456789');
                                    
                """;
        System.out.println(QUERY);
        try (Connection connection = H2JdbcUtils.getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute(QUERY);
        } catch (SQLException e) {
            H2JdbcUtils.printSQLException(e);
        }
    }

    public void getUsers() {
        String QUERY = """
                select * from users;
                """;

        try (Connection connection = H2JdbcUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY)) {
            System.out.println("SQL:" + preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("user_id");
                String firstName = rs.getString("first_name");
                String familyName = rs.getString("family_name");
                String email = rs.getString("email");
                String password = rs.getString("password");
                System.out.println(id + "," + firstName + "," + familyName + "," + email + "," + password);
            }
        } catch (SQLException e) {
            H2JdbcUtils.printSQLException(e);
        }
    }

    private void createUser() {
        final String INSERT_SQL = "insert into users (user_id, first_name, family_name, email, password) values (default, ?, ?, ?, ?);";

        try (Connection connection = H2JdbcUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL)) {
            preparedStatement.setString(1, "Taras");
            preparedStatement.setString(2, "Vyhor");
            preparedStatement.setString(3, "vyhor-star@gmail.com");
            preparedStatement.setString(4, "dsflkjhnfgsdhgbfls");
        } catch (SQLException e) {
            H2JdbcUtils.printSQLException(e);
        }
    }

    private void deleteUser() {
        final String DELETE_SQL = "delete from users where email = ?";
        try (Connection connection = H2JdbcUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SQL)) {
            preparedStatement.setString(1, "vyhor-star@gmail.com");
            int i = preparedStatement.executeUpdate();
            System.out.println("effected rows: " + i);
        } catch (SQLException e) {
            H2JdbcUtils.printSQLException(e);
        }
    }
}
