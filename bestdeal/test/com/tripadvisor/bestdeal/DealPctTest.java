package com.tripadvisor.bestdeal;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.tripadvisor.bestdeal.Deal.DealType;

public class DealPctTest extends DealTest {

    private Reservation rsv;
    
    @Before
    public void setUp() throws Exception {
        // stays at HOTEL for 3 nights since check-in date
        Date checkin = toDate("2015-06-21");
        rsv = new Reservation(HOTEL, checkin, 3);
    }

    @After
    public void tearDown() throws Exception {
        rsv = null;
    }

    // 3 nights of percentage discount
    @Test
    public void testValidStay_withinDealValidDate() {
        Deal deal = getDealByHotel(HOTEL, DealType.PCT, toDate("2015-06-18"), toDate("2015-06-30"));
        assertTrue(deal.isApplicable(rsv));
        double actual = deal.getRealCost(rsv);
        double expected = 712.5;
        assertEquals(expected, actual, DELTA);
    }

    // 3 nights with only first date is qualified for percentage discount
    @Test
    public void testValidStay_CheckinAtDealEndDate() {
        rsv.setCheckin(toDate("2015-06-30"));
        Deal deal = getDealByHotel(HOTEL, DealType.PCT, toDate("2015-06-18"), toDate("2015-06-30"));
        assertTrue(deal.isApplicable(rsv));
        double actual = deal.getRealCost(rsv);
        double expected = 737.5;
        assertEquals(expected, actual, DELTA);
    }

    // 3 nights right match the deal valid dates
    @Test
    public void testValidStay_rightMatchDealValidDates() {
        rsv = new Reservation(HOTEL, toDate("2015-06-18"), 3);
        Deal deal = getDealByHotel(HOTEL, DealType.PCT, toDate("2015-06-18"), toDate("2015-06-20"));
        assertTrue(deal.isApplicable(rsv));
        double actual = deal.getRealCost(rsv);
        double expected = 712.5;
        assertEquals(expected, actual, DELTA);
    }

    // only 3 nights can enjoy the percentage, 1 more night left
    @Test
    public void testValidStay_coverTheWholeDealDates() {
        rsv = new Reservation(HOTEL, toDate("2015-06-17"), 4);
        Deal deal = getDealByHotel(HOTEL, DealType.PCT, toDate("2015-06-18"), toDate("2015-06-20"));
        assertTrue(deal.isApplicable(rsv));
        double actual = deal.getRealCost(rsv);
        double expected = 962.5;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void testValidStay_coverTheWholeDealDates2() {
        rsv = new Reservation(HOTEL, toDate("2015-06-17"), 5);
        Deal deal = getDealByHotel(HOTEL, DealType.PCT , toDate("2015-06-18"), toDate("2015-06-20"));
        assertTrue(deal.isApplicable(rsv));
        double actual = deal.getRealCost(rsv);
        double expected = 1212.5;
        assertEquals(expected, actual, DELTA);
    }

    // 3 nights with only last two days are qualified for percentage discount
    @Test
    public void testValidStay_CheckoutAfterDealStartDate() {
        rsv.setCheckin(toDate("2015-06-17"));  // checkout at 2015-06-19
        Deal deal = getDealByHotel(HOTEL, DealType.PCT, toDate("2015-06-18"), toDate("2015-06-30"));
        assertTrue(deal.isApplicable(rsv));
        double actual = deal.getRealCost(rsv);
        double expected = 725;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void testInValidStay_checkinAfterDealEndDate() {
        rsv.setCheckin(toDate("2015-06-30"));
        Deal deal = getDealByHotel(HOTEL, DealType.PCT, toDate("2015-06-18"), toDate("2015-06-29"));
        assertTrue(!deal.isApplicable(rsv));
    }

    @Test
    public void testInValidStay_checkinBeforeDealStarts() {
        rsv.setCheckin(toDate("2015-05-13")); // will checkout at 2015-06-16
        Deal deal = getDealByHotel(HOTEL, DealType.PCT, toDate("2015-06-18"), toDate("2015-06-30"));
        assertTrue(!deal.isApplicable(rsv));
    }

    @Test
    public void testInValidStay_checkoutBeforeDealStartDate() {
        rsv.setCheckin(toDate("2015-06-13")); // will checkout at 2015-06-16
        Deal deal = getDealByHotel(HOTEL, DealType.PCT, toDate("2015-06-18"), toDate("2015-06-30"));
        assertTrue(!deal.isApplicable(rsv));
    }

    @Test
    public void testInValidStay_checkoutAtDealStartDate() {
        rsv.setCheckin(toDate("2015-06-15")); // will checkout at 2015-06-18
        Deal deal = getDealByHotel(HOTEL, DealType.PCT, toDate("2015-06-18"), toDate("2015-06-30"));
        assertTrue(!deal.isApplicable(rsv));
    }
    

}
