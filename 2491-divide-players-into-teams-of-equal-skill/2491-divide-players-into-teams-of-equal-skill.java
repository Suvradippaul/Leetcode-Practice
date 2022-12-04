class Solution {
    public long dividePlayers(int[] skills) {
        int n = skills.length;
		Arrays.sort(skills);
		
		int i = 0;
		int j = n-1;
        int reqSkill = sum(skills)/ (n/2);
        int[][] skillPair = new int[n/2][2];
        
		while (i < j) {
			int skill = skills[i];
			if (skills[j] == reqSkill-skill) {
				skillPair[i][0] = skill;
                skillPair[i][1] = reqSkill-skill;
				i++;
				j--;
			}
			else return -1;
		}
		
		long ans = 0;
        for (int[] pair : skillPair) {
        	ans += pair[0] * pair[1];
        }
        
        return ans;	
    }
    
    int sum(int[] skills) {
		int sum = 0;
		for (int n : skills) sum += n; 
		return sum;
	}
}