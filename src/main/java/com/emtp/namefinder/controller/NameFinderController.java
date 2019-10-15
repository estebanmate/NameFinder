package com.emtp.namefinder.controller;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.emtp.namefinder.dto.Extraction;
import com.emtp.namefinder.dto.Replacement;
import com.emtp.namefinder.service.NameFinder;
import java.util.List;


@RestController
public class NameFinderController {

    @Autowired
    private NameFinder nameFinder;

    @RequestMapping(value = "/names", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "names", nickname = "names")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Extraction.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    public Extraction extractNames(@ApiParam(value = "Extraction request", required = true) @RequestBody Extraction extraction) {
        List<String> extractedNames = nameFinder.getNames(extraction.getSentence());
        extraction.setExtractedNames(extractedNames);
        return extraction;

    }

    @RequestMapping(value = "/names/replaced", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "names replacement", nickname = "names replacement")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Replacement.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    public Replacement replaceNames(@ApiParam(value = "Replacement request", required = true) @RequestBody Replacement replacement) {
        String outputSentence = nameFinder.replaceNamesWith(replacement.getInputSentence(), replacement.getReplacement());
        replacement.setOutputSentence(outputSentence);
        return replacement;

    }
}
