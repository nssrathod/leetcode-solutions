class Solution {
    public int coinChange(int[] coins, int amount) {
    /* Arrays.sort(coins);
     int count = 0;
     int i = coins.length-1;
     while(amount > 0 && i >= 0){
        if(coins[i]<=amount){
            int maxCoins = amount/coins[i];
            count += maxCoins;
            amount -= maxCoins * coins[i];
        }
        i--;
     }
     return amount == 0 ? count : -1;*/


     int[] dp = new int[amount+1];
     for(int i = 1; i <= amount; i++){
        dp[i] = amount + 1;
     }
     dp[0] = 0;

     for(int i = 1; i <= amount; i++){
        for(int coin : coins){
            if(i >= coin){
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
     }
     return dp[amount] > amount ? -1: dp[amount];

    }
}