class Solution {
    static int closestNumber(int n, int m) {
        // code here
        int lower =(n/m)*m;
        int upper;
        if(n<0){
            upper=lower;
            lower = lower-Math.abs(m);
            }
        else{
            upper =lower+Math.abs(m);
            
        }
        int d1=Math.abs(n - lower);
        int d2=Math.abs(n - upper);
        if(d1<d2){
            return (lower);
        }else if(d1>d2){
            return (upper);
        }else{
            if(Math.abs(lower)>Math.abs(upper)){
                return lower;
            }else{
                return upper;
            }
        }
    }
}