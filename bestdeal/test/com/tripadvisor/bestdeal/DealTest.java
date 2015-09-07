package com.tripadvisor.bestdeal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.tripadvisor.bestdeal.Deal.DealType;

public class DealTest {
    
    public static final SimpleDateFormat SDF = BestHotelDeal.SDF;

    public static final String HOTEL = "Good Hotel";
    
    // nightly rate for hotel
    public static final double RATE = 250;

    // delta value for comparing two double variables
    public static final double DELTA = 1e-6;

    public Date toDate(String source) {
        try {
            return SDF.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    protected Deal getDealByHotel(String hotel, DealType type, Date startDate, Date endDate) {
        Deal deal = Deal.Factory.getDealInstance(type, 1, hotel, RATE, "good deal", -5, startDate, endDate);
        return deal;
    }

}
