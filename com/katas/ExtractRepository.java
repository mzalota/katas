package com.katas;

import java.util.logging.Level;
import java.util.logging.Logger;


// #####Refactoring flow: "Extract Repository"
//
//---Move logic into Repository
//1) Refactor: "Extract Superclass". (place cursor on class name to get that refactor menu option)
//2) In "Extact Superclass" dialog:
//   2a) In "Superclass name" enter PriceDiscountRepository
//   2b) In "Members To Form Superclass" grid select lookupPriceInDB(). You see now now that "jdbcConnection:String" turned color red, because it is "used by lookupPriceInDB()" function (hover mouse to see explanation message) and must also be extracted.
//   2c) In "Members To Form Superclass" grid select jdbcConnection(). Nothing else turned red. logger:Logger turned color blue necause it is "used by lookupPriceInDB()" (hover mouse to see explanation message). We will ignore this field, because new class PriceDiscountRepository will need to have its own logger field
//   2d) Click "Refactor" button. Problem Detected dialog pops up with message "Field ExtractRepository.logger is private and will not be accessible from method lookupPriceInDB(int, int, int, int).".
//   2e) Click "Continue" button in Problems Detected dialog.
//   2f) In "Analyse and Replace Usages" dialog, click "Yes" -> there will be no additional changes made.
//   2g) In "Add file to Git" dialog click Add. (afterward when we perform Git rollback, this file will automatically be deleted)
//3) in PriceDiscountRepositry class
//   3a) add field: private static Logger logger = Logger.getLogger(PriceDiscountRepository.class.getName());
//   3b) replace ExtractRepository.logger.log(...); with logger.log();

public class ExtractRepository {

    private String jdbcConnection = "postgresql://username:password@db.internal.com:5555/userdata?" ;
    private static Logger logger = Logger.getLogger(ExtractRepository.class.getName());


    public double getBaselinePrice(Integer priceGroupId, int tarifCategory) {
        int baselineMonth = 01;
        int baselineYear = 2001;

        return lookupPriceInDB(tarifCategory, baselineMonth, baselineYear, priceGroupId);
    }

    private int lookupPriceInDB(int tarifCategory, int baselineMonth, int baselineYear, int priceGroupIdInt) {
        logger.log (Level.INFO, "Reading Price from DB");

        jdbcConnection = jdbcConnection+";param1=value1";
        //Nonsensical logic below just simulates looking up of a value in DB. It is NOT "domain logic"
        return priceGroupIdInt * tarifCategory + baselineYear / baselineMonth;
    }

    public double getNettoPrice(int orderId, Integer priceGroupId, int tarifCategory, String date) {
        int month = Integer.parseInt(date.substring(3,5));
        int year = Integer.parseInt(date.substring(6,10));
        try {
            int priceInEuros = lookupPriceInDB(tarifCategory, month, year, priceGroupId);
            double discount = lookupDiscountInDB(orderId, year);
            return priceInEuros*discount;
        } catch (NumberFormatException e) {
            logger.log (Level.SEVERE, "Error reading from DB");
            return 0;
        }
    }

    private double lookupDiscountInDB(int orderId, int year) {
        logger.log (Level.INFO, "Reading Discount from DB");
        jdbcConnection = jdbcConnection+";param2=value2";
        //Nonsensical logic below just simulates looking up of a value in DB. It is NOT "domain logic"
        return Math.random()*orderId/year;
    }

}
