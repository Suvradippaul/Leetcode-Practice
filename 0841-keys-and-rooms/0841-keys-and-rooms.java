class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int totalRooms = rooms.size();
        
        boolean[] visited = new boolean[totalRooms];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        
        int roomsVisited = 1;    // because we are at the room 0
        
        while (!queue.isEmpty()) {
            int currRoom = queue.poll();
            for (int canBeUnlocked : rooms.get(currRoom)) {
                if (!visited[canBeUnlocked]) {
                    visited[canBeUnlocked] = true;
                    queue.add(canBeUnlocked);
                    roomsVisited++;
                    if (roomsVisited == totalRooms) return true;
                }
            }
        }
        
        return roomsVisited == totalRooms;
    }
}