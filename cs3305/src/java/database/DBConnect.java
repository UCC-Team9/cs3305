package database;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * DBConnect.java
 *
 * Handles connection to database
 *
 * @author  Kevin Patrick Murphy 111314826
 * @version 1.2
 * @date    11/2/14
 */
public class DBConnect {

    private String dbServer;
    private String DSN;
    private String dbUsername;
    private String dbPassword;

    private InetAddress ipAddress = null;

    private final dbClass dbClass;

    /**
     * Constructor
     */
    public DBConnect() {
        setupDatabaseDetails();
        dbClass = new dbClass();
        dbClass.setup(dbServer, DSN, dbUsername, dbPassword);
        System.out.println("DB setup: " + dbClass.isSetup());
    }

    
    /*Returns database object*/
    public Connection getConnection() {
        return dbClass.getConnectionObject();
    }

    /**
     * Gets the local machines IP address, checks if the machine is located in a
     * college lab, or is my own machine, and configures database details
     * accordingly
     */
    public void setupDatabaseDetails() {

        try {
            ipAddress = InetAddress.getLocalHost();
        } catch (UnknownHostException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }

        String hostIP = ipAddress.getHostAddress();
        System.out.println("Host IP: " + hostIP);

        if (hostIP.startsWith("143.239")) {
            //For Connecting within College Lab
            dbServer = "cs1.ucc.ie";
            DSN = "2015_krs1";
            dbUsername = "krs1";
            dbPassword = "uceirooy";
            System.out.println("Deploying on Lab Computer");
        } else {
            //Connecting at home
            dbServer = "localhost";
            DSN = "cs3305";
            dbUsername = "root";
            dbPassword = "Cassini97";
            System.out.println("Deploying on Home Computer");
        }
    }//End of setupDatabaseDetails()
}

