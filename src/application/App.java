package application;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;
import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
// import model.services.PaypalService;


public class App {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("\n\nEnter the contract datas");
        System.out.print("Number: ");
        Integer contractNumber = sc.nextInt();
        System.out.print("Date (dd/MM/yyyy): ");
        sc.nextLine(); // Clear the buffer memory after clicking ENTER
        LocalDate contractDate = LocalDate.parse(sc.nextLine(), formatDate);
        System.out.print("Contract value: ");
        Double contractValue = sc.nextDouble();

        Contract contract = new Contract(contractNumber, contractDate, contractValue); // Create a contract

        ContractService service = new ContractService();

        System.out.print("Enter the number of installments: ");
        Integer installmentNumber = sc.nextInt();

        service.processContract(contract, installmentNumber);

        System.out.println("\nParcelas:");
        
        System.out.println(contract.toString());

    }
}
