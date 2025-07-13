package com.katas.helpers;

public class DBAccess {
    public static void readFromDB() throws OracleDBException {
        System.out.println("calling DB");
    }

    public static class OracleDBException extends Exception {
    }
}
