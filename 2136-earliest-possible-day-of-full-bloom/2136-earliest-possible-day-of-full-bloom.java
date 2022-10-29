class Solution {
    class Pair {
		int plantTime;
		int growTime;
		
		Pair(int t, int g) {
			this.plantTime = t;
			this.growTime = g;
		}
	}
    
    public int earliestFullBloom(int[] plantTimes, int[] growTimes) {
        int n = plantTimes.length;
		Pair[] pairs = new Pair[n];
		for (int i = 0; i < n; i++) {
			pairs[i] = new Pair(plantTimes[i], growTimes[i]);
		}
		
		Arrays.sort(pairs, (p1, p2) -> p2.growTime-p1.growTime);
		
		int prevPlantTime = 0;
		int totalOverallTime = 0;
		for (Pair currentPair : pairs) {
			totalOverallTime = Math.max(totalOverallTime, prevPlantTime + currentPair.plantTime + currentPair.growTime);
			prevPlantTime += currentPair.plantTime;
		}
		
		return totalOverallTime;
    }
}