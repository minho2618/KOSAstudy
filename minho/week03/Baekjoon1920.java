package minho.week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon1920 {
    static List<Integer> list = null;
    static List<Integer> search = null;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        //list.stream().forEach((i) -> System.out.println(i));

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        search = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            search.add(Integer.parseInt(st.nextToken()));
        }

        list.sort((n1, n2) -> n1 - n2);

        for (int i = 0; i < m; i++) {
            int index = n / 2;
            while(true) {
                if (list.get(index).intValue() == search.get(i).intValue()) {
                    System.out.println("1");
                    break;
                } else {
                    if (list.get(index) > search.get(i)) {
                        if (index / 2 == index) {
                            System.out.println("0");
                            break;
                        }
                        index = index / 2;
                    } else if (list.get(index) < search.get(i)) {
                        if ((list.size() + index + 1) / 2 == index) {
                            System.out.println("0");
                            break;
                        }
                        index = (list.size() + index) / 2;
                    }
                }
            }
        }


    }
}
