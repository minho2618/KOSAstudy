package niftron.week_02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main_13023 {
    static int num, friend;
    static ArrayList<Integer> array[];
    static boolean visited[];
    static boolean arrived;

    static void DFS(int now, int friendShip){
        if(friendShip == 5){
            arrived = true;
            return;
        }

        visited[now] = true;
        
        for(int i : array[now]){
            if(visited[i]) continue;
            DFS(i, friendShip +1 );
        }

        visited[now] = false;
    }

    static void solve() throws Exception{
        for(int i = 0; num > i; i++){
            DFS(i, 1);
            if(arrived) break;
        }

        if(arrived){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }

    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        num = Integer.parseInt(st.nextToken());
        friend = Integer.parseInt(st.nextToken());
    
        array = new ArrayList[num];
        visited = new boolean[num];
    
        for(int i = 0; i < num; i++) {
            array[i] = new ArrayList<>();
        }
    
        for(int i = 0; i < friend; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            array[c].add(d);
            array[d].add(c);
        }
    }
    
    public static void main(String[] args) throws Exception{
        input();
        solve();
    }
}
