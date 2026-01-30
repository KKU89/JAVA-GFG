class Solution {
    ArrayList<Integer> nFibonacci(int N) {
        ArrayList<Integer> fib = new ArrayList<>();
        int a = 0, b = 1;
        
        fib.add(a);  
        while (b <= N) {
            fib.add(b);
            int c = a + b;
            a = b;
            b = c;
        }
        
        return fib;
    }
}
