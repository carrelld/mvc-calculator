import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int[] returned = Arrays.stream(sc.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        int[] due = Arrays.stream(sc.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        
        int year = returned[3] - due[3];
        int month = returned[2] - due[2];
        int day = returned[1] - due[1];
        
        int fine = 0;
        
        if (year > 0) {
            fine = 10000;
        } else if (month > 0 && year == 0) {
            fine = month * 500;
        } else if (day > 0 && month == 0 && year == 0) {
            fine = day * 15;
        }
        
        System.out.println(fine);
    }
}