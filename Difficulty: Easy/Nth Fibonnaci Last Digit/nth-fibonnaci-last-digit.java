// User function Template for Java

class Solution {
    static int fib(int N) {
        // code here
        if(N<2) return N;
        int a=0;
        int b=1;
        for(int i=2;i<=N;i++){
            int c = (a+b)%10;
            a=b;
            b=c;
            
        }return b;
    }
}