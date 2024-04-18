package com.katas.dependency;

import java.util.logging.Level;
import java.util.logging.Logger;


/*
##### Refactoring flow: "Extract Repository"
Notice three methods that interact DB: "lookupPriceInDB()", "readDiscount()" and loadPackageDiscount(). We will move them to a new repository class one by one.


--- Move lookupPriceInDB() method into the new PriceDiscountRepository class
1) Refactor: "Extract Superclass". (place cursor on class name to get that refactor menu option).
2) In "Extract Superclass" dialog:
   2a) In "Superclass name" enter PriceDiscountRepository
   2b) In "Members To Form Superclass" grid select "lookupPriceInDB()". You see now that "jdbcConnection:String" turned color red, because it is "used by lookupPriceInDB(..)" (hover mouse to see explanation message) and must also be extracted.
   2c) In "Members To Form Superclass" grid select "jdbcConnection:String". Nothing else turned red. You see "logger:Logger" is color blue, because it is "used by lookupPriceInDB(..)" (hover mouse to see explanation message). We will ignore this field, because new class PriceDiscountRepository will need to have its own logger field
   2d) Click "Refactor" button.
   2e) In "Problems Detected" click "Continue" button. We ignore message "Field ExtractRepository.logger is private and will not be accessible from method lookupPriceInDB(int, int, int, int).", because the new class will need its own logger field.
   2f) In "Analyse and Replace Usages" dialog, click "Yes".
   2g) In "Use Interface Where Possible" dialog click "OK" button.
   2h) In "Add File to Git" dialog click "Add" button. (afterward when we perform Git Rollback to reset Kata, this file will be automatically deleted)
3) In PriceDiscountRepository class fix compilation problem due to "logger" field:
   3a) Manually add field: "private static Logger logger = Logger.getLogger(PriceDiscountRepository.class.getName());"
   3b) Replace problematic expression "ExtractRepository.logger.log(...);" with "logger.log(...);".
4) Refactor: "Replace Inheritance with Delegation". (place cursor on ExtractRepository class name to get that refactor menu option).
5) Cleanup PriceDiscountRepository class:
   5a) Intention: "Change access modifier: public". For lookupPriceInDB() method in PriceDiscountRepository class
   5b) Intention: "Change access modifier: private". For jdbcConnection field in PriceDiscountRepository class
   7b) In "Problem Detected" dialog with message "field jdbcConnection with private visibility won't be accessible from method   ExtractRepository.readDiscount(int, int)" click  "Show Conflicts in View" and then jump to readDiscount() method

--- Move readDiscount() method into existing PriceDiscountRepository class
6) Refactor: "Move Instance Method". (place cursor on readDiscount() method in ExtractRepository class).
   6a) Click "Refactor" button.
   6b) In "Problems Detected" dialog click "Continue" button. We ignore this message, because the "logger" field will need to be replaced with PriceDiscountRepository's own.
7) In readDiscount() method in PriceDiscountRepository class:
   7a) Manually replace problematic expression "ExtractRepository.logger.log(...);" with "logger.log(...);"
   7b) Intention: "Change access modifier: public". For readDiscount() method
   7c) Refactor: "Rename": "readDiscount()" to "lookupDiscountInDB()" to be consistent with the other public method
8) Intention: "Change access modifier: private". For jdbcConnection field in PriceDiscountRepository class (Repetition of step 7)

--- Move loadPackagePrice() method into existing PriceDiscountRepository class
9) Refactor: "Move Instance Method". (place cursor on loadPackagePrice() method in ExtractRepository class).
   9a) Click "Refactor" button.
   9b) In "Problems Detected" dialog click "Continue" button. We ignore this message, because the "logger" field will need to be replaced with PriceDiscountRepository's own.
8) In loadPackagePrice() method in PriceDiscountRepository class:
   8a) Manually replace problematic expression "ExtractRepository.logger.log(...);" with "logger.log(...);"
   8b) Intention: "Change access modifier: public". For loadPackagePrice() method
   8c) Refactor: "Rename": "loadPackagePrice()" to "lookupPackagePriceInDB()" to be consistent with the other public methods
9) Try to merge jdbc connection string in lookupPackagePriceInDB with field jdbcConnection
   9a) Refactor: Extract Field. Select seemingly duplicate string "postgresql://username:password@db.internal.com:5555/userdata?".
   9b) In "Initialize in" select "field declaration"
   9c) Check "Replace all occurrences (2)" box. Notice that the other occurrence was found and is, actually, identical!
   9d) Name new field with some temporary name, like "jdbcConnectionTemp"
   9e) Refactor: "Inline Field", the original jdbcConnection, Select "Inline all and remove the field"
   9f) Refactor: Rename "jdbcConnectionTemp" to "jdbcConnection"

*/


public class ExtractRepository {

    private String jdbcConnection = "postgresql://username:password@db.internal.com:5555/PriceDB?" ;
    private static Logger logger = Logger.getLogger(ExtractRepository.class.getName());


    private int lookupPriceInDB(int tarifCategory, int baselineMonth, int baselineYear, int priceGroupIdInt) {

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
            return loadPackagePrice(null);
        }
        return price;
    }

    public double getNettoPrice(int orderId, Integer priceGroupId, int tarifCategory, String date) {
        int month = Integer.parseInt(date.substring(3,5));
        int year = Integer.parseInt(date.substring(6,10));
        try {
            int priceInEuros = lookupPriceInDB(tarifCategory, month, year, priceGroupId);
            double discount = readDiscount(orderId, year);
            return priceInEuros*discount;
        } catch (NumberFormatException e) {
            logger.log (Level.SEVERE, "Error reading from DB");
            return 0;
        }
    }

    private double readDiscount(int orderId, int year) {
        String jdbcConnectionForDiscount = jdbcConnection+";param2=value2";
        logger.log (Level.INFO, "Starting to read Discount from DB, conn: "+jdbcConnectionForDiscount);

        //Nonsensical logic below just simulates looking up of a value in DB. It is NOT "domain logic"
        double responseFromDB = Math.random() * orderId / year;

        return responseFromDB;
    }

    private double loadPackagePrice(Integer packageId) {
        String jdbcConnectionForPackage = "postgresql://username:password@db.internal.com:5555/PriceDB?;param3=value3";
        logger.log (Level.INFO, "Starting to read PackagePrice from DB, conn: "+jdbcConnectionForPackage);

        if (packageId == null) {
            packageId=1; //use default package
        }

        //Nonsensical logic below just simulates looking up of a value in DB. It is NOT "domain logic"
        double responseFromDB = Math.random() + packageId;

        return responseFromDB;
    }

}
