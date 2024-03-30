package com.katas;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtractCommand {

    //1) Refactoring: "Introduce Parameter Object...": Class name PriceGroupId, select priceGroupId

    //-- move behavior (converting String to Int) into PriceGroupId class.
    //2) Refactoring: "Extract Method": getAsInt() for code "Integer.parseInt(priceGroupId1.priceGroupId())"
    //3) Refactoring: "Convert to Instance Method...": Select PriceGroup class as destination.

    //-- clean up PriceGroupId class a bit: get rid of unused getPriceGroupId() method
    //4) Refactoring: "Inline Method": PriceGroupId.getPriceGroupId()
    //-- push PriceGroupId object as parameter to lookupPriceInDB() method, instead of Int (Use "Push logic down-stack" Refactoring Flowout)

    // Replace primitive with "Identifier Type".
    //https://medium.com/@gara.mohamed/domain-driven-design-the-identifier-type-pattern-d86fd3c128b3

    //1) Refactoring: "Introduce Parameter Object...": Class name PriceGroupId, select priceGroupId

    //-- move behavior (converting String to Int) into PriceGroupId class.
    //2) Refactoring: "Extract Method": getAsInt() for code "Integer.parseInt(priceGroupId1.priceGroupId())"
    //3) Refactoring: "Convert to Instance Method...": Select PriceGroup class as destination.

    //-- clean up PriceGroupId class a bit: get rid of unused getPriceGroupId() method
    //4) Refactoring: "Inline Method": PriceGroupId.getPriceGroupId()
    //-- push PriceGroupId object as parameter to lookupPriceInDB() method, instead of Int (Use "Push logic down-stack" Refactoring Flowout)

    /*
     * ##Replace primitive with "Identifier Type".
     * ##https://medium.com/@gara.mohamed/domain-driven-design-the-identifier-type-pattern-d86fd3c128b3

    1)  Refactor: Introduce Parameter Object. Cursor on "lookupPriceInDB()" method:
    1a) In "Create new class Name" box enter "PriceGroupId"
    1b) In "Parameters to Extract" grid select "int priceGroupId" only
     *    1e) In "Add File to Git" dialog click "Add" button.

    2) Refactor: Introduce Parameter Object. Cursor on "lookupDiscountInDB()" method. In "Introduce Parameter Object" dialog:
    2a) Select "Use exiting class" radio button
    2b) In "Name" box enter "com.katas.PriceGroupId"
    2c) In "Parameters to Extract" grid select "int priceGroupId" only
    2d) Click "Refactor" button

    2) Refactor: Introduce Parameter. Place cursor in "calculateNetPrice()" method on "new PriceGroupId(priceGroupId)"
    3) Refactor: Introduce Variable. Place cursor in "controllerGetPrice()" method on "new PriceGroupId(priceGroupId)"
    4) Refactor: Inline Variable. Place current in "controllerGetPrice()" method on "priceGroupIdInt" variabel
    5) Refactor: Extract Method. Select in "controllerGetPrice()" method snippet "new PriceGroupId(Integer.parseInt(priceGroupId))"
    6) Refactor: Move Members. Place cursor on "getPriceGroupId1()" method definition
    6a) In "Move Static Members" dialog, in "To (fully qualified name)" enter "com.katas.PriceGroupId"
    6b) In "Members to be moved (static only) grid, select "getPriceGroupId1()" method.
    6c) Click "Refactor" button
    7) Intention: Replace constructor with factory method. Place cursor on "PriceGroupId(int)" constructor.
    7a) In "Replace Constructor With Factory Method" click "Refactor" button.
    8) In PriceGroupId rename factory methods to be "createFromString()" and "createFromInt()"
     */
    public double controllerGetPrice(String tarifCategory, String priceGroupId) {
        int tarifCategoryInt = Integer.parseInt(tarifCategory);
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String today = formatter.format(new Date());
        int priceGroupIdInt = Integer.parseInt(priceGroupId);

        return calculateNettoPrice(tarifCategoryInt,today,priceGroupIdInt);
    }



    protected double calculateNettoPrice(int tarifCategory, String date, int priceGroupId) {
        int month = Integer.parseInt(date.substring(3,5));
        int year = Integer.parseInt(date.substring(6,10));
        try {
            int price = lookupPriceInDB(month, year, tarifCategory, priceGroupId);
            double discount = lookupDiscountInDB(year, priceGroupId, tarifCategory);
            return price*discount;
        } catch (NumberFormatException e) {
            System.out.println("Error reading from DB");
            return 0;
        }
    }

    private static int lookupPriceInDB(int month, int year, int tarifCategory, int priceGroupID) {
        return priceGroupID * tarifCategory + year / month;
    }

    private static double lookupDiscountInDB(int year, int priceGroupId, int tarifCategory) {
        return priceGroupId * tarifCategory + year;
    }

}
