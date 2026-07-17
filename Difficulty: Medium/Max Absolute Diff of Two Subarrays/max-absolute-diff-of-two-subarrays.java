class Solution {
    public int maxDiffSubArrays(int[] arr) {
        int n = arr.length;
        int[] leftMax = new int[n];
        int[] leftMin = new int[n];
        int[] rightMax = new int[n];
        int[] rightMin = new int[n];
        
        int currMax = 0, currMin = 0, maxSoFar = Integer.MIN_VALUE, minSoFar = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            currMax = Math.max(arr[i], currMax + arr[i]);
            maxSoFar = Math.max(maxSoFar, currMax);
            leftMax[i] = maxSoFar;
            
            currMin = Math.min(arr[i], currMin + arr[i]);
            minSoFar = Math.min(minSoFar, currMin);
            leftMin[i] = minSoFar;
        }
        
        currMax = 0; currMin = 0; maxSoFar = Integer.MIN_VALUE; minSoFar = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            currMax = Math.max(arr[i], currMax + arr[i]);
            maxSoFar = Math.max(maxSoFar, currMax);
            rightMax[i] = maxSoFar;
            
            currMin = Math.min(arr[i], currMin + arr[i]);
            minSoFar = Math.min(minSoFar, currMin);
            rightMin[i] = minSoFar;
        }
        
        int result = 0;
        for (int i = 0; i < n - 1; i++) {
            result = Math.max(result, Math.max(Math.abs(leftMax[i] - rightMin[i + 1]), Math.abs(leftMin[i] - rightMax[i + 1])));
        }
        
        return result;
    }
}