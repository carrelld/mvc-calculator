import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Line {
    
    private static final List<Integer> DENOMINATIONS = Arrays.asList(100, 50, 25);
    static {
        Collections.sort(DENOMINATIONS, Collections.reverseOrder());
    }
    
    /**
     * Decide whether or not a clerk can return appropriate change for a series of ticket purchases. Requires the clerk starts with 0, tickets are 25, and possible denominations are 25, 50, and 100 
     * @param peopleInLine the order and size of currency being given to the clerk, requires values of 25, 50, or 100 only
     * @return "YES" if the clerk can make it through the whole line with correct change and "NO" if the clerk reaches a spot in the array where returning the correct change is impossible
     */
    public static String Tickets(int[] peopleInLine) {
        
        final int ticketPrice = 25;
        Clerk clerk = new Clerk();
        
        for (int bill : peopleInLine) {
            assert DENOMINATIONS.contains(bill);
            boolean transactionSuccessful = clerk.transaction(ticketPrice, bill);
            if (!transactionSuccessful) {
                return "NO";
            }
        }
        
        return "YES";
        
    }
    
    static class Clerk {
        
        private List<Integer> wallet = new ArrayList<Integer>();
        
        Clerk() {}
        
        boolean transaction(int price, int tendered) {
            
            int change = tendered - price;
            
            for (int denomination : DENOMINATIONS) {
                while (change >= denomination && wallet.indexOf(denomination) != -1) {
                    wallet.remove(denomination);
                    change -= denomination;
                }
            }
            
            if (change == 0) {
                this.wallet.add(tendered);
                return true;                
            } else {
                return false;
            }
        }
    }
}