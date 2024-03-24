package com.katas;

import java.util.logging.Level;
import java.util.logging.Logger;


// ##### Refactoring flow: "Extract Repository"
// Notice three methods that call DB: "lookupPriceInDB()", "readDiscount()" and loadPackageDiscount(). We will move them to a new repository class one by one.
//
// --- Refactor lookupPriceInDB() method into the new PriceDiscountRepository class
//1) Refactor: "Extract Superclass". (place cursor on class name to get that refactor menu option)
//2) In "Extract Superclass" dialog:
//   2a) In "Superclass name" enter PriceDiscountRepository
//   2b) In "Members To Form Superclass" grid select lookupPriceInDB(). You see now that "jdbcConnection:String" turned color red, because it is "used by lookupPriceInDB()" function (hover mouse to see explanation message) and must also be extracted.
//   2c) In "Members To Form Superclass" grid select jdbcConnection(). Nothing else turned red. logger:Logger turned color blue necause it is "used by lookupPriceInDB()" (hover mouse to see explanation message). We will ignore this field, because new class PriceDiscountRepository will need to have its own logger field
//   2d) Click "Refactor" button. Problem Detected dialog pops up with message "Field ExtractRepository.logger is private and will not be accessible from method lookupPriceInDB(int, int, int, int).".
//   2e) Click "Continue" button in Problems Detected dialog.
//   2f) In "Analyse and Replace Usages" dialog, click "Yes" -> there will be no additional changes made.
//   2g) In "Add file to Git" dialog click Add. (afterward when we perform Git Rollback, this file will automatically be deleted)
//3) In PriceDiscountRepositry class
//   3a) Add field: private static Logger logger = Logger.getLogger(PriceDiscountRepository.class.getName());
//   3b) Replace problematic expression ExtractRepository.logger.log(...); with logger.log();
//4) Navigate to definition of class ExtractRepository. Refactor: "Replace Inheritence with Delegation", click "Refactor" button

public class ExtractRepository {

    private String jdbcConnection = "postgresql://username:password@db.internal.com:5555/userdata?" ;
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
        String jdbcConnectionForPackage = "postgresql://username:password@db.internal.com:5555/userdata?;param3=value3";
        logger.log (Level.INFO, "Starting to read PackagePrice from DB, conn: "+jdbcConnectionForPackage);

        if (packageId == null) {
            packageId=1; //use default package
        }

        //Nonsensical logic below just simulates looking up of a value in DB. It is NOT "domain logic"
        double responseFromDB = Math.random() + packageId;

        return responseFromDB;
    }

}
