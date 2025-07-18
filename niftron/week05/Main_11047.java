package niftron.week05;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11047 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int price = Integer.parseInt(st.nextToken());
        int[] coin = new int[N];

        for(int i = 0; N > i; i ++){
            coin[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;

        for(int i = N - 1; i >= 0; i--){
            if(coin[i] <= price){
                count += price / coin[i];
                price = price % coin[i];
                
            }
        }
        System.out.println(count);
    }
}
