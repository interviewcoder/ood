package com.tripadvisor.bestdeal;

import java.util.Date;

public class DealRebate3Plus extends Deal {

    public DealRebate3Plus(int id, String hotel, double rate, String txt,
            int dealValue, DealType type, Date startDate, Date endDate) {
        super(id, hotel, rate, txt, dealValue, type, startDate, endDate);
    }

    /** 
     * To be applicable to this deal: 
     *  1) Stay nights at least 3;
     *  2) Check-in date is within deal's start date and end date.
     */
    @Override
    public boolean isApplicable(Reservation rsv) {
        return rsv != null && isDateWithin(rsv.getCheckin(), _startDate, _endDate) && rsv.getNights() >= 3;
    }

    /** A straight discount off the total price when the duration of stay is >= 3 */
    @Override
    public double getRealCost(Reservation rsv) {
        if (isApplicable(rsv)) {
            return _nightlyRate * rsv.getNights() + _dealValue;
        } else {
            return _nightlyRate * rsv.getNights();
        }
    }

}
