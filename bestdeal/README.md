### BestHotelDeal Assignment

0. source tree:
   ```
   bestdeal
      | --- src/com/tripadvisor/bestdeal/*.java   # source files
      | --- test/com/tripadvisor/bestdeal/*.java  # test files
      | --- testdata/*.csv                        # input data 
   ```

1. Compile: (cd to parent directory of src)
    ```bash
    $ cd bestdeal
    $ javac src/com/tripadvisor/bestdeal/*.java
    ```

2. Run: 
    ```bash
    java -cp src com.tripadvisor.bestdeal.BestHotelDeal \
    testdata/input1.csv "Hotel Commonwealth" 2015-06-21 3
    ```

3. P.S.:
    1.  For `pct` deal, I try to apply this deal wherever is possible. 
        ```bash
        HILTON,250,5% off your stay,-5,pct,2016-06-29,2016-06-30
        % BestHotelDeal ./input3.csv HILTON 2016-06-30 2
        > 5% off your stay
        ```
        In this example, even though checkout date is after deal's end date, this reservation can still enjoy the discount for the night 2016-06-30
        
    2.  For `rebate` and `rebate_3plus` deals, I will apply this deal as long as the `checkin`date is within `start date` and `end date` of the deal
    