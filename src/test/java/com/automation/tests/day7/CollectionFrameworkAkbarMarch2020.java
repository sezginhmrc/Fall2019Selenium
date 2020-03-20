package com.automation.tests.day7;

import java.util.*;

public class CollectionFrameworkAkbarMarch2020 {

    public static void main(String[] args) {

        String price = "100.99";
        double priceNum = Double.parseDouble(price);
        //  System.out.println(priceNum);

        List<String> priceList = new ArrayList<>(Arrays.asList("99.99","149.99","79.50","299.99","599.00","149.99","99.99"));
        System.out.println(priceList);

        // but we want toget List <Double>

        List<Double> prices = new ArrayList<>();

        for (String eachPrice : priceList) {
            prices.add(Double.parseDouble(eachPrice));
        }
        System.out.println(prices);
        // how do iget max price min average

        double max = 0 ;
        for (int i = 0; i <prices.size() ; i++) {
            if(prices.get(i)>max){
                max = prices.get(i);
            }
        }


        System.out.println(max);
        //remove itsm above average

        //get the unique pricess

        // this is easiet way to remove duplicates
        Set<Double> pricesUnique = new HashSet<>(prices);
        System.out.println(pricesUnique);




    }
}
