// https://www.acmicpc.net/problem/1715

package minho.week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon1715 {
    static PriorityQueue<Integer> queue = null;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        queue = new PriorityQueue<Integer>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            queue.add(Integer.parseInt(st.nextToken()));
        }

        int sum = 0;

        if (queue.size() == 1) {
            System.out.println(0);
            return;
        }

        while (queue.size() != 1) {
            int data1 = queue.remove();
            int data2 = queue.remove();
            int tmp = data1 + data2;
            sum += tmp;
            queue.add(tmp);
        }

        System.out.println(sum);
    }
}
