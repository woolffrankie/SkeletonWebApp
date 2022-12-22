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

        if (query.toLowerCase().contains("largest")) {
            return Integer.toString(largest(query));
        }

        if (query.toLowerCase().contains("multiplied")) {
            return Integer.toString(multiply(query));
        }

        if (query.toLowerCase().contains("both a square and a cube")) {
            return Integer.toString(squareAndCube(query));
        }

        return "";
    }

    private int add(String query){
        String[] queryArray = query.split(" ");
        int length = queryArray.length;
        String[] firstNum = queryArray[length-1].split("\\?");
        return valueOf(firstNum[0]) + valueOf(queryArray[length-3]);
    }

    private int largest(String query) {
        String[] queryArray1 = query.split(" ");
        int length = queryArray1.length;
        int firstNum = Integer.valueOf(queryArray1[8].split(",")[0]);
        int secondNum = Integer.valueOf(queryArray1[9].split(",")[0]);
        int thirdNum = Integer.valueOf(queryArray1[10].split("\\?")[0]);

        if (firstNum > secondNum && firstNum > thirdNum) {
            return firstNum;
        } else if (secondNum > thirdNum) {
            return secondNum;
        } else {
            return thirdNum;
        }
    }

    private int multiply(String query){
        String[] queryArray = query.split(" ");
        String firstNum = queryArray[2];
        String[] secondNum = queryArray[5].split("\\?");
        return valueOf(firstNum) * valueOf(secondNum[0]);
    }

    private int squareAndCube(String query){
        String[] queryArray = query.split(" ");

        //12-17
        for(int i = 12; i < 18; i++){
            int cleanNumber = Integer.valueOf(queryArray[i].split(",")[0]);
            if (isItSquare(cleanNumber) && isItCube(cleanNumber)){
                return cleanNumber;
            }
        }

        //18
        int cleanNumber = Integer.valueOf(queryArray[18].split("\\?")[0]);
        if (isItSquare(cleanNumber) && isItCube(cleanNumber)){
            return cleanNumber;
        }

        return 0;
    }

    private Boolean isItSquare(int num){
        double number = Math.sqrt(num);

        if ( number == (int)number){
            return true;
        } else {
            return false;
        }
    }

    private Boolean isItCube(int num){
        double number = Math.cbrt(num);

        if ( number == (int)number){
            return true;
        } else {
            return false;
        }
    }
}
