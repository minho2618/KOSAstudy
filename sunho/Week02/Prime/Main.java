package sunho.Week02.Prime;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		DFS(2, 1, n);
		DFS(3, 1, n);
		DFS(5, 1, n);
		DFS(7, 1, n);
		bw.flush();
		bw.close();
	}
	
	public static void DFS(int num, int exp, int n) throws IOException {
		if (exp == n) {
			if (isPrime(num))
				bw.write(Integer.toString(num));
				bw.newLine();
			return ;
		}
		for (int i=1;i<10;i++) {
			if (i % 2 == 0)
				continue;
			if (isPrime(num * 10 + i))
				DFS(num * 10 + i, exp + 1, n);
		}
	}
	
	public static boolean isPrime(int num) {
		for (int i=2;i*i<=num; i++)
			if (num % i ==0)
				return false;
		return true;
	}
}
