package com.katas.classes;

import java.util.logging.Level;
import java.util.logging.Logger;


/*
 *
 *
 * 1) Refactor: Extract Superclass. Place cursor on loadFromDB() in mergeOneReposory class
 *    1a) In "Superclass name" enter "CommonRepository"
 *    1b) In "Members to Form Superclass" select all 3 Members
 *    1c) In "Analyze and Replace Usages" dialog click "Yes"
 *    1d) In "Rename Variables" dialog click "Select all" button and then click "OK".
 *    1e) In "Add File to Git" dialog click "Add" button
 */
public class MergingService {
    private static Logger logger = Logger.getLogger(MergingService.class.getName());

    private final MergeOneRepository mergeOneRepository = new MergeOneRepository();
    private final MergeTwoRepository mergeTwoRepository = new MergeTwoRepository();

    public double getDiscount( String date, int orderId) {
        String year = date.substring(6,10);
        double discount;
        try {
            discount = mergeOneRepository.loadFromDB(orderId, year);
        } catch (NumberFormatException e) {
            logger.log (Level.SEVERE, "Error reading from DB");
            return 0;
        }

        if (discount == 0) {
            return mergeTwoRepository.loadFromDB(null, "default");
        }
        return discount;
    }

}
