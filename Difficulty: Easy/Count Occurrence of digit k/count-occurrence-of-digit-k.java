class Solution {
    public int num(int k, int arr[]) {
        // code here
        int count=0;
        for(int i=0;i<arr.length;i++){
            int n=arr[i];
            if(n==0 &&k==0){
                count++;
            }while(n>0){
                int digit=n%10;
                if(k==digit){
                    count++;
                } n /=10;
            }
        }return count;
        
    }
}