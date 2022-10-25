class Solution {
    public boolean arrayStringsAreEqual(String[] arr1, String[] arr2) {
        int i = 0, j = 0, ptr1 = 0, ptr2 = 0;  // ptr is pointer for each word, i and j are pointers for each character in a word
		
		while (ptr1 < arr1.length && ptr2 < arr2.length) {
			if (arr1[ptr1].charAt(i) == arr2[ptr2].charAt(j)) {
				i++;
				j++;
			}
			else {
				return false;
			}
			if (i == arr1[ptr1].length()) {
				ptr1++;
				i = 0;
			}
			if (j == arr2[ptr2].length()) {
				ptr2++;
				j = 0;
			}
		}
		return ptr1 == arr1.length && ptr2 == arr2.length;
    }
}