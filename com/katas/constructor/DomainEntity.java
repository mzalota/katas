package com.katas.constructor;



/*
 * Move date parameter from every method to constructor.
 *
 * 1) Refactor: Introduce Field. Place cursor on "date" variable in the body of getPromotion() method in DomainEntity class.
 * 2) Refactor: Introduce Field. Place cursor on "date" variable in the body of getDiscount() method in DomainEntity class.
 *     2a) rename field name from offered "private String date1;" to "private String date;"
 * 3) Intention: Remove field 'date'. Cursor on the second redundant "date" field in DomainEntity class.
 * 4) Refactor: Encapsulate Fields. Place cursor on "date" field in DomainEntity class. In "Encapsulate Fields" dialog:
 *   4a) Select only "date" field. Don't select "multiplier" field
 *   4b) Select 2 boxes in Encapsulate section: , "Set access", "Use accessors even when field is accessible". Deselect "Get access" box
 * 	 4c) Click "Refactor" button.
 * 5) Manually add "return this;" at the bottom of the newly created setDate() method.
 * 6) Intention: Make 'setDate()' return 'com.katas.constructor.DomainEntity'
 * 7) Refactor: Introduce Variable: domainEntity. Place cursor on 'this' keyword in getPromotion() method.
 *
 *
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
 *
 * 14) Refactor: Inline class
 *
 */

public class DomainEntity {

    private final int multiplier;

    public DomainEntity(int multi) {
        this.multiplier = multi;
    }

    public double getDiscount( String date, int orderSize) {
        String year = date.substring(6,10);
        return 15.7 * orderSize * multiplier;
    }

    public double getPromotion( String date, int orderSize) {
        String year = date.substring(6,10);
        return 12.1 * orderSize*multiplier;
    }

}

