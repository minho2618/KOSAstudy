import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

n, m = map(int, input().split())  # 정점 수 N, 간선 수 M
A = [list(map(int, input().split())) for _ in range(m)]  

# dfs 함수
def dfs(graph, v, visited):
    visited[v] = True
    for i in graph[v]:
        if not visited[i]:
            dfs(graph, i, visited)

graph = [[] for _ in range(n+1)]
for u, v in A:
    graph[u].append(v)
    graph[v].append(u)

visited = [False] * (n+1)
count = 0
for i in range(1, n+1):
    if not visited[i]:
        dfs(graph, i, visited)
        count += 1

print(count)