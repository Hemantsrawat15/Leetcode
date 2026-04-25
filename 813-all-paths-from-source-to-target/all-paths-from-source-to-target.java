class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfsHelper(0, graph, ans, path);
        return ans;
    }

    public static void dfsHelper(int node, int[][] graph, List<List<Integer>> ans, List<Integer> path) {
        path.add(node);
        if (node == graph.length - 1) {
            ans.add(new ArrayList<>(path));
        } else {
            int[] edges = graph[node];
            for (int i = 0; i < edges.length; i++) {
                dfsHelper(edges[i], graph, ans, path);
            }
        }
        path.remove(path.size()-1);
    }
}