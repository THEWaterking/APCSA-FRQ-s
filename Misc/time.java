package Misc;
import java.util.Scanner;

public class time {
    public static void main(String[] args){
        Scanner time = new Scanner(System.in);
        int sec = time.nextInt();
        int minutes = (sec/60);
        int hours = (minutes/60);
        int remMinutes = minutes%60;
        int remSec = sec%60;
        System.out.printf("Hours: %d%nMinutes: %d%nSecond: %d%n", hours, remMinutes, remSec);
        time.close();
    }
}
