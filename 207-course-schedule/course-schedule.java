class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //adjacency list and indegree array

        List<List<Integer>> adj =new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        for(int[] p:prerequisites){
            int course = p[0];
            int pre = p[1];
            adj.get(pre).add(course);
            indegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                queue.offer(i);
            }
        }

        int count=0;
        while(!queue.isEmpty()){
            int course = queue.poll();
            count++;
            for(int next:adj.get(course)){
                indegree[next]--;
                if(indegree[next]==0){
                    queue.offer(next);
                }
            }
        }
        return numCourses==count;
    }
}