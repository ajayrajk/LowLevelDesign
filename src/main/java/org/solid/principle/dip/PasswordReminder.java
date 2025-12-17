package org.solid.principle.dip;

public class PasswordReminder {
    private MySQLConnection dbConnection;

    public PasswordReminder(MySQLConnection dbConnection) {
        this.dbConnection = dbConnection;
    }
}
