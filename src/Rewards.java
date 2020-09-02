import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Rewards {

    public static final Double ONE_POINT_CUTOFF = Double.valueOf(50);
    public static final Double TWO_POINT_CUTOFF = Double.valueOf(100);

    public static void main(String[] args) {
        long totalRewards = 0L;

        try {
            Scanner transactions = new Scanner(new File("transactions1.txt"));
            while (transactions.hasNextLine()) {
                Double transaction = Double.valueOf(transactions.nextLine());

                // transaction < 50
                if (transaction < ONE_POINT_CUTOFF) {
                    // ignore, no reward points
                }
                // 50 <= transaction < 100
                if (transaction >= ONE_POINT_CUTOFF && transaction < TWO_POINT_CUTOFF) {
                    // 1 reward point per dollar above 50 less than 100
                    totalRewards += (transaction - ONE_POINT_CUTOFF) * 1;
                }
                // transaction >= 100
                if (transaction >= TWO_POINT_CUTOFF) {
                    // 2 reward points per dollar above 100
                    totalRewards += ONE_POINT_CUTOFF + (transaction - TWO_POINT_CUTOFF) * 2;
                }
            }
            transactions.close();

            System.out.println("Total Rewards = " + totalRewards);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
