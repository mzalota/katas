package com.katas.domainobject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddFactoryMethods {

    /*
     * ## Add Factory Methods.
     *
     * 1) Refactor: Introduce Parameter Object. Cursor on "lookupPriceInDB()" method. In "Introduce Parameter Object" dialog:
     *    1a) In "Create new class Name" box enter "MonthYear".
     *    1b) In "Parameters to Extract" grid select "int month" and "int year" only.
     * 	  1c) Click "Refactor" button.
     *    1d) In "Add File to Git" dialog click "Add" button.
     * 3) Refactor: Introduce Variable. Place cursor in "calculateNettoPrice()" method on "new MonthYear(month, year)".
     * 4) Refactor: Inline Variable. Place cursor in "calculateNettoPrice()" method on "month" variable.
     * 5) Refactor: Inline Variable. Place cursor in "calculateNettoPrice()" method on "year" variable.
     * 6) Refactor: Extract Method. Select in "controllerGetPrice()" snippet: "new MonthYear(...)".
     * 7) Refactor: Move Members. Place cursor on newly created "getMonthYear()" method definition. In "Move Static Members" dialog:
     *    7a) In "To (fully qualified name)" box enter "com.katas.domainobject.MonthYear".
     *    7b) In "Members to be moved (static only)" grid, select "getMonthYear()" method.
     *    7c) Click "Refactor" button
     * 8) Intention: Replace constructor with factory method. Place cursor on "MonthYear(int, int)" constructor. In "Replace Constructor With Factory Method" dialog:
     *    8a) In "Factory method name" box enter "createFromIntegers".
     * 	  8b) Click "Refactor" button.
     * 9) Refactor: Rename. Static factory method "getMonthYear(String)" to be "createFromString()".
     * 10) Refactor: Introduce Parameter. Place cursor in "calculateNettoPrice()" method on "monthYear" variable.
     * 11) Refactor: Introduce Variable. Place cursor in "controllerGetPrice()" method on "MonthYear.createFromString(today)" snippet.
     * 12) Refactor: Extract Method. Select first 3 code lines in "controllerGetPrice()" method, name it "createFromToday()"
     * 13) Refactor: Move Members. Place cursor on newly created "createFromToday()" method definition. In "Move Static Members" dialog:
     *    13a) In "To (fully qualified name)" box enter "com.katas.domainobject.MonthYear".
     *    13b) In "Members to be moved (static only)" grid, select "createFromToday()" method.
     *    13c) Click "Refactor" button
     *
     * Now MonthYear class has three clean factory methods:
     * - createFromString(String)
     * - createFromIntegers(int, int)
     * - createFromToday()
     *
     */
    public double controllerGetPrice(int priceGroupId) {
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String today = formatter.format(new Date());

        return calculateNettoPrice(today, priceGroupId);
    }

    protected double calculateNettoPrice(String date, int priceGroupId) {
        int month = Integer.parseInt(date.substring(3,5));
        int year = Integer.parseInt(date.substring(6,10));

        try {
            int price = lookupPriceInDB(month, year, priceGroupId);
            return price;
        } catch (NumberFormatException e) {
            System.out.println("Error reading from DB");
            return 0;
        }
    }

    private static int lookupPriceInDB(int month, int year, int priceGroupID) {
        return priceGroupID + year / month;
    }
}