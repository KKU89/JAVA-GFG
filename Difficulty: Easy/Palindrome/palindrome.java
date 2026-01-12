class Solution {
    public boolean isPalindrome(int n) {
        int a = n;
        int rev = 0;
        while(a >0){
            rev = (rev*10)+ a%10;
            a /=10;
            
        }if (rev == n){
            return true;
        }else return false;
        
    
}}