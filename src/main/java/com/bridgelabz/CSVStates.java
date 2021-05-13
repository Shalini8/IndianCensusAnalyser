package com.bridgelabz;

import com.opencsv.bean.CsvBindByName;

public class CSVStates {
    @CsvBindByName(column = "SrNo",required = true)
    private String sr_No;

    @CsvBindByName(column = "StateName")
    private String stateName;

    @CsvBindByName(column = "TIN")
    private String tin;

    @CsvBindByName(column = "StateCode")
    private String stateCode;

    @Override
    public String toString() {
        return "CSVStates{" +
                "sr_No='" + sr_No + '\'' +
                ", stateName='" + stateName + '\'' +
                ", tin='" + tin + '\'' +
                ", stateCode='" + stateCode + '\'' +
                '}';
    }
}
