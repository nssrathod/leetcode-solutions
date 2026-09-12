class Solution {
    public int countLargestGroup(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int dsum = 0;
        for(int i = 1; i <=n; i++){
            if(i < 10){
                dsum = i;
            }
            else{
                dsum = digitSum(i);
            }
            map.put(dsum, map.getOrDefault(dsum, 0) + 1);
        }
        int mx = 0;
        for(int val: map.values()){
            mx = Math.max(mx, val);
        }
        int cnt = 0;
        for(int val: map.values()){
            if(val == mx){
                cnt++;
            }
        }
        return cnt;
    } 
    public int digitSum(int num){
        int sum = 0;
        while(num > 0){
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }  
}