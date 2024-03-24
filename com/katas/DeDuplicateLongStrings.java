package com.katas;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DeDuplicateLongStrings {

    /*
     * 1) Intention: "Join declaration and assignment". Cursor on "queryStr" variable
     * 2) Repeat previous step until the string is on one line
     * 3) Intention: "Remove empty string operand". Cursor on "" (empty string)
     * 4) Intention: "Remove unnecessary parentheses". Cursor on a parentheses.
     * 5) Intention: "Join concatenated string literals". Cursor on '+' just before " "
     * 6) Intention: "Replace '+' with 'String.format()'"
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
     * 1) Refactor "Inline Field": selectedFields
     * 2) Refactor "Inline Field": tableName
     * 3) Intention: "Join declaration and assignment". Cursor on "whereClause" variable
     * 4) Intention: "Remove empty string operand". Cursor on "" (empty string)
     * 5) Intention: "Remove unnecessary parentheses". Cursor on a parentheses.
     * 8) Intention: "Join concatenated string literals".
     * 9) Repeat previous step until the string of "whereClause" is on one line
     * 6) Refactor "Inline Field": whereClause
     * 7) Intention: "Remove unnecessary parentheses". Cursor on a parentheses.
     * 8) Intention: "Join concatenated string literals".
     * 9) Intention: "Replace '+' with 'String.format()'"
     * 10) Refactor "Extract Field" query2
     */
    private static String queryBuilder2(int year, int month, int tarifCategoryId, int priceGroupId) {
        String selectedFields = "price";
        String tableName = "price_table";
        String whereClause = "";
        whereClause += "validity_month = '"+ year +"-"+ month +"' AND ";
        whereClause += "category_id = '"+ tarifCategoryId +"'  AND ";
        whereClause += "price_group_id = '"+ priceGroupId;
        String sql = "SELECT " + selectedFields + " FROM " + tableName + " WHERE "+whereClause +";";
        return sql;
    }

}
