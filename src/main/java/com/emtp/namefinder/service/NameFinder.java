package com.emtp.namefinder.service;

import java.util.List;

public interface NameFinder {

    List<String> getNames(String sentence);

    String replaceNamesWith(String sentence, String placeholder);
}
