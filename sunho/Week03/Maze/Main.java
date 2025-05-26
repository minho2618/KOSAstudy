package sunho.Week03.Maze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
		BFS(map, n, m);
	}
	static void BFS(int[][] map, int n, int m) {
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		boolean[][] visited = new boolean[n][m];
		Queue<Player> queue = new LinkedList<Player>();
		queue.offer(new Player(0, 0, 1));
		visited[0][0] = true;
		while (!queue.isEmpty()) {
			Player cur = queue.poll();
			if (cur.x == n - 1 && cur.y == m - 1) {
				System.out.println(cur.count);
				return ;
			}
			for (int i=0;i<4;i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (map[nx][ny] == 1 && !visited[nx][ny]) {
                        queue.offer(new Player(nx, ny, cur.count + 1));
                        visited[nx][ny] = true;
                    }
                }
			}
		}
	}
}

class Player {
	Player(int x, int y, int count) {
		this.x = x;
		this.y = y;
		this.count = count;
	}
	int x;
	int y;
	int count;
}
