package com.repaymentplan.service;

import com.repaymentplan.dto.RepaymentInputDTO;
import com.repaymentplan.dto.RepaymentOutputDTO;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Payment service responsible for computing the repayment plan
 */

@Service
public class RepaymentService {

    /**
     * Utility method to calculate annuity
     *
     * @param loanAmount - the initial loan amount
     * @param interestRate - the rate of interest
     * @param duration - the duration
     * @return - the computed annuity
     */
    public double calculateAnnuity(double loanAmount, double interestRate, int duration){

        //Compute Monthly Interest
        double monthlyInterest = interestRate/1200;

        return (double)Math.round(loanAmount/
                ((1-(Math.pow(1+monthlyInterest,(-1)*duration)))/
                        (monthlyInterest))*100)/100;
    }


    /**
     * Utility method to calculate interest for each installment
     *
     * @param interestRate - the rate of interest
     * @param loanAmount - the loan amount
     * @return - the computed interest
     */
    public double calculateInterest(double interestRate, double loanAmount){

        return  (double)Math.round((((interestRate*30/100)*
                loanAmount)/360)*100)/100;
    }

    /**
     * Utility method to calculate principal
     *
     * @param annuity - the value of annuity computed
     * @param interest- the value of interest computed
     * @return - the computed principal
     */

    public double calculatePrincipal(double annuity, double interest){
        return (double)Math.round((annuity - interest)*100)/100;
    }

    /**
     * Utility method to calculate reamining outstanding principal
     *
     * @param loanAmount - the loan amount
     * @param principal - the current principal amount
     * @return - the remaining outstanding principal
     */
    public double calculateRemainingOutStandingPrincipal(double loanAmount, double principal){
        return (double)Math.round((loanAmount - principal)*100)/100;
    }

    /**
     * Service method to generate/compute repayment plan
     *
     * @param repaymentInputDTO - the input JSON object
     * @return - JSON list of repayment installments
     */
    public List<RepaymentOutputDTO> generatePlan(RepaymentInputDTO repaymentInputDTO){

        //Maintain a result list to feed in the final output
        List<RepaymentOutputDTO> result = new ArrayList<>();

        //Read the required parameters from input JSON
        double initialOutstandingPrincipal = repaymentInputDTO.getLoanAmount();
        double nominalRate = repaymentInputDTO.getNominalRate();
        int duration  = repaymentInputDTO.getDuration();
        Date startDate = repaymentInputDTO.getStartDate();

        //Keep a calendar instance for date computations
        Calendar cal = Calendar.getInstance();

        //Generate output date for every month < duration
        while(duration!=0) {

            //Compute required values
            double annuity = calculateAnnuity(initialOutstandingPrincipal, nominalRate, duration);
            double interest = calculateInterest(nominalRate, initialOutstandingPrincipal);
            double principal = calculatePrincipal(annuity, interest);

            //Edge case as per requirements
            if(principal > initialOutstandingPrincipal){
                principal = initialOutstandingPrincipal;
            }

            double remainingOutstandingPrincipal = calculateRemainingOutStandingPrincipal(initialOutstandingPrincipal, principal);

            //Create a new output object for each installment and set the computed values
            RepaymentOutputDTO repaymentOutputDTO = new RepaymentOutputDTO();
            repaymentOutputDTO.setBorrowerPaymentAmount(annuity);
            repaymentOutputDTO.setRemainingOutstandingPrincipal(remainingOutstandingPrincipal);
            repaymentOutputDTO.setDate(startDate);
            repaymentOutputDTO.setInterest(interest);
            repaymentOutputDTO.setInitialOutstandingPrincipal(initialOutstandingPrincipal);
            repaymentOutputDTO.setPrincipal(principal);

            //Add the entry to resultant list
            result.add(repaymentOutputDTO);

            //Update the principal amount to remaining outstanding principal
            initialOutstandingPrincipal = remainingOutstandingPrincipal;

            //Increement the date for next installment
            cal.setTime(startDate);
            cal.add(Calendar.MONTH, +1);
            startDate = cal.getTime();

            duration--;
        }

        //Return the result list
        return result;
    }
}
