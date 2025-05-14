package minho.week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon1260 {
    static List<List<Integer>> graph = new ArrayList<>();

    static boolean[] visitedDFS;
    static boolean[] visitedBFS;

    static List<Integer> dfsRoute = new ArrayList<>();
    static List<Integer> bfsRoute = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        StringTokenizer st = new StringTokenizer(str);
        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= node; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edge; i++) {
            str = br.readLine();
            st = new StringTokenizer(str);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        for (int i = 0; i <= node; i++) {
            graph.get(i).sort((n1, n2) -> n1 - n2);
        }

        visitedDFS = new boolean[node + 1];
        visitedBFS = new boolean[node + 1];

        DFS(startNode);
        for (int i : dfsRoute) System.out.print(i + " ");
        System.out.println();

        BFS(startNode);
        for (int i : bfsRoute) System.out.print(i + " ");
        System.out.println();
    }

    public static void DFS(int v) {
        if (visitedDFS[v])
            return;

        visitedDFS[v] = true;
        dfsRoute.add(v);
        for (int i : graph.get(v)) {
            if (!visitedDFS[i]) {
                DFS(i);
            }
        }
    }

    public static void BFS(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visitedBFS[v] = true;
        bfsRoute.add(v);

        while (!queue.isEmpty()) {
            int n = queue.poll();
            for (int i : graph.get(n)) {
                if (!visitedBFS[i]) {
                    queue.add(i);
                    visitedBFS[i] = true;
                    bfsRoute.add(i);
                }
            }
        }
    }
}
