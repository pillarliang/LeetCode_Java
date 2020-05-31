package LeetCode_Java.DFS.Reorder_Routes_to_Make_All_Paths_Lead_to_the_City_Zero;

import java.util.*;

public class Reorder_Routes_to_Make_All_Paths_Lead_to_the_City_Zero {
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> al = new ArrayList<>();

        for(int i = 0; i < n; ++i)
            al.add(new ArrayList<>());
        for (int[] c : connections) {
            al.get(c[0]).add(c[1]);
            al.get(c[1]).add(-c[0]);
        }
        return dfs(al, new boolean[n], 0);
    }

    private int dfs(List<List<Integer>> al, boolean[] visited, int from) {
        int change = 0;
        visited[from] = true;
        for (int to : al.get(from))
            if (!visited[Math.abs(to)])
                change += dfs(al, visited, Math.abs(to)) + (to > 0 ? 1 : 0);
        return change;

    }
}
