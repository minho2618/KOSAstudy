package niftron.week03;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main_1260 {
    static boolean[] visited;
    static ArrayList<Integer>[] A;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        A = new ArrayList[B + 1];
        for (int i = 0; i <= B; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < C; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            A[S].add(E);
            A[E].add(S);
        }

        for (int i = 1; i <= B; i++) {
            Collections.sort(A[i]);
        }

        visited = new boolean[B + 1];
        DFS(start);
        System.out.println();
        visited = new boolean[B + 1];
        BFS(start);
        System.out.println();
    }

    public static void DFS(int Node) {
        System.out.print(Node + " ");
        visited[Node] = true;
        for (int i : A[Node]) {
            if (!visited[i]) {
                DFS(i);
            }
        }
    }

    public static void BFS(int Node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(Node);
        visited[Node] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            System.out.print(now + " ");
            for (int i : A[now]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}