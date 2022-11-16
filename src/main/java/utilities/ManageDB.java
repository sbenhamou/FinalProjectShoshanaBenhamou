package utilities;

import java.sql.DriverManager;

public class ManageDB extends CommonOps {

    /*
    ################################################################
    Method Name: openConnection
    Method Description: This Method opens connection to the DataBase
    Method Parameters: Strings
    Method Return: no value return
    ################################################################
    */
    public static void openConnection(String dbURL, String user, String pass) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(dbURL, user, pass);
            stmt = con.createStatement();
        } catch (Exception e) {
            System.out.println("Error Occured while Connecting to DB, See Details: " + e);
        }
    }

    /*
    ################################################################
    Method Name: closeConnection
    Method Description: This Method closes connection to the DataBase
    Method Parameters: no parameter
    Method Return: no value return
    ################################################################
    */
    public static void closeConnection() {
        try {
            con.close();
        } catch (Exception e) {
            System.out.println("Error Occured while Closing to DB, See Details: " + e);
        }
    }
}
