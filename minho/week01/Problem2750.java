package minho.week01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Problem2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(br.readLine());

        // String name = st.nextToken();
        // int age = Integer.parseInt(st.nextToken());
        ArrayList<Integer> list = new ArrayList<>();


        for (int i = 0; i < num; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer n1, Integer n2) {
                return n1 - n2;
            }
        });

        for (int n : list) System.out.println(n);
    }
}