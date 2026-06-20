class Solution {
    public int getLastDigit(String a, String b) {
        if (b.equals("0")) {
            return 1;
        }
        
        int lastDigitBase = a.charAt(a.length() - 1) - '0';
        
        int bMod;
        if (b.length() > 2) {
            bMod = Integer.parseInt(b.substring(b.length() - 2));
        } else {
            bMod = Integer.parseInt(b);
        }
        
        int exp = (bMod % 4 == 0) ? 4 : (bMod % 4);
        
        return (int) Math.pow(lastDigitBase, exp) % 10;
    }
}