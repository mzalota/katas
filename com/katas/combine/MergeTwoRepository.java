package com.katas.combine;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MergeTwoRepository {

    private String jdbcConnection = "postgresql://username:password@db.internal.com:5555/PriceDB?" ;
    private static Logger logger = Logger.getLogger(MergeTwoRepository.class.getName());

    public double loadFromDB(Integer packageId, String category) {

        logger.log (Level.INFO, "Starting to read PackagePrice from DB, conn: "+jdbcConnection);

        if (packageId == null) {
            packageId=1; //use default package
        }

        //Nonsensical logic below just simulates looking up of a value in DB. It is NOT "domain logic"
        double responseFromDB = Math.random() + packageId;

        return responseFromDB;
    }
}
