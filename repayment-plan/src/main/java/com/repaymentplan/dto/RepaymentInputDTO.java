package com.repaymentplan.dto;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * RepaymentInputDTO - Input JSON
 */
@Component
public class RepaymentInputDTO {

    private double loanAmount;
    private double nominalRate;
    private int duration;
    private Date startDate;

    public double getLoanAmount() {
        return loanAmount;
    }

    public double getNominalRate() {
        return nominalRate;
    }

    public int getDuration() {
        return duration;
    }

    public Date getStartDate() {
        return startDate;
    }
}
