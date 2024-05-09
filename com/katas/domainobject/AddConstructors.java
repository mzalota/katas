package com.katas.domainobject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddConstructors {

    /*
     * ##Replace primitive with "Identifier Type". (https://medium.com/@gara.mohamed/domain-driven-design-the-identifier-type-pattern-d86fd3c128b3)
     *
     * 1)  Refactor: Introduce Parameter Object. Cursor on "lookupPriceInDB()" method. In "Introduce Parameter Object" dialog:
     *    1a) In "Create new class Name" box enter "PriceGroupId".
     *    1b) In "Parameters to Extract" grid select "int priceGroupID" only.
     * 	  1c) Click "Refactor" button.
     *    1d) In "Add File to Git" dialog click "Add" button.
     *  2) Refactor: Introduce Parameter Object. Cursor on "lookupDiscountInDB()" method. In "Introduce Parameter Object" dialog:
     *    2a) Select "Use exiting class" radio button.
     *    2b) In "Name" box enter "com.katas.PriceGroupId".
     *    2c) In "Parameters to Extract" grid select "int priceGroupId" only.
     *    2d) Click "Refactor" button.
     * 3) Refactor: Introduce Parameter. Place cursor in "calculateNetPrice()" method on "new PriceGroupId(priceGroupId)". Replace all 2 occurrences.
     * 4) Refactor: Introduce Variable. Place cursor in "controllerGetPrice()" method on "new PriceGroupId(priceGroupId)".
     * 5) Refactor: Inline Variable. Place current in "controllerGetPrice()" method on "priceGroupIdInt" variable.
     * 6) Refactor: Extract Method. Select in "controllerGetPrice()" method  "new PriceGroupId(Integer.parseInt(priceGroupId))" snippet.
     * 7) Refactor: Move Members. Place cursor on "getPriceGroupId1()" method definition. In "Move Static Members" dialog:
     *    7a) In "To (fully qualified name)" box enter "com.katas.PriceGroupId".
     *    7b) In "Members to be moved (static only") grid, select "getPriceGroupId1()" method.
     *    7c) Click "Refactor" button
     * 8) Intention: Replace constructor with factory method. Place cursor on "PriceGroupId(int)" constructor. In "Replace Constructor With Factory Method" dialog:
     *    8a) In "Factory method name" box enter "createFromInt".
     * 	  8b) Click "Refactor" button.
     * 9) Refactor: Rename. Static factory method "getPriceGroupId1(String)" to be "createFromString()".
     * 10) Refactor: Rename. Method "getPriceGroupID()" in class "PriceGroupId" to be "asInt()".
     * 11) Refactor: Rename. Variables "priceGroupId1" to "priceGroupId" without numeral 1 at the end.
     *
     *
     * Repeat the "Replace primitive with Identifier Type" refactoring flow to replace "int tarifCategory" primitive everywhere with  TarifCategory class (DDD Identifier Type pattern).
     *
     * Repeat the steps above to create "BusinessYear" for the year
     *
     * Create a new Domain object PriceSpecification, which is a combindation of BusinessYear, TarifCategory and PriceGroupId
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