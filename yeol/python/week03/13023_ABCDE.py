import sys
n,m= map(int, input().split())  # 첫 줄: 정점 수 N, 간선 수 M
A = [list(map(int, input().split())) for _ in range(M)]

# dfs 탐색
def dfs(v, depth):

    # 친구 관계가 존재한다면 1출력 후 종료
    if depth == 4:
        print(1)
        exit()

    # 반복문을 통해 친구 관계 확인
    for j in graph[v]:
        # 탐색하지 않은 친구라면
        if not visited[j]:
            visited[j] = True
            dfs(j, depth + 1) # 백 트래킹을 통해 깊이 확인
            visited[j] = False

graph = [[] for _ in range(n+1)]
for u,v in A:
  graph[u].append(v)
  graph[v].append(u)

count = 0 # 연결 노드의 수
visited = [False] * (n+1)
count = -1
# 반복문을 통해 각 친구들의 친구관계를 확인
for i in range(1,n+1):
    visited[i] = True
    dfs(i, 1)
    visited[i] = False


print(count)