package minho.week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 강의의 수
        int m = Integer.parseInt(st.nextToken()); // 블루레이 갯수

        String str = br.readLine();
        st = new StringTokenizer(str);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            //System.out.println(arr[i]);
        }

        // m개로 나눌 수 있는 최소값 구하기
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
            //System.out.println(totalSum);
        }

        int tgtNum = totalSum / m;
        boolean isDone = false;
        while (!isDone) {
            //System.out.println(tgtNum);
            int i = 0;
            int j = 1; // 현재까지 저장한 CD 갯수
            int sum = 0;
            //System.out.println(m);
            while (j <= m) {
                //System.out.print(i);
                if (i >= n) {
                    //System.out.println("Break");
                    break;
                }

                //System.out.println(sum + arr[i]);
                if (sum + arr[i] > tgtNum) {
                    j += 1;
                    sum = 0;
                    //System.out.println("Continue");
                    continue;
                }

                sum += arr[i];
                i += 1;

                //System.out.println("j: " + j);
            }

            //System.out.println(tgtNum + " " + i);

            if (i >= n) {
                isDone = true; // 결과 나온 경우
            } else {
                tgtNum += 1;
            }
        }

        System.out.println(tgtNum);
    }
}
