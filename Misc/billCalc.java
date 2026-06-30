package Misc;
import java.util.Scanner;
public class billCalc {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter pre tax bill: ");
        double preBill = scan.nextDouble();
        System.out.print("Please enter local tax rate: ");
        double taxRate = scan.nextDouble();
        System.out.print("Please enter tip rate: ");
        double tipRate = scan.nextDouble();

        scan.close();

        double taxAmount = ((preBill)*(taxRate/100));
        double tipAmount = (preBill*(tipRate/100));
        double totalBill = tipAmount +taxAmount + preBill;
        System.out.printf("Your total is %.2f%n", totalBill);



    
    
    
    }
}


