package com.tripadvisor.bestdeal;

import static org.junit.Assert.*;

import org.junit.Test;

import com.tripadvisor.bestdeal.Deal.DealType;

public class DealRebateTest extends DealTest {

    private Reservation rsv;

    // 250 * 3 - 5 - 745;
    @Test
    public void testApplicableReservation() {
        rsv = new Reservation(HOTEL, toDate("2015-06-21"), 3);
        Deal deal = getDealByHotel(HOTEL, DealType.REBATE, toDate("2015-06-21"), toDate("2015-06-30"));
        assertTrue(deal.isApplicable(rsv));
        double actual = deal.getRealCost(rsv);
        double expected = 745;
        assertEquals(expected, actual, DELTA);
    }

    // 250 * 3 - 5 - 745;
    @Test
    public void testApplicableReservation_checkinAfterDealStartDate() {
        rsv = new Reservation(HOTEL, toDate("2015-06-22"), 3);
        Deal deal = getDealByHotel(HOTEL, DealType.REBATE, toDate("2015-06-21"), toDate("2015-06-30"));
        assertTrue(deal.isApplicable(rsv));
        double actual = deal.getRealCost(rsv);
        double expected = 745;
        assertEquals(expected, actual, DELTA);
    }

    // 250 * 3 = 750;
    @Test
    public void testNotApplicableReservation_checkoutBeforeDealStartDate() {
        rsv = new Reservation(HOTEL, toDate("2015-06-18"), 3);
        Deal deal = getDealByHotel(HOTEL, DealType.REBATE, toDate("2015-06-21"), toDate("2015-06-30"));
        assertTrue(!deal.isApplicable(rsv));
        double actual = deal.getRealCost(rsv);
        double expected = 750;
        assertEquals(expected, actual, DELTA);
    }

    // 250 * 4 = 1000;
    @Test
    public void testNotApplicableReservation_checkinAfterDealEndDate() {
        rsv = new Reservation(HOTEL, toDate("2015-07-02"), 4);
        Deal deal = getDealByHotel(HOTEL, DealType.REBATE, toDate("2015-06-21"), toDate("2015-06-30"));
        assertTrue(!deal.isApplicable(rsv));
        double actual = deal.getRealCost(rsv);
        double expected = 1000;
        assertEquals(expected, actual, DELTA);
    }

}
