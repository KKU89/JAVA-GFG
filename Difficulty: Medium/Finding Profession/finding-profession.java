class Solution {
    public String profession(int level, int pos) {
        if (pos == 1) {
            return "Engineer";
        }
        
        String parentProfession = profession(level - 1, (pos + 1) / 2);
        
        if (pos % 2 != 0) {
            return parentProfession;
        } else {
            return parentProfession.equals("Engineer") ? "Doctor" : "Engineer";
        }
    }
}