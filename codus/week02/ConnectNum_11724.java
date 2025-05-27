package codus.week02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ConnectNum_11724 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int point = Integer.parseInt(st.nextToken());
        int line = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] list = new ArrayList[point];
        boolean[] visited = new boolean[point];

        for(int i=0; i<point; i++){
            list[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<line; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a-1].add(b);
            list[b-1].add(a);

        }
        int count = 0;

        for(int i=0; i<point; i++){
            if(visited[i] == false){    
                count++;
                DFS(i,list, visited);
            }
        }

        bw.write(count+"\n");
        bw.close();
    }

    private static void DFS(int i,ArrayList<Integer>[] list, boolean[] visited) {
        if(visited[i]){
            return ;
        }
        visited[i] = true;
        for(int j : list[i]){
            if(!visited[j-1]){
                DFS(j-1, list, visited);
            }
        }
    }
}
