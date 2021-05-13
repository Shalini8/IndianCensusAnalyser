package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CSVStateCensusAnalyserTest {
    public static final String STATECENSUS_CSVFILE = "C:\\Users\\hp\\IdeaProjects\\IndianCensusAnalyser\\src\\main\\resources\\IndiaStateCensusData.csv";
    public static final String STATECODES_CSVFILE = "C:\\Users\\hp\\IdeaProjects\\IndianCensusAnalyser\\src\\main\\resources\\IndiaStateCode.csv";
    public static final String WRONG_FILE = "/useless.txt";
    public static final String STATECENSUSDC_CSVFILE = "C:\\Users\\hp\\IdeaProjects\\IndianCensusAnalyser\\src\\main\\resources\\IndiaStateCensusDataDC.csv";
    public static final String STATECENSUSHC_CSVFILE = "C:\\Users\\hp\\IdeaProjects\\IndianCensusAnalyser\\src\\main\\resources\\IndiaStateCensusDataHC.csv";
    public static final String STATECODESDC_CSVFILE = "C:\\Users\\hp\\IdeaProjects\\IndianCensusAnalyser\\src\\main\\resources\\IndiaStateCodeDC.csv";
    public static final String STATECODESHC_CSVFILE = "C:\\Users\\hp\\IdeaProjects\\IndianCensusAnalyser\\src\\main\\resources\\IndiaStateCodeHC.csv";

    @Test
    public void givenTheStateCensusCsvFile_IfHasCorrectNumberOfRecords_ShouldReturnTrue() throws IOException {
        try {
            int count = StateCensusAnalyser.openCsvBuilder(STATECENSUS_CSVFILE, CSVStateCensus.class);
            System.out.println(count);
            Assertions.assertEquals(29, count);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenTheStateCensusCsvFile_IfDoesntExist_ShouldThrowCensusAnalyserException() throws IOException {
        try {
           StateCensusAnalyser.openCsvBuilder(WRONG_FILE, CSVStateCensus.class);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
            Assertions.assertEquals(CensusAnalyserException.CensusExceptionType.NO_SUCH_FILE, e.type);
        }
    }
    @Test
    public void givenTheStateCensusCsvFile_WhenCorrect_ButFileExtensionIncorrect_ShouldThrowCensusAnalyserException() throws IOException {
        try {
             StateCensusAnalyser.openCsvBuilder(STATECENSUS_CSVFILE, CSVStateCensus.class);
        } catch (CensusAnalyserException e) {
            System.out.println("extensionwrong");
            e.printStackTrace();
            Assertions.assertEquals(CensusAnalyserException.CensusExceptionType.INCORRECT_DATA_ISSUE, e.type);
        }
    }
    @Test
    public void givenTheStateCensusCSVFile_WhenCorrect_ButDelimiterIncorrect_ReturnsCensusAnalyserException() throws IOException {
        try {
             StateCensusAnalyser.openCsvBuilder(STATECENSUSDC_CSVFILE, CSVStateCensus.class);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
            Assertions.assertEquals(CensusAnalyserException.CensusExceptionType.DELIMITER_ISSUE, e.type);

        }
    }
    @Test
    public void whenCorrectCensusCSVFile_ButHeaderIncorrect_ShouldReturnFalse() throws IOException {
        try {
            StateCensusAnalyser.openCsvBuilder(STATECENSUSHC_CSVFILE, CSVStateCensus.class);
        } catch (CensusAnalyserException e) {
            System.out.println("headerwrong");
            e.printStackTrace();
            Assertions.assertEquals(CensusAnalyserException.CensusExceptionType.INCORRECT_DATA_ISSUE, e.type);
        }
    }

    @Test
    public void givenTheStateCodesCsvFile_IfHasCorrectNumberOfRecords_ShouldReturnTrue() throws IOException {
        try {
            int count = StateCensusAnalyser.openCsvBuilder(STATECODES_CSVFILE, CSVStates.class);
            System.out.println(count);
            Assertions.assertEquals(37, count);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenTheStateCodeCsvFile_IfDoesntExist_ShouldThrowCensusAnalyserException() throws IOException {
        try {
            StateCensusAnalyser.openCsvBuilder(WRONG_FILE, CSVStates.class);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
            Assertions.assertEquals(CensusAnalyserException.CensusExceptionType.NO_SUCH_FILE, e.type);
        }
    }
    @Test
    public void givenTheStateCodeCsvFile_WhenCorrect_ButFileExtensionIncorrect_ShouldThrowCensusAnalyserException() throws IOException {
        try {
            int count = StateCensusAnalyser.openCsvBuilder(STATECODES_CSVFILE, CSVStates.class);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
            Assertions.assertEquals(CensusAnalyserException.CensusExceptionType.INCORRECT_DATA_ISSUE, e.type);
        }
    }
    @Test
    public void givenTheStateCodeCSVFile_WhenCorrect_ButDelimiterIncorrect_ReturnsCensusAnalyserException() throws IOException {
        try {
           StateCensusAnalyser.openCsvBuilder(STATECODESDC_CSVFILE, CSVStates.class);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
            Assertions.assertEquals(CensusAnalyserException.CensusExceptionType.DELIMITER_ISSUE, e.type);

        }
    }
    @Test
    public void whenCorrectStateCodeCSVFile_ButHeaderIncorrect_ShouldReturnFalse() throws IOException {
        try {
            StateCensusAnalyser.openCsvBuilder(STATECODESHC_CSVFILE, CSVStates.class);
        } catch (CensusAnalyserException e) {
            System.out.println("header wrong");
            e.printStackTrace();
            Assertions.assertEquals(CensusAnalyserException.CensusExceptionType.INCORRECT_DATA_ISSUE, e.type);
        }
    }
}


