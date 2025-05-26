package sunho.Week03.TreeDistance;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<List<Dot>> dots = new ArrayList<List<Dot>>();
		int n = Integer.parseInt(st.nextToken());
		for (int i=0;i<n;i++) dots.add(new ArrayList<Dot>());
		for (int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken()) - 1;
			while (true) {
				int nd = Integer.parseInt(st.nextToken()) - 1;
				if (nd == -2) {
					break ;
				}
				int dis = Integer.parseInt(st.nextToken());
				dots.get(idx).add(new Dot(nd, dis));
			}
		}
		System.out.println(BFS(BFS(1, dots).dotNum, dots).distance);
	}
	
	static Dot BFS(int start, List<List<Dot>> dots) {
		int n = dots.size();
		boolean[] visited = new boolean[n];
		Queue<Dot> queue = new LinkedList<Dot>();
		visited[start] = true;
		queue.offer(new Dot(start, 0));
		Dot maxDis = new Dot(start, 0);
		while (!queue.isEmpty()) {
			Dot cur = queue.poll();
			if (maxDis.distance < cur.distance)
				maxDis = cur;
			visited[cur.dotNum] = true;
			for (Dot next : dots.get(cur.dotNum)) {
                if (!visited[next.dotNum]) {
                    visited[next.dotNum] = true;
                    queue.offer(new Dot(next.dotNum, cur.distance + next.distance));
                }
            }
		}
		return maxDis;
	}
}

class Dot {
	public int dotNum;
	public int distance;
	Dot(int dotNum, int distance) {
		this.dotNum = dotNum;
		this.distance = distance;
	}
}