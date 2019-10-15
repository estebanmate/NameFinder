package com.emtp.namefinder.dto;

import io.swagger.annotations.ApiModel;

import java.util.List;

@ApiModel(value="Extraction", description="Extraction request and response object")
public class Extraction {

    private String sentence;
    private List<String> extractedNames;

    public Extraction(){
        //JSON PURPOSE
    }

    public Extraction(String sentence, List<String> extractedNames) {
        this.sentence = sentence;
        this.extractedNames = extractedNames;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public List<String> getExtractedNames() {
        return extractedNames;
    }

    public void setExtractedNames(List<String> extractedNames) {
        this.extractedNames = extractedNames;
    }
}
