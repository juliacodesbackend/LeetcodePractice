class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int countZeros=0, zeroPos=0;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                countZeros++;
                zeroPos = i;
            }
        }

        if (countZeros > 1) {
            for (int i = 0; i < n; i++) {
                result[i] = 0;
            }
            return result;
        }

        int prefixProduct = 1;
        
        // compute prefix first
        for (int i = 0; i < n; i++) {
            result[i] = prefixProduct;
            prefixProduct *= nums[i]; // compute prefix for the next i
        }
        // prefixProduct for 0: 1, result = 1
        // prefixProduct for 1: 1; result = 1;
        // prefixProduct for 2: 2; result = 2;
        // prefixProduct for 3: 6; result = 6;
        // result = [1,1,2,6]

        int postfixProduct = 1;

        for (int i = n - 1; i >= 0; i--) {
            result[i] *= postfixProduct;
            postfixProduct *= nums[i];
        }

        // postfixProduct for [3]: 1, result = 6
        // postfixProduct for [2]: 4; result = 8;
        // postfixProduct for [1]: 12; result = 12;
        // postfixProduct for [0]: 24; result = 24;
        // result = [24,12,8,6]

        return result;
    }
}