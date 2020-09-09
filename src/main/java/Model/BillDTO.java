package Model;

import java.time.LocalDate;
import java.util.Queue;

public class BillDTO {

    private double billFee;
    private Queue<Double> allFees; //AYLIK UCRETLER QUEUE YAPISINDA TUTULUR. ODEME YAPARKEN QUEUE YAPISI FIFO OLDUGU ICIN...
    private CompanyDTO payingCompany;

    public void addBillsToQueue(double bill){
        this.allFees.add(bill);
    }

    public double getBillFee() {
        return billFee;
    }

    public void setBillFee(double billFee) {
        this.billFee = billFee;
    }

    public Queue<Double> getAllFees() {
        return allFees;
    }

    public void setAllFees(Queue<Double> allFees) {
        this.allFees = allFees;
    }

    public CompanyDTO getPayingCompany() {
        return payingCompany;
    }

    public void setPayingCompany(CompanyDTO payingCompany) {
        this.payingCompany = payingCompany;
    }
}
