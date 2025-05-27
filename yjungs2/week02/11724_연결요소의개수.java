package yjungs2.week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// BOJ 11724 연결 요소의 개수 구하기
class BOJ11724 {
	static ArrayList<Integer>[] gp; // ArrayList를 담은 배열
	static Boolean[] visited; // 방문 여부 저장
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" ");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);

		gp = new ArrayList[n+1];
		visited = new Boolean[n+1];
		for(int i=0; i<n+1; i++) { // gp와 visited 세팅
			gp[i] = new ArrayList<Integer>();
			visited[i] = false;
		}

		for(int i=0; i<m; i++) { // 간선 개수 m 만큼 간선 연결하기
			String[] se = br.readLine().split(" ");
			int s = Integer.parseInt(se[0]);
			int e = Integer.parseInt(se[1]);
			gp[s].add(e);
			gp[e].add(s);
		}
		
		int count = 0;
		for(int i=1; i<n+1; i++) {
			if(!visited[i]) { // 방문하지 않았다면
				count++; // 연결 요소 개수 +1
				DFS(i);
			}
		}
		System.out.println(count);
	} // main
	
	private static void DFS(int i) {
		if(visited[i]) // 방문한 곳이라면
			return; // 메소드를 실행하지 않고 종료
		visited[i] = true; // 방문 처리
		for(int j:gp[i]) { // 연결된 간선을 돌면서
			if(!visited[j]) // 방문하지 않았다면
				DFS(j); // 재귀
		}
	} // dfs
}