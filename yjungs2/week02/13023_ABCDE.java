package yjungs2.week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

//BOJ 13023 ABCDE
class BOJ13023 {
	static ArrayList<Integer>[] gp;
	static boolean[] visited;
	static boolean findFlag; // false 가 default 값
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" ");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);
		
		// gp 와 visited 세팅
		gp = new ArrayList[n];
		visited = new boolean[n];
		for(int i=0; i<n; i++) {
			gp[i] = new ArrayList<Integer>();
			visited[i] = false;
		}
		// gp에 친구 관계 저장
		for(int i=0; i<m; i++) {
			String[] ab = br.readLine().split(" ");
			int a = Integer.parseInt(ab[0]);
			int b = Integer.parseInt(ab[1]);
			gp[a].add(b);
			gp[b].add(a);
		}
		
		for(int i=0; i<n; i++) { // 모든 시작점에서 DFS를 돌린다
			if(!findFlag) // 아직 조건에 맞는 친구 관계를 찾지 못했으면 탐색
				DFS(i, 1);
		}
		System.out.println(findFlag?1:0); // 주어진 관계가 존재하면 1, 아니면 0 출력
	} // main
	
	// DFS
	static void DFS(int n, int depth) { // depth = 친구 수
		if(depth==5) { // depth 가 5가 되면 dfs 종료
			findFlag = true;
			return;
		}
		visited[n] = true;
		for(int i : gp[n]) {
			if(!visited[i])
				DFS(i, depth+1);
		}
		visited[n] = false; // 재귀 호출이 끝난 시점에서 방문 여부 false로 변경
	}
}