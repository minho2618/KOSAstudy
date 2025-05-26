package sunho.Week03.FindSu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0;i<n;i++) {
			int m = Integer.parseInt(st.nextToken());
			map.put(m, m);
		}
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<n;i++) {
			int m = Integer.parseInt(st.nextToken());
			if (map.containsKey(m))
				System.out.println(1);
			else
				System.out.println(0);
		}
	}
}
