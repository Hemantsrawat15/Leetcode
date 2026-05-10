class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int left = 0, right = 0;
        int maxLength = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        while(right<n){
            char ch = s.charAt(right);
            map.put(ch,map.getOrDefault(ch,0)+1);
            while(map.get(ch)>1){
                map.put(s.charAt(left),map.get(s.charAt(left))-1);
                if(map.get(ch) == 0) map.remove(ch);
                left++;
            }
            int length = right-left+1;
            maxLength = Math.max(maxLength,length);
            right++;
        }
        return maxLength;
    }
}