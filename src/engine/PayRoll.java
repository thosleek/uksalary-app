package engine;


public class PayRoll {

    double taxToPay, ninToPay, grossSalary, netSalary, taxRate, taxFree, ninRate, rateHourly, hoursWeekly;


    public void updateTaxInfo(double taxRate, double taxFree, double ninRate){
        this.taxRate = taxRate;
        this.taxFree = taxFree;
        this.ninRate = ninRate;

    }
    public void calculate(double netSalary){
        this.netSalary = netSalary;
        this.taxToPay = Math.round(((this.netSalary - (this.taxFree/12)) * this.taxRate) * 100) / 100;
        this.ninToPay = Math.round((this.netSalary * this.ninRate) * 100) / 100;
        this.grossSalary = this.netSalary - this.ninToPay - this.taxToPay;

    }

    public void calculate(double rateHourly, double hoursWeekly){
        this.netSalary = Math.round((rateHourly * (hoursWeekly * 4.333)) * 100) / 100;
        this.taxToPay = Math.round(((this.netSalary - (this.taxFree/12)) * this.taxRate) * 100) / 100;
        this.ninToPay = Math.round((this.netSalary * this.ninRate) * 100) / 100;
        this.grossSalary = this.netSalary - this.ninToPay - this.taxToPay;

    }

    public void printPayslip(){
        System.out.println("Net      |       | " + this.netSalary);
        System.out.println("Tax      | " + this.taxRate * 100 + "% | " + this.taxToPay);
        System.out.println("Nin      | " + this.ninRate * 100 + "%  | " + this.ninToPay);
        System.out.println("Gross    |       | " + this.grossSalary);

    }

} // v1.0
