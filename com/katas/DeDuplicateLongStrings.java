package com.katas;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DeDuplicateLongStrings {


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


    private static String queryBuilder2(int year, int month, int tarifCategoryId, int priceGroupId) {
        String selectedFields = "price";
        String tableName = "price_table";
        String whereClause = "";
        whereClause += "validity_month = '"+ year +"-"+ month +"';";
        whereClause += "category_id = '"+ tarifCategoryId +"'  AND ";
        whereClause += "price_group_id = '"+ priceGroupId +"'  AND ";
        String sql = "SELECT " + selectedFields + " FROM " + tableName + " WHERE "+whereClause +";";
        return sql;
    }

}
