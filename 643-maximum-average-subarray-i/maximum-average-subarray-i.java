class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int left = 0;
        long currsum = 0;
        long maxsum = 0;

        for(int i = 0; i < k; i++){
            currsum += nums[i];
        }
        
        maxsum = currsum;
        for(int right = k; right < nums.length; right++){
            currsum -= nums[left];
            left++;
            currsum += nums[right];
            maxsum = Math.max(maxsum, currsum);
        }
        return (double) maxsum / k;
    }
}