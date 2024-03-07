package model.services;

import java.time.LocalDate;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService extends PaypalService {

    public void processContract(Contract contract, Integer months) {

        Double amountPerInstallment = contract.getTotalValue() / months;

        int count = 0;
        do {
            ++count;
            Double simpleMonthlyInterest = amountPerInstallment + super.interest(amountPerInstallment, count);
            Double totalValuePerInstallment = simpleMonthlyInterest + super.paymentFee(simpleMonthlyInterest);
            LocalDate dateWithNextMonth = contract.getDate().plusMonths(count);

            contract.addInstallment(new Installment(dateWithNextMonth, totalValuePerInstallment));
        } while (count < months);

    }

}
