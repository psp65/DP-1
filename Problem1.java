// Time Complexity : coins.length * amount (n * m)
// Space Complexity : amount (linear)
// Did this code successfully run on Leetcode : y
// Any problem you faced while coding this : n
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        int max = amount + 1;

        Arrays.fill(dp, max);
        dp[0] = 0;
    
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        
        return dp[amount] > amount ? -1 : dp[amount];
    }
}