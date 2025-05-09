package com.katas.combine;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MergeOneRepository {

    private String jdbcConnectionForDiscount = "postgresql://username:password@db.internal.com:5555/PriceDB?" ;
    private static Logger logger = Logger.getLogger(MergeOneRepository.class.getName());

    public double loadFromDB(Integer orderId, String year) {
        logger.log (Level.INFO, "Starting to read Discount from DB, conn: "+jdbcConnectionForDiscount);

        //Nonsensical logic below just simulates looking up of a value in DB. It is NOT "domain logic"
        double responseFromDB = Math.random() * orderId / Integer.parseInt(year);

        return responseFromDB;
    }
}
