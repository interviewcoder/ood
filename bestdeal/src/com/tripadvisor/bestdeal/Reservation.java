package com.tripadvisor.bestdeal;

import java.util.Calendar;
import java.util.Date;

public class Reservation {
    
    private String hotel;
    private Date checkin;
    private int nights;    // nights staying in this hotel
    private Date lastDate; // the date before checkout date
    private Date checkout;
    
    /** Creates a new reservation */
    public Reservation(String hotel, Date checkin, int nights) {
        this.hotel = hotel;
        this.checkin = checkin;
        this.nights = nights;
        setCheckout();
    }

    // set checkout date based on check-in date and staying nights
    private void setCheckout() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(checkin);
        cal.add(Calendar.DATE, nights - 1);
        lastDate = cal.getTime();
        cal.add(Calendar.DATE, 1);
        checkout = cal.getTime();
    }
    
    /**
     * Gets the check in date.
     * 
     * @return check in date
     */
    public Date getCheckin() {
        return checkin;
    }

    /**
     * Gets the checkout date.
     * 
     * @return checkout date
     */
    public Date getCheckout() {
        return checkout;
    }

    /**
     * Gets the hotel name.
     * 
     * @return hotel name
     */
    public String getHotel() {
        return hotel;
    }
    
    /**
     * Gets staying nights.
     * 
     * @return staying nights
     */
    public int getNights() {
        return nights;
    }
    
    @Override
    public String toString() {
        return hotel + ", " + checkin + "," + checkout + "," + nights;
    }

    public void setCheckin(Date date) {
        checkin = date;
        setCheckout();
    }

    public Date getLastDate() {
        return lastDate;
    }

}
