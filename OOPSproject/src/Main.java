package OOPSproject.src;

import java.sql.*;

public class Main {
    static final String DB_URL = "jdbc:mysql://localhost:3306/OOP_project"; // Database URL
    static final String USER = "root"; // Database Username
    static final String PASS = "password"; // Database Password

    public static void main(String[] args) {
        Operations_implementation op1 = new Operations_implementation();
        try {

            Connection con = DriverManager.getConnection(DB_URL, USER, PASS);  // connection
            Statement stmt = con.createStatement();  // statement
            String sql; // sql query

            switch (args[0]) { // flags

            case "-h": // help
            {
                System.out.println(" -h: help");
                System.out.println(" -c: create table ");
                System.out.println(" -p: print all the columns");
                System.out.println(" -i: insert data into the columns");
                System.out.println(" -q: quit");
                break;
            }

            case "-c": // create
            {

                String[] columnName = new String[4];
                String[] columnType = new String[4];
                columnName[0] = "id";
                columnName[1] = "first";
                columnName[2] = "last";
                columnName[3] = "age";
                columnType[0] = "INTEGER";
                columnType[1] = "VARCHAR(255)";
                columnType[2] = "VARCHAR(255)";
                columnType[3] = "INTEGER";

                sql = op1.createTable("REGISTRATION", columnName, columnType);

                stmt.executeUpdate(sql);
                System.out.println("Table created successfully");
                break;
            }

            case "-p": {

                ResultSet rs = stmt.executeQuery(op1.printTable("REGISTRATION"));
                while (rs.next()) {
                    System.out.println("ID = " + rs.getInt(1) + ", First = " + rs.getString(2) + ", Last = "
                            + rs.getString(3) + ", Age = " + rs.getInt(4));
                }
                rs.close();
                con.close();

                break;
            }

            case "-i": {
                sql = "INSERT INTO Registration VALUES (100, 'Zara', 'Ali', 18)";
                stmt.executeUpdate(sql);
                sql = "INSERT INTO Registration VALUES (101, 'Mahnaz', 'Fatma', 25)";
                stmt.executeUpdate(sql);
                sql = "INSERT INTO Registration VALUES (102, 'Zaid', 'Khan', 30)";
                stmt.executeUpdate(sql);
                sql = "INSERT INTO Registration VALUES(103, 'Sumit', 'Mittal', 28)";
                stmt.executeUpdate(sql);
                System.out.println("Data inserted successfully");
                break;
            }

            case "-q": {
                break;
            }

            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}