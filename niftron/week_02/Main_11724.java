package niftron.week_02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class Main_11724 {
    static int N, M;
    static ArrayList<Integer>[] list;
    static boolean[] visited;

    static void BFS(int s) {
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(s);
        visited[s] = true;

        while (!Q.isEmpty()) {
            int now = Q.poll();
            for (int next : list[now]) {
                if (!visited[next]) {
                    Q.offer(next);
                    visited[next] = true;
                }
            }
        }
    }

    static void Solve() {
        int count = 0;
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                BFS(i);
                count++;
            }
        }
        System.out.println(count);
    }

    static void inputData() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list[s].add(e);
            list[e].add(s);
        }
    }

    public static void main(String[] args) throws Exception {
        inputData();
        Solve();
    }
}
