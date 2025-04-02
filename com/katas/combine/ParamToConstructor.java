package com.katas.combine;

import java.util.logging.Level;
import java.util.logging.Logger;



/*
 * Combine MergeOneRepository and MergeTwoRepository classes into CommonRepository class, without breaking any existing references.
 *
 * 1) Refactor: Extract Superclass. Place cursor on "loadFromDB()" method in "MergeOneReposory" class:
 *    1a) In "Superclass name" box enter "CommonRepository".
 *    1b) In "Members to Form Superclass" grid select all 3 members and then click "Refactor" button.
 *    1c) In "Analyze and Replace Usages" dialog click "Yes".
 *    1d) In "Rename Variables" dialog click "Select all" button and then click "OK".
 *    1e) In "Add File to Git" dialog click "Add" button.
 * 2) In CommonRepository class, in definition of logger field, replace "MergeOneRepository" class with "CommonRepository".
 * 3) Refactor: Inline. Place cursor on "MergeOneReposory" class. Click "Refactor" button.
 * 4) Manually add "extends CommonRepository" to MergeTwoRepository class definition.
 * 5) Refactor: Pull Members Up Superclass. Place cursor on "loadFromDB()" method in "MergeTwoReposory" class:
 *    5a) In "Members to be pulled up", select all members.
 *    5b) In Problems Detected we see messages that Common Repository already contains loadFromDB() method and logger field. Click "Cancel"
 *    5c) In "Pull Members Up" dialog "Click" button again.
 * 6) Refactor: Rename... "loadFromDB()" in MergeTwoReposory class to "loadFromDB2()". Select "Refactor only current method".
 * 7) Refactor: Pull Members Up Superclass. Place cursor on "loadFromDB()" method in "MergeTwoReposory" class
 *    7a) In "Members to be pulled up" check "loadFromDB2()" and "jdbcConnection:String"
 * 	  7b) In Problems Detected we see message that "logger" will not be accessible. We ignore this problem. Click "Continue" button.
 * 8) In "CommonRepository.loadFromDB2()" method replace problematic "MergeTwoRepository.logger" with "logger"
 * 9) In "MergeTwoRepository" class delete "logger" field, so that the class is empty.
 * 10) Refactor: Inline. Place cursor on "MergeTwoReposory" class. Click "Refactor" button.
 * 11) Refactor: Extract Field. In "MergingService", select "new CommonRepository()" code snippet. Check "Replace all occurences(2)" box. Field "commonRepository" will be created.
 * 12) Refactor: Inline Field. "mergeOneRepository"
 * 13) Refactor: Inline Field. "mergeTwoRepository"
 * 14) In CommonRepository class deduplicate "jdbcConnection*" fields and "loadFromDB*" methods
 *
 */

public class ParamToConstructor {


    public double getDiscount( String date, int orderId) {
        String year = date.substring(6,10);
        return 15.7;
    }


    public double getPromotion( String date, int orderId) {
        String year = date.substring(6,10);
        return 12.1;
    }

}

class Consumer {


    public void doLogic1( String date, int orderId) {
        ParamToConstructor paramToConstructor = new ParamToConstructor();
        paramToConstructor.getDiscount("2022-02-02", 19);
    }


    public void doLogic2( String date, int orderId) {
        ParamToConstructor paramToConstructor = new ParamToConstructor();
        paramToConstructor.getPromotion("2011-11-11", 19);
    }

}