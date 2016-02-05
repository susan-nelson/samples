package com.susannelson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by Susan on 11/13/2015.
 */
public class LambaSamples {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Ben", "Brad", "Bill", "Kara", "Sara", "Jil", "Brenda");

        //Create a collection of people whose name start with B or K and have 3 or 4 letters

        List<String> result = new ArrayList<String>();
        for(String name : names) {
            if((name.startsWith("B") || name.startsWith("K")) && (name.length() == 3 || name.length() == 4))
                result.add(name);
        }

        System.out.println(result);

        System.out.println(
                names.stream()
                        .filter(name -> name.startsWith("B") || name.startsWith("K"))
                        .filter(name -> name.length() == 3 || name.length() == 4)
                        .collect(Collectors.toList()));

        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6);

        System.out.println(totalValues(values, value -> true));
        System.out.println(totalValues(values, value -> value % 2 == 0));
        System.out.println(totalValues(values, value -> value % 2 != 0));
    }

    public static int totalValues(List<Integer> numbers, Predicate<Integer> selector) {
        return numbers.stream()
                .filter(selector)
                .mapToInt(value -> value)
                .sum();
    }

    class CalculateNAV {
        private Function<String, Double> _priceFinder;

        public CalculateNAV(Function<String, Double> priceFinder) {
            _priceFinder = priceFinder;
        }

        public double compute(String ticker, int stocks) {
            return stocks * _priceFinder.apply(ticker);
        }
    }

    class StockFetcher {
        public double getStockPrice(String ticker) {
            System.out.println("Do real work and get the stock price...");
            return 35.55;
        }
    }
}
