package com.tripadvisor.bestdeal;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BestHotelDealTest {
    
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void testExample1() {
        String[] args = {"testdata/input1.csv", "Hotel Commonwealth", "2015-06-30", "3"};
        BestHotelDeal.main(args);
        assertEquals("$50 off your stay 3 nights or more\n", outContent.toString());
    }

    @Test
    public void testExample2() {
        String[] args = {"testdata/input1.csv", "Hotel Commonwealth", "2015-06-30", "1"};
        BestHotelDeal.main(args);
        assertEquals("5% off your stay\n", outContent.toString());
    }

    @Test
    public void testExample3() {
        String[] args = {"testdata/input1.csv", "Hotel Commonwealth", "2015-06-30", "2"};
        BestHotelDeal.main(args);
        assertEquals("5% off your stay\n", outContent.toString());
    }
    
    @Test
    public void testNoDealApplicable() {
        String[] args = {"testdata/input2.csv", "NOT EXIST HOTEL", "2015-06-30", "2"};
        BestHotelDeal.main(args);
        assertEquals("no deal available\n", outContent.toString());
    }

    @Test
    public void testApplicableRebateDeal() {
        String[] args = {"testdata/input2.csv", "WESTIN", "2015-07-25", "2"};
        BestHotelDeal.main(args);
        assertEquals("$100 off your stay\n", outContent.toString());
    }

    @Test
    public void testApplicableRebate3PlusDeal() {
        String[] args = {"testdata/input2.csv", "HILTON", "2015-06-25", "3"};
        BestHotelDeal.main(args);
        assertEquals("$150 off your stay 3 nights or more\n", outContent.toString());
    }
    
    @Test
    public void testApplicablePCTDeal() {
        String[] args = {"testdata/input2.csv", "PENNINSULAR", "2015-06-25", "5"};
        BestHotelDeal.main(args);
        assertEquals("10% off your stay\n", outContent.toString());
    }

}
