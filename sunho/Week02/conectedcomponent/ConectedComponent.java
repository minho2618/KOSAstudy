package sunho.Week02.conectedcomponent;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ConectedComponent {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] lists = new ArrayList[n + 1];
		boolean[] visited = new boolean[n + 1];
		for (int i=1;i<n+1;i++) 
			lists[i] = new ArrayList<Integer>();
		for (int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			lists[u].add(v);
			lists[v].add(u);
		}
		int count = 0;
		for (int i=1;i<n + 1;i++) {
			if (!visited[i]) {
				count++;
				DFS(i, lists, visited);
			}
		}
		bw.write(Integer.toString(count));
		bw.flush();
		bw.close();
	}
	
	public static void DFS(int v, ArrayList<Integer>[] lists, boolean[] visited) {
		if (visited[v]) return ;
		visited[v] = true;
		for (int i : lists[v]) DFS(i, lists, visited);
	}
}