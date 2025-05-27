package codus.week02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFSandBFS {
    static ArrayList<Integer>[] list = null;
    static int N = 0;
    static int M = 0;
    static int V = 0;
    static boolean visited[] = null;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer ss = new StringTokenizer(br.readLine());
        N = Integer.parseInt(ss.nextToken());
        M = Integer.parseInt(ss.nextToken());
        V = Integer.parseInt(ss.nextToken());

        list = new ArrayList[N];
            for (int i = 0; i < N; i++) {
        list[i] = new ArrayList<>();
        }

        StringTokenizer st = null;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a-1].add(b);
            list[b-1].add(a);
        }
        for(int i=0; i<N; i++){
            list[i].sort(null);
        }

        visited = new boolean[N];
        DFS(V-1);
        sb.append("\n");
        visited = new boolean[N];
        BFS(V-1);
        bw.write(sb.toString());
        bw.close();
    }

    public static void DFS(Integer x){
        visited[x] = true;
        sb.append(x+1).append(" ");
        for(int next : list[x]){
            if(!visited[next-1])
                DFS(next-1);
        }
    }
    public static void BFS(Integer x){
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        visited[x] = true;
        while(!q.isEmpty()){
            int now = q.poll();
            sb.append(now+1).append(" ");
            for(int i : list[now]){
                if(!visited[i-1]){
                    q.add(i-1);
                    visited[i-1] = true;
                }
            }   
        }

    }
}
