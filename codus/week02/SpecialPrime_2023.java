package codus.week02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class SpecialPrime_2023 {
    static int N = 0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        DFS(2,1);
        DFS(3,1);
        DFS(5,1);
        DFS(7,1);

        bw.write(sb.toString()+"\n");
        bw.close();
    }

    private static void DFS(int num, int step){
        if(step == N){
            if(isPrime(num)){
                sb.append(num+"\n");
                return ;
            }
        }
        for(int i=1; i<=9; i+=2){
            int next = num * 10 + i;
            if (isPrime(next)) {
                DFS(next, step + 1);
            }
        }

    }

    private static boolean isPrime(int num){
        if(num < 2)
            return false;
        if(num == 2)
            return true;
        if(num != 2 && num%2 == 0){
            return false;
        }
        for(int i=3; i<=(int)Math.sqrt(num); i++){
            if(num%i == 0)
                return false;
        }
        return true;
    }
}
