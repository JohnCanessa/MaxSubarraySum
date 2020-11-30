import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


/**
 * 
 */
public class MaxSubarraySum {


    /**
     * Brute force approach.
     * O(n^3)
     */
    static int bruteForce(int[] nums) {

        // **** sanity check(s) ****
        if (nums == null)
            return 0;

        if (nums.length == 1)
            return nums[0];

        // **** initialization ****
        int maxSum = 0;

        // **** from start ... O(n) *****
        for (int s = 0; s < nums.length; s++) {

            // **** ... to end ... O(n) ****
            for (int e = s; e < nums.length; e++) {

                // **** compute sum O(n) ****
                int sum = 0;
                for (int i = s; i <= e; i++) {
                    sum += nums[i];
                }

                // **** update max sum ****
                maxSum = Math.max(maxSum, sum);
            }
        }

        // **** return max sum ****
        return maxSum;
    }


    /**
     * Optimized approach.
     * O(n^2)
     */
    static int optimized(int[] nums) {

        // **** sanity check(s) ****
        if (nums == null)
        return 0;
    
        if (nums.length == 1)
            return nums[0];

        // **** initialization ****
        int maxSum = 0;

        // **** from start ... O(n) *****
        for (int s = 0; s < nums.length; s++) {

            // **** ... to end ... O(n) ****
            int sum = 0;
            for (int e = s; e < nums.length; e++) {

                // **** update sum ****
                sum += nums[e];

                // **** update max sum ****
                maxSum = Math.max(maxSum, sum);
            }
        }

        // **** return max sum ****
        return maxSum;
    }


    /**
     * Using Kadane's algorithm.
     * O(n)
     */
    static int kadanes(int[] nums) {

        // **** sanity check(s) ****
        if (nums == null)
            return 0;
    
        if (nums.length == 1)
            return nums[0];

        // **** initialization ****
        int bestSum  = Integer.MIN_VALUE;
        int currSum = nums[0];

        // **** traverse nums O(n) ****
        for (int i = 1; i < nums.length; i++) {

            // **** increment or restart sum ****
            currSum = Math.max(currSum + nums[i], nums[i]);

            // **** update best sum if needed (remember best sum) ****
            bestSum = Math.max(bestSum, currSum);
        }

        // **** return best sum ****
        return bestSum;
    }


    /**
     * Test scaffolding.
     * 
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        // **** open stream ****
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // **** read array ****
        String[] numStrs = br.readLine().trim().split(",");

        // **** close stream ****
        br.close();

        // **** populate nums array ****
        int[] nums = new int[numStrs.length];
        for (int i = 0; i < numStrs.length; i++) {
            nums[i] = Integer.parseInt(numStrs[i]);
        }

        // ???? display array ????
        System.out.println("main <<< nums: " + Arrays.toString(nums));

        // **** find and display the max sum of a subarray ****
        System.out.println("main <<< bruteForce: " + bruteForce(nums));

        // **** find and display the max sum of a subarray ****
        System.out.println("main <<<  optimized: " + optimized(nums));

        // **** find and display the max sum of a subarray ****
        System.out.println("main <<<    kadanes: " + kadanes(nums));
    }
}