package sample.Data;

import sample.Data.interfaces.IDB;
import sample.entities.Drugs;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

public class PostgresDB implements IDB {
    @Override
    public java.sql.Connection getConnection() throws SQLException, ClassNotFoundException {
        String connectionUrl ="jdbc:postgresql://localhost:5432/Medicines";
        try{
            Class.forName("org.postgresql.Driver");
            Connection con= DriverManager.getConnection(connectionUrl, "postgres", "0000");
            return con;

        } catch (Exception e) {
            System.out.println(e);

            return null;
        }
    }
}

