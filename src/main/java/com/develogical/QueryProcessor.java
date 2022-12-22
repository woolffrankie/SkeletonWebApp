package com.develogical;

import java.util.Arrays;
import java.util.function.BinaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.valueOf;

public class QueryProcessor {

    public String process(String query) {

        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        }

        if (query.toLowerCase().contains("your name")) {
            return "AppleMac";
        }

        if (query.toLowerCase().contains("plus")) {
            return Integer.toString(add(query));
        }


        return "";
    }

    private int add(String query){
        String[] queryArray = query.split(" ");
        int length = queryArray.length;
//        int position = queryArray.findIndex("plus");
        return valueOf(queryArray[length-1]) + valueOf(queryArray[length-3]);
    }
    
}
