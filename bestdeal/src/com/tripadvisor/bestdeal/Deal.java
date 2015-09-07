package com.tripadvisor.bestdeal;

import java.util.Date;

public abstract class Deal {

    public enum DealType {
        REBATE, REBATE_3PLUS, PCT
    }
    
    protected int _id;
    protected String _hotel;
    protected double _nightlyRate;
    protected String _promoTxt;
    protected int _dealValue;
    protected DealType _dealType;
    protected Date _startDate;
    protected Date _endDate;

    public Deal(int id, String hotel, double rate, String txt, int dealValue, DealType type, Date startDate, Date endDate) {
        _id = id;
        _hotel = hotel;
        _nightlyRate = rate;
        _promoTxt = txt;
        _dealValue = dealValue;
        _dealType = type;
        _startDate = startDate;
        _endDate = endDate;
    }
    
    /**
     * Returns deal id.
     * @return deal id
     */
    public int getId() {
        return _id;
    }
    
    /**
     * Returns promotion description.
     * @return promotion description
     */
    public String getPromoTxt() {
        return _promoTxt;
    }
    
    /**
     * Returns true if deal is applicable to this reservation.
     * 
     * @param rsv reservation
     * @return true if deal is applicable
     */
    public abstract boolean isApplicable(Reservation rsv);
    
    /**
     * Gets the actual cost after applying the deal to reservation.
     * 
     * @param rsv reservation
     * @return actual cost after deal is applied
     */
    public abstract double getRealCost(Reservation rsv);
    
    /**
     * Returns true if date is within start date and end time. (date can be
     * the same date as start date or end date)
     * @param date
     * @param start
     * @param end
     * @return
     */
    protected boolean isDateWithin(Date date, Date start, Date end) {
        return !date.before(start) && !date.after(end);
    }
    
    public static class Factory {
        /** Get deal instance based on deal's type */
        public static Deal getDealInstance(DealType type, int id, String hotel, double rate, String txt, int dealValue, Date startDate, Date endDate) {
            if (type == DealType.REBATE) {
                return new DealRebate(id, hotel, rate, txt, dealValue, type, startDate, endDate);
            } else if (type == DealType.REBATE_3PLUS) {
                return new DealRebate3Plus(id, hotel, rate, txt, dealValue, type, startDate, endDate);
            } else if (type == DealType.PCT) {
                return new DealPct(id, hotel, rate, txt, dealValue, type, startDate, endDate);
            }
            return null;
        }

    }
    
}
