package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String nStr = br.readLine();
        ArrayList<Integer> digits = new ArrayList<>();
        for (int i = 0; i < nStr.length(); i++) {
            digits.add(Integer.parseInt(String.valueOf(nStr.charAt(i))));
        }
        Collections.sort(digits, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (int digit : digits) {
            sb.append(digit);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}