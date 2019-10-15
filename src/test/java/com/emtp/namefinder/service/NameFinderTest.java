package com.emtp.namefinder.service;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.emtp.namefinder.service.NameFinder;
import com.emtp.namefinder.service.NameFinderImpl;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class NameFinderTest {

    public static final Logger log = LoggerFactory.getLogger(NameFinderTest.class);

    @Test
    public void getNames() throws Exception {

        String sentence = "With members John Lennon, Paul McCartney, George Harrison and Ringo Starr, they became widely regarded as the foremost and most influential act of the rock era.";

        String[] expected = {"John Lennon", "Paul McCartney", "George Harrison", "Ringo Starr"};

        NameFinder nameFinder = new NameFinderImpl();

        List<String> actual = nameFinder.getNames(sentence);

        assertThat(actual, is(Arrays.asList(expected)));
    }

    @Test
    public void replaceNamesWith() throws Exception {

        String sentence = "With members John Lennon, Paul McCartney, George Harrison and Ringo Starr, they became widely regarded as the foremost and most influential act of the rock era.";
        String expected = "With members **** , **** , **** and **** , they became widely regarded as the foremost and most influential act of the rock era.";

        NameFinder nameFinder = new NameFinderImpl();

        String actual = nameFinder.replaceNamesWith(sentence, "****");

        assertThat(actual, is(expected));

    }

}