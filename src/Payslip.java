import java.util.Scanner;

public class Payslip {
    static Scanner inputData = new Scanner(System.in);

    public static void main(String[] args){

        double rateHourly, hoursWeekly, netWeekly;
        double taxFree = 11500;
        double taxRate = 0.20D;
        double ninRate = 0.06D;

        int menuOption;

        System.out.println("Welcome to Glado Payslip Manager Premium");
        System.out.println("Menu :");
        System.out.println("1. I know my rates and total weekly hours");
        System.out.println("2. I know my rates and avg. daily hours");
        System.out.println("3. I know my monthly net salary");
        System.out.print("Choose option and press enter: ");

        menuOption = inputData.nextInt();

        switch (menuOption){
            case 1:
                System.out.print("Enter hourly rate: ");
                if(inputData.hasNextDouble()){
                    rateHourly = inputData.nextDouble();
                    System.out.print("Enter total hours: ");

                    if(inputData.hasNextDouble()){
                        hoursWeekly = inputData.nextDouble();

                        PayRoll taxPayer = new PayRoll();
                        taxPayer.updateTaxInfo(taxRate, taxFree, ninRate);
                        taxPayer.calculate(rateHourly, hoursWeekly);
                        taxPayer.printPayslip();

                    } else {
                        System.out.println("Error. Not a valid number");

                    }

                } else {
                    System.out.println("Error. Not a valid number");
                }
                break;
            case 2:
                System.out.print("Enter hourly rate: ");
                if(inputData.hasNextDouble()){
                    rateHourly = inputData.nextDouble();
                    System.out.print("Enter total hours: ");

                    if(inputData.hasNextDouble()){
                        hoursWeekly = inputData.nextDouble() * 21.75;
                        // 365 - 2 x 52 (weekends per year) = avg work days per month

                        PayRoll taxPayer = new PayRoll();
                        taxPayer.updateTaxInfo(taxRate, taxFree, ninRate);
                        taxPayer.calculate(rateHourly, hoursWeekly);
                        taxPayer.printPayslip();

                    } else {
                        System.out.println("Error. Not a valid number");

                    }

                } else {
                    System.out.println("Error. Not a valid number");
                }
                break;
            case 3:
                System.out.print("Enter weekly salary: ");
                if(inputData.hasNextDouble()){
                    netWeekly = inputData.nextDouble();

                    PayRoll taxPayer = new PayRoll();
                    taxPayer.updateTaxInfo(taxRate, taxFree, ninRate);
                    taxPayer.calculate(netWeekly);
                    taxPayer.printPayslip();

                } else {
                    System.out.println("Error. Not a valid number");
                }
                break;

            default:
                System.out.println("Not a menu option");

        }

    }

}
