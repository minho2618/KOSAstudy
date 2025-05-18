package minho.week03;

// https://www.acmicpc.net/problem/2178

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon2178 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int column = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        List<List<Boolean>> boolGraph = new ArrayList<>();

        int depth = 0;

        for (int i = 0; i < row; i++) {
            boolGraph.add(new ArrayList<>());
            for (int j = 0; j < column; j++ ) {
                boolGraph.get(i).add(false);
            }
        }

        for (int i = 0; i < row; i++) {
            graph.add(new ArrayList<>());
            String str = br.readLine();
            for (int j = 0; j < column; j++) {
                char ch = str.charAt(j);
                int num = Integer.parseInt(String.valueOf(ch));
                graph.get(i).add(num);
            }
        }

        int dx = 0;
        int dy = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add();
        while (!queue.isEmpty()) {

        }


        System.out.println(queue.size());
    }
}
