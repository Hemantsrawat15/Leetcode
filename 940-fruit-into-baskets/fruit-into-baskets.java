class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int left = 0, right = 0, maxLength = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        while(right<n){
            map.put(fruits[right],map.getOrDefault(fruits[right],0)+1);
            while(map.size()>2){
                map.put(fruits[left],map.get(fruits[left])-1);
                if(map.get(fruits[left]) == 0) map.remove(fruits[left]);
                left++;
            }
            int length = right - left + 1;
            maxLength = Math.max(maxLength,length);
            right++;
        }
        return maxLength;
    }
}