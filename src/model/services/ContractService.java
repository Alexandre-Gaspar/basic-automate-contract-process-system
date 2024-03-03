package model.services;

import model.entities.Contract;

public class ContractService {
    
    public void processContract(Contract contract, Integer months) {

        Double amountPerInstallment = contract.getTotalValue() / months;
        OnlinePaymentServices service = new PaypalService();

        int count = 0;
        do {
            ++months;
            service.interest(amountPerInstallment, months);
            contract.addInstallment(null);
        } while (count < months);
        
    }

}
