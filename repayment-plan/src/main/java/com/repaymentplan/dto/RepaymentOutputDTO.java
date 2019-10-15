package com.repaymentplan.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * RepaymentOutputDTO - output JSON
 */
@Component
public class RepaymentOutputDTO {

    @JsonProperty
    private double borrowerPaymentAmount;
    @JsonProperty
    private Date date;
    @JsonProperty
    private double initialOutstandingPrincipal;
    @JsonProperty
    private double interest;
    @JsonProperty
    private double principal;
    @JsonProperty
    private double remainingOutstandingPrincipal;


    public void setBorrowerPaymentAmount(double borrowerPaymentAmount) {
        this.borrowerPaymentAmount = borrowerPaymentAmount;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setInitialOutstandingPrincipal(double initialOutstandingPrincipal) {
        this.initialOutstandingPrincipal = initialOutstandingPrincipal;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public void setPrincipal(double principal) {
        this.principal = principal;
    }

    public void setRemainingOutstandingPrincipal(double remainingOutstandingPrincipal) {
        this.remainingOutstandingPrincipal = remainingOutstandingPrincipal;
    }
}
