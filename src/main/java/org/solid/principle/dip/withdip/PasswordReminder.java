package org.solid.principle.dip.withdip;

public class PasswordReminder {
    private DBConnectionInterface dbConnection;

    public PasswordReminder(DBConnectionInterface dbConnection) {
        this.dbConnection = dbConnection;
    }
}
