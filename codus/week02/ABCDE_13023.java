package codus.week02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ABCDE_13023 {
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer>[] list= null;
    static boolean isTrue = false;
    static boolean[] visited = null;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 노드 개수
        int M = Integer.parseInt(st.nextToken()); // 간선 개수
        visited = new boolean[N];
        list = new  ArrayList[N];

        for(int i=0; i<N; i++){
            list[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        for(int i = 0; i< N; i++){
            if(isTrue == false)
                DFS(i, 1);
            else
                break;
        }
        if(isTrue == false)
            sb.append(0);
        else
            sb.append(1);

        bw.write(sb.toString() + "\n");
        bw.flush();
        bw.close();
    }
    private static void DFS(int start, int depth){
        
        if(depth == 5){
            isTrue = true;
            return ;
        }
        visited[start] = true;
        for(int i : list[start]){
            if(!visited[i])
                DFS(i, depth+1);
        }
        visited[start] = false;
    }

}
