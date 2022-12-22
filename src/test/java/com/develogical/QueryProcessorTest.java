package com.develogical;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class QueryProcessorTest {

    QueryProcessor queryProcessor = new QueryProcessor();

    @Test
    public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
        assertThat(queryProcessor.process("test"), is(""));
    }

    @Test
    public void knowsAboutShakespeare() throws Exception {
        assertThat(queryProcessor.process("Shakespeare"), containsString("playwright"));
    }

    @Test
    public void knowsOurName() throws Exception {
        assertThat(queryProcessor.process("What is your name?"), containsString("AppleMac"));
    }

    @Test
    public void knowsHowToAdd() throws Exception {
        assertThat(queryProcessor.process("What is 3 plus 7"), containsString("10"));
    }

    @Test
    public void knowsHowToAdd2() throws Exception {
        assertThat(queryProcessor.process("What is 79 plus 13?"), containsString("92"));
    }

    @Test
    public void knowsLargest() throws Exception {
        assertThat(queryProcessor.process("Which of the following numbers is the largest: 23, 35, 40?"), containsString("40"));
    }

    @Test
    public void knowsHowToMultiply() throws Exception {
        assertThat(queryProcessor.process("What is 73 multiplied by 56?"), containsString("4088"));
    }

    @Test
    public void knowsHowToFindSquareAndCube() throws Exception {
        assertThat(queryProcessor.process("Which of the following numbers is both a square and a cube: 1000, 2209, 2972, 3063, 4808, 1004, 729?"), containsString("729"));
    }

    @Test
    public void knowsHowToMinus() throws Exception {
        assertThat(queryProcessor.process("What is 14 minus 2?"), containsString("12"));
    }

}
