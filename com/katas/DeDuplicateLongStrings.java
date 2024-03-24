package com.katas;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DeDuplicateLongStrings {

    /*
     * 1) Intention: "Join declaration and assignment". Cursor on "queryStr" variable
     * 2) Intention: "Remove empty string operand"
     * 3) Intention: "Remove unnecessary parentheses"
     * 4) Intention: "Replace '+' with 'String.format()'"
     *
     */

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

    /*
     * 1) Refactor "Extract Field": selectedFields
     * 2) Refactor "Extract Field": tableName
     *
     * 10) Refactor "Extract Field": whereClause
     */

    private static String queryBuilder2(int year, int month, int tarifCategoryId, int priceGroupId) {
        String selectedFields = "price";
        String tableName = "price_table";
        String whereClause = "";
        whereClause += "validity_month = '"+ year +"-"+ month +"' AND ";
        whereClause += "category_id = '"+ tarifCategoryId +"'  AND ";
        whereClause += "price_group_id = '"+ priceGroupId +"';";
        String sql = "SELECT " + selectedFields + " FROM " + tableName + " WHERE "+whereClause +";";
        return sql;
    }

}
