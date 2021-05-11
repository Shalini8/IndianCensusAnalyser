package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class StateCensusAnalyserTest {
    public static final String STATECENSUS_CSVFILE = "C:\\Users\\hp\\IdeaProjects\\IndianCensusAnalyser\\src\\main\\resources\\IndiaStateCensusData.csv";
    public static final String STATECODES_CSVFILE = "C:\\Users\\hp\\IdeaProjects\\IndianCensusAnalyser\\src\\main\\resources\\IndiaStateCode.csv";
    public static final String WRONG_FILE = "/useless.txt";

    @Test
    public void GivenTheStateCodesCsvFile_IfHasCorrectNumberOfRecords_ShouldReturnTrue() throws IOException {
        try {
            int count = StateCensusAnalyser.openCsvBuilder(STATECENSUS_CSVFILE, StateCensus.class);
            System.out.println(count);
            Assertions.assertEquals(29, count);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void GivenTheStateCensusCsvFile_IfDoesntExist_ShouldThrowCensusAnalyserException() throws IOException {
        try {
            int count = StateCensusAnalyser.openCsvBuilder(WRONG_FILE, StateCensus.class);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
            Assertions.assertEquals(CensusAnalyserException.CensusExceptionType.NO_SUCH_FILE, e.type);
        }
    }
    @Test
    public void GivenTheStateCensusCsvFile_WhenCorrect_ButFileExtensionIncorrect_ShouldThrowCensusAnalyserException() throws IOException {
        try {
            int count = StateCensusAnalyser.openCsvBuilder(STATECODES_CSVFILE, StateCensus.class);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
            Assertions.assertEquals(CensusAnalyserException.CensusExceptionType.INCORRECT_DATA_ISSUE, e.type);
        }
    }
    @Test
    public void GivenTheStateCensusCSVFile_WhenCorrect_ButDelimiterIncorrect_ReturnsCensusAnalyserException() throws IOException {
        try {
            int count = StateCensusAnalyser.openCsvBuilder(STATECENSUS_CSVFILE, StateCensus.class);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
            Assertions.assertEquals(CensusAnalyserException.CensusExceptionType.DELIMITER_ISSUE, e.type);

        }
    }
    @Test
    public void whenCorrectCensusCSVFile_ButHeaderIncorrect_ShouldReturnFalse() throws IOException {
        try {
            int count = StateCensusAnalyser.openCsvBuilder(STATECENSUS_CSVFILE, StateCensus.class);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
            Assertions.assertEquals(CensusAnalyserException.CensusExceptionType.INCORRECT_DATA_ISSUE, e.type);
        }
    }
}


