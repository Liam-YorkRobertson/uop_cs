/*
 * This program analyzes stock prices over 10 days using both an array and an ArrayList. 
 * It calculates the average, finds the maximum price, counts occurrences of a target price, 
 * and computes the cumulative sum of stock prices.
 */

import java.util.*;

public class StockManipulation {
    public static void main(String[] args) {
        // example array of daily stock prices for 10 days
        int[] dailyStockPrices = new int[] {23, 87, 45, 12, 67, 38, 94, 87, 50, 76};
        System.out.println("The content of the array of stock prices is: " + Arrays.toString(dailyStockPrices));
        // example ArrayList of daily stock prices for 10 days
        ArrayList<Float> dailyStockPricesList = new ArrayList<Float>();
        dailyStockPricesList.add(23.0f);
        dailyStockPricesList.add(87.0f);
        dailyStockPricesList.add(45.0f);
        dailyStockPricesList.add(12.0f);
        dailyStockPricesList.add(67.0f);
        dailyStockPricesList.add(38.0f);
        dailyStockPricesList.add(94.0f);
        dailyStockPricesList.add(87.0f);
        dailyStockPricesList.add(50.0f);
        dailyStockPricesList.add(76.0f);
        System.out.println("The content of the ArrayList of stock prices is: " + dailyStockPricesList);
        // example target price
        int targetPrice = 87;
        // calling methods
        calculateAveragePrice(dailyStockPrices, dailyStockPricesList);
        findMaximumPrice(dailyStockPrices, dailyStockPricesList);
        countOccurrences(dailyStockPrices, targetPrice);
        computeCumulativeSum(dailyStockPricesList);
    }

    public static void calculateAveragePrice(int[] sampArray, ArrayList<Float> sampArrayList) {
        /*
        * this method calculates the average for
        * both the array and ArrayList of stock prices
        */

        // calculates the average stock price for array
        int total = 0;
        float averagePrice;
        for(int i = 0; i < sampArray.length; i++) {
            total += sampArray[i];
        }
        averagePrice = (float) total / sampArray.length;
        System.out.println("\nThe average stock price for the array is " + averagePrice);
        
        // calculates the average stock price for ArrayList
        float totalList = 0;
        float averagePriceList;
        for(float price : sampArrayList) {
            totalList += price;
        }
        averagePriceList = totalList / sampArrayList.size();
        System.out.println("The average stock price for the ArrayList is " + averagePriceList);
    }

    public static void findMaximumPrice(int[] sampArray, ArrayList<Float> sampArrayList) {
        /*
        * this method determines the maximum for
        * both the array and ArrayList of stock prices
        */

        // maximum of array
        int max = 0;
        for(int i = 0; i < sampArray.length; i++) {
            if(sampArray[i] > max) {
                max = sampArray[i];
            }
        }
        System.out.println("\nThe maximum stock price in the array is: " + max);

        // maximum of ArrayList
        float maxList = Collections.max(sampArrayList);
        System.out.println("The maximum stock price in the ArrayList is: " + maxList);
        }

    public static void countOccurrences(int[] sampArray, int sampTarget) {
        /*
        * this method calculates how many times the target stock price
        * occurs in the array of stock prices
        */

        int count = 0;
        for(int i = 0; i < sampArray.length; i++) {
            if (sampArray[i] == sampTarget) {
                count++;
            }
        }
        System.out.println("\nThe company met the target price of " + sampTarget + ": " + count + " times");
    }

    public static void computeCumulativeSum(ArrayList<Float> sampArrayList) {
        /*
        * this method calculates the cumulative sum of the stock prices for the ArrayList
        * for each day and stores the cumulative value as an element in a new ArrayList
        */

        ArrayList<Float> cumulativeArrayList = new ArrayList<Float>();
        float cumulativePrice = 0;
        for(Float price : sampArrayList){
            cumulativePrice += price;
            cumulativeArrayList.add(cumulativePrice);
        }
        System.out.println("\nThe cumulative sum for each day is: " + cumulativeArrayList);
    }
}