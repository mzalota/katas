package com.katas.classes;

import java.util.logging.Level;
import java.util.logging.Logger;


public class MergingService {
    private static Logger logger = Logger.getLogger(MergingService.class.getName());

    private final MergeOneRepository mergeOneRepository = new MergeOneRepository();
    private final MergeTwoRepository mergeTwoRepository = new MergeTwoRepository();

    public double getDiscount( String date, int orderId) {
        int year = Integer.parseInt(date.substring(6,10));
        double discount;
        try {
            discount = mergeOneRepository.loadDiscountFromDB(orderId, year);
        } catch (NumberFormatException e) {
            logger.log (Level.SEVERE, "Error reading from DB");
            return 0;
        }

        if (discount == 0) {
            return mergeTwoRepository.loadPackagePrice(null);
        }
        return discount;
    }

}
