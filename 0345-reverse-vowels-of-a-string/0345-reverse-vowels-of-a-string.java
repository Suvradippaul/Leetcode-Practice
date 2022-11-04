class Solution {
    public String reverseVowels(String s) {
		Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char[] chars = s.toCharArray();
        
        int i = 0;
        int j = chars.length-1;
        while (i < j) {
            while (i < j && !set.contains(chars[i])) {
            	i++;
            }
            while (i < j && !set.contains(chars[j])) {
            	j--;
            }
            swap(chars, i, j);
            i++;
            j--;
        }
        
        return String.valueOf(chars);
    }
    
    void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}