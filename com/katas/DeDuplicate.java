package com.katas;

import java.util.logging.Level;
import java.util.logging.Logger;


/*
##### Refactoring flow: "Extract Repository"
Notice three methods that interact DB: "lookupPriceInDB()", "readDiscount()" and loadPackageDiscount(). We will move them to a new repository class one by one.

9) Try to merge jdbc connection string in lookupPackagePriceInDB with field jdbcConnection
   9a) Refactor: Extract Field. Select seemingly duplicate string "postgresql://username:password@db.internal.com:5555/userdata?".
   9b) In "Initialize in" select "field declaration"
   9c) Check "Replace all occurrences (2)" box. Notice that the other occurrence was found and is, actually, identical!
   9d) Name new field with some temporary name, like "jdbcConnectionTemp"
   9e) Refactor: "Inline Field", the original jdbcConnection, Select "Inline all and remove the field"
   9f) Refactor: Rename "jdbcConnectionTemp" to "jdbcConnection"

*/


public class DeDuplicate {

    private String jdbcConnection = "postgresql://username:password@db.internal.com:5555/userdata?" ;
    private static Logger logger = Logger.getLogger(DeDuplicate.class.getName());


    /*
    1) Right-click on DeDuplicat.java tab on top and select "Split Right". Align lookupPriceInDB() and readPrices() functions. You can jump between them with "Ctrl+Tab" shortcut
    2) Try Extract Method on last two lines from lookupPriceInDB() to see if the middle two lines in readPrices would be detected.
    3) Undo, because IntelliJ did not detect duplication.
    4) In lookupPriceInDB apply "Extract Variable" refactoring to the last line (or use Intention: introduce local variable on "return" statement)
    5) In readPrices() move String jdbcConnectionForPrice varible declaration to the top of the function.
    6) You see that now only the 2 places with log statements differ. Copy/paste these log statements to make them identical in each function
    7) Select all statements in the body of one function and
     */

    private int lookupPriceInDB(int tarifCategory, int validitMonth, int validityYear, int priceGroupIdInt) {

        String jdbcConnectionForPrice = jdbcConnection+";param1=value1";
        logger.log (Level.INFO, "Starting to read Price from DB, conn: "+jdbcConnectionForPrice);

        String queryStr = queryBuilder(tarifCategory, validitMonth, validityYear, priceGroupIdInt);
        return executeQuery(jdbcConnectionForPrice, queryStr);
    }

    private static String queryBuilder(int year, int month, int tarifCategoryId, int priceGroupId) {
        return "SELECT column FROM db.table";
    }

    private int readPrices(int year, int month, int tarifCategoryId, int priceGroupId) {
        logger.log (Level.INFO, "Starting to read Price from DB");

        String connStr = jdbcConnection+";param1=value1";
        logger.log (Level.INFO, "DB connection is: "+connStr);

        String sql = queryBuilder(year, month, tarifCategoryId, priceGroupId);

        int responseFromDB = executeQuery(connStr, sql);

        logger.log (Level.INFO, "Finishing reading Price from DB. Response is: "+responseFromDB);
        return responseFromDB;
    }

    private static String queryBuilder1(int tarifCategory, int validitMonth, int validityYear, int priceGroupIdInt) {
        String queryStr = "";
        queryStr += "SELECT price FROM price_table WHERE";
        queryStr += " ";
        queryStr += "price_group_id = "+ priceGroupIdInt;
        queryStr += " AND ";
        queryStr += "category_id = "+ tarifCategory;
        queryStr += " AND ";
        queryStr += "validity_month = '"+ validityYear +"-"+ validitMonth +"'";
        return queryStr;
    }

    private int lookupPriceInDBOrig(int tarifCategory, int baselineMonth, int baselineYear, int priceGroupIdInt) {

        String jdbcConnectionForPrice = jdbcConnection+";param1=value1";
        logger.log (Level.INFO, "Starting to read Price from DB, conn: "+jdbcConnectionForPrice);

        //Nonsensical logic below just simulates looking up of a value in DB. It is NOT "domain logic"
        int responseFromDB = priceGroupIdInt * tarifCategory + baselineYear / baselineMonth;

        return responseFromDB;
    }

    public double getBaselinePrice(Integer priceGroupId, int tarifCategory) {
        int baselineMonth = 01;
        int baselineYear = 2001;

        int price = lookupPriceInDB(tarifCategory, baselineMonth, baselineYear, priceGroupId);
        if (price == 0) {
            return readPrices(baselineYear, baselineMonth, tarifCategory, priceGroupId);
        }
        return price;
    }


    private static String queryBuilder2(int year, int month, int tarifCategoryId, int priceGroupId) {
        String selectedFields = "price";
        String tableName = "price_table";
        String whereClause = "";
        whereClause += "price_group_id = '"+ priceGroupId +"'  AND ";
        whereClause += "category_id = '"+ tarifCategoryId +"'  AND ";
        whereClause += "validity_month = '"+ year +"-"+ month +"';";
        String sql = "SELECT " + selectedFields + " FROM " + tableName + " WHERE "+whereClause +";";
        return sql;
    }

    int executeQuery(String jdbcConnectionForPrice, String sqlQuery){
        System.out.println("jdbcConnectionForPrice: " +jdbcConnectionForPrice);
        System.out.println("sqlQuery: "+sqlQuery);
        return 5;
    }

    public double getNettoPrice(int orderId, Integer priceGroupId, int tarifCategory, String date) {
        int month = Integer.parseInt(date.substring(3,5));
        int year = Integer.parseInt(date.substring(6,10));
        try {
            int priceInEuros = lookupPriceInDB(tarifCategory, month, year, priceGroupId);
            double discount = 13;
            return priceInEuros*discount;
        } catch (NumberFormatException e) {
            logger.log (Level.SEVERE, "Error reading from DB");
            return 0;
        }
    }

}
