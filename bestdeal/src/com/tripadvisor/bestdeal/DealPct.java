package com.tripadvisor.bestdeal;

import java.util.Date;

public class DealPct extends Deal {

    public DealPct(int id, String hotel, double rate, String txt,
            int dealValue, DealType type, Date startDate, Date endDate) {
        super(id, hotel, rate, txt, dealValue, type, startDate, endDate);
    }

    /**
     * Nights that are within deal's start date and end date are valid for deal.
     */
    @Override
    public boolean isApplicable(Reservation rsv) {
        return rsv != null
                && !(!rsv.getCheckout().after(_startDate) || rsv.getCheckin()
                        .after(_endDate));
    }

    /**
     * A percentage discount off the total price of the stay. Nights that are
     * after end date of deal cannot be applied the percentage.
     */
    @Override
    public double getRealCost(Reservation rsv) {
        if (isApplicable(rsv)) {
            Date validStart = getLaterDate(rsv.getCheckin(), _startDate);
            Date validEnd = getEarlierDate(rsv.getLastDate(), _endDate);
            int validNights = daysBetween(validStart, validEnd) + 1;
            return 0.01 * (100 + _dealValue) * _nightlyRate * validNights
                    + _nightlyRate * (rsv.getNights() - validNights);
        } else {
            return _nightlyRate * rsv.getNights();
        }
    }

    private Date getLaterDate(Date date1, Date date2) {
        return date1.after(date2) ? date1 : date2;
    }

    private Date getEarlierDate(Date date1, Date date2) {
        return date1.before(date2) ? date1 : date2;
    }

    private int daysBetween(Date d1, Date d2) {
        return (int) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
    }

}
