package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Contract {
    
    private Integer number;
    private LocalDate date;
    private Double totalValue;
    
    // Association (have many)...
    private List<Installment> installments = new ArrayList<>();

    // Formating date (dd/MM/yyyy)...
    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    public Contract() {} // Empty constructor...

    public Contract(Integer number, LocalDate date, Double totalValue) {
        this.number = number;
        this.date = date;
        this.totalValue = totalValue;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public List<Installment> getInstallment() {
        return installments;
    }
    
    public void addInstallment(Installment installment) {
        this.installments.add(installment);
    }

    public void removeInstallment(Installment installment) {
        this.installments.remove(installment);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Installment each : installments) {
            sb.append(each.getDueDate().format(dateFormat) + " - " + String.format("%.2f%n", each.getAmount()));
        }

        return sb.toString();
    }

}