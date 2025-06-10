package niftron.week_02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main_2023{
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());

        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);
    }

    static void dfs(int startNum, int numLength){
        if(N == numLength){
            if(flag(startNum)){
                System.out.println(startNum);
            }
        }
        for(int i=1; 10 > i; i +=2){
            if(flag(startNum * 10 + i)){
                dfs(startNum * 10 + i, numLength + 1);
            }
        }

    }

    static boolean flag(int num){
        for(int i=2; num >= i * i; i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}
