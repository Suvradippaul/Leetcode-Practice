class Solution {
    public long dividePlayers(int[] skills) {
        int n = skills.length;
		Arrays.sort(skills);
		
		int i = 0;
		int j = n-1;
        int reqSkill = sum(skills)/ (n/2);
        
        long ans = 0;
		while (i < j) {
			int skill = skills[i];
            int otherSkill = reqSkill-skill;
			if (skills[j] == otherSkill) {
				ans += skill * otherSkill;
				i++;
				j--;
			}
			else return -1;
		}
        
        return ans;	
    }
    
    int sum(int[] skills) {
		int sum = 0;
		for (int n : skills) sum += n; 
		return sum;
	}
}