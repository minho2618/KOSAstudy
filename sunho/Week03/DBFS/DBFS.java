package sunho.Week03.DBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DBFS {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		for (int i=0;i<n + 1;i++) {
			lists.add(new ArrayList<Integer>());
		}
		boolean[] dvisited = new boolean[lists.size()];
		for (int i=1;i<m + 1;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			lists.get(a).add(b);
			lists.get(b).add(a);
		}
		for (ArrayList l : lists)
			Collections.sort(l);
		DFS(v, lists, dvisited);
		System.out.println();
		BFS(v, lists);
	}
	
	static void BFS(int v, ArrayList<ArrayList<Integer>> lists) {
		boolean[] visited = new boolean[lists.size()];
		Queue<Integer> queue = new LinkedList<Integer>();
		visited[v] = true;
		queue.offer(v);
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			System.out.print(cur + " ");
			for (int next : lists.get(cur)) {
				if (visited[next] == false) {
					visited[next] = true;
					queue.offer(next);
				}
			}
		}
	}
	static void DFS(int v, ArrayList<ArrayList<Integer>> lists, boolean[] visited) {
		if (visited[v] == true) {
			return;
		}
		visited[v] = true;
		System.out.print(v + " ");
		for (int i : lists.get(v)) {
			DFS(i, lists, visited);
		}
	}
}