package niftron.week04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main_1167 {

    static ArrayList<Node>[] list;
    static boolean[] visited;
    static int max = 0;
    static int node; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            while (true) {
                int e = Integer.parseInt(st.nextToken());
                if (e == -1) break;
                int cost = Integer.parseInt(st.nextToken());
                list[s].add(new Node(e, cost));
            }
        }

        visited = new boolean[n + 1];
        dfs(1, 0);

        visited = new boolean[n + 1];
        max = 0;
        dfs(node, 0);

        System.out.println(max);
    }

    public static void dfs(int x, int len) {
        if (len > max) {
            max = len;
            node = x;
        }

        visited[x] = true;

        for (Node n : list[x]) {
            if (!visited[n.e]) {
                dfs(n.e, len + n.cost);
            }
        }
    }

    public static class Node {
        int e;
        int cost;  

        public Node(int e, int cost) {
            this.e = e;
            this.cost = cost;
        }
    }
}
