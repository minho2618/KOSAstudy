package sunho.Week02.ABCDE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ABCDE {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] lists = new ArrayList[n];
		boolean[] visited = new boolean[n];
		boolean is = false;
		for (int i=0;i<n;i++) {
			lists[i] = new ArrayList<Integer>();
		}
		for (int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			lists[u].add(v);
			lists[v].add(u);
		}
		for (int i=0;i<n;i++) {
			for (int y=0;y<n;y++)
				visited[y] = false;
			if ((is = DFS(i, 0, lists, visited)) == true)
				break;
		}
		if (is == true)
			bw.write(Integer.toString(1));
		else
			bw.write(Integer.toString(0));
		bw.flush();
		bw.close();
	}
	
	static boolean DFS(int v, int count, ArrayList<Integer>[] lists, boolean[] visited) throws IOException {
		if (visited[v])
			return false;
		visited[v] = true;
		count++;
		if (count == 5) {
			return true;
		}
		for (int i : lists[v]) {
			if (DFS(i, count, lists, visited) == true)
				return true;
		}
		visited[v] = false;
		return false;
	}
}