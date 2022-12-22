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

//    @Test
//    public void knowsLargest() throws Exception {
//        assertThat(queryProcessor.process("Which of the following numbers is the largest: 23, 35, 40?"), containsString("40"));
//    }

}
