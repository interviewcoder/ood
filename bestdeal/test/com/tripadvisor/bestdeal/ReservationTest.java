package com.tripadvisor.bestdeal;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class ReservationTest {
    
    public static final SimpleDateFormat SDF = BestHotelDeal.SDF;

    @Test
    public void testCheckout() {
        Reservation rsv = new Reservation("WESTIN", toDate("2015-04-02") , 3);
        Date actual = rsv.getCheckout();
        Date expected = toDate("2015-04-05");
        assertEquals(expected, actual);
    }

    @Test
    public void testCheckout_nextMonth() {
        Reservation rsv = new Reservation("WESTIN", toDate("2015-06-29") , 4);
        Date actual = rsv.getCheckout();
        Date expected = toDate("2015-07-03");
        assertEquals(expected, actual);
    }

    @Test
    public void testCheckout_afterResetCheckinDate() {
        Reservation rsv = new Reservation("WESTIN", toDate("2015-04-02") , 3);
        rsv.setCheckin(toDate("2015-04-04"));
        Date actual = rsv.getCheckout();
        Date expected = toDate("2015-04-07");
        assertEquals(expected, actual);
    }

    private Date toDate(String source) {
        try {
            return SDF.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
