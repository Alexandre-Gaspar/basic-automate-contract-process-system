package model.services;

public class PaypalService implements OnlinePaymentServices{
    
    public Double paymentFee(Double amount) {
        return amount * 0.02;
    }

    public Double interest(Double amount, Integer months) {
        return amount * months / 100;
    }

}
