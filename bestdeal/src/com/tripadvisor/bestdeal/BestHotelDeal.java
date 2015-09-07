/**
 * File: BestHotelDeal.java
 *************************************************************************
 * Assuming at the parent directory of 'src', then: 
 * 
 * Compilation: 
 * % javac src/com/tripadvisor/bestdeal/*.java
 * 
 * Run: (if input1.csv is in testdata directory)
 * % java -cp src com/tripadvisor/bestdeal/BestHotelDeal testdata/input1.csv "Hotel Commonwealth" 2015-06-30 2
 * 
 *************************************************************************
 */
package com.tripadvisor.bestdeal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.tripadvisor.bestdeal.Deal.DealType;

public class BestHotelDeal {

    private static String PATH = "";

    private static String HOTEL = "";

    private static Date CHECKIN = null;

    private static int NIGHTS = -1;

    private Reservation rsv;

    private List<Deal> deals = new ArrayList<>();

    public static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) {
        try {
            new BestHotelDeal().run(args);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private void run(String[] args) throws IOException {
        parseCommandLine(args);
        readInputFile(PATH);
        findBestDeal();
    }

    // parse command input with 4 arguments
    private void parseCommandLine(String[] args) {
        Check(args.length == 4,
                "Valid usage: BestHotelDeal [path] [hotel] [checkin] [nights]");
        PATH = args[0];
        HOTEL = args[1];
        try {
            CHECKIN = parseDate(args[2]);
            NIGHTS = Integer.parseInt(args[3]);
        } catch (Exception e) {
            Check(false, "invalid input: " + args);
        }
        rsv = new Reservation(HOTEL, CHECKIN, NIGHTS);
    }

    private void readInputFile(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line = null;
        int index = 0;
        while ((line = br.readLine()) != null) {
            // first line is heading line
            if (index == 0) {
                index++;
                continue;
            }
            line = line.trim();
            String[] vals = line.split(",", 7);
            if (vals.length < 7) {
                System.err.println("invalid line ignored: " + line);
            } else if (addReservation(vals, index)) {
                index++;
            }
        }
        br.close();
    }

    private boolean addReservation(String[] vals, int id) {
        if (!vals[0].equals(HOTEL)) {
            return false;
        }
        String hotel = vals[0];
        String txt = vals[2];
        double rate;
        int dealValue;
        DealType type;
        Date startDate;
        Date endDate;
        try {
            rate = Double.parseDouble(vals[1]);
            dealValue = Integer.parseInt(vals[3]);
            type = DealType.valueOf(vals[4].toUpperCase());
            startDate = SDF.parse(vals[5]);
            endDate = SDF.parse(vals[6]);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
        if (startDate.after(endDate)) {
            return false;
        }
        deals.add(Deal.Factory.getDealInstance(type, id, hotel, rate, txt,
                dealValue, startDate, endDate));
        return true;
    }

    private void findBestDeal() {
        double best = Double.MAX_VALUE;
        Deal bestdeal = null;
        for (Deal deal : deals) {
            if (deal.isApplicable(rsv)) {
                double cost = deal.getRealCost(rsv);
                if (cost < best) {
                    best = cost;
                    bestdeal = deal;
                }
            }
        }
        if (bestdeal != null) {
            System.out.println(bestdeal.getPromoTxt());
        } else {
            System.out.println("no deal available");
        }
    }

    private static Date parseDate(String str) throws ParseException {
        return SDF.parse(str);
    }

    private static void Check(boolean condition, String msg) {
        if (!condition) {
            System.err.println(msg);
            System.exit(-1);
        }
    }

}
