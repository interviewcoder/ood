package com.tripadvisor.bestdeal;

import java.util.Date;

public class DealRebate extends Deal {

    public DealRebate(int id, String hotel, double rate, String txt,
            int dealValue, DealType type, Date startDate, Date endDate) {
        super(id, hotel, rate, txt, dealValue, type, startDate, endDate);
    }

    /** As long as checkin date is between deal' start date and deal's end date */
    @Override
    public boolean isApplicable(Reservation rsv) {
        return rsv != null && isDateWithin(rsv.getCheckin(), _startDate, _endDate);
    }

    /** A straight discount off the total price of the stay */
    @Override
    public double getRealCost(Reservation rsv) {
        if (isApplicable(rsv)) {
            return _nightlyRate * rsv.getNights() + _dealValue;
        } else {
            return _nightlyRate * rsv.getNights();
        }
    }

}
