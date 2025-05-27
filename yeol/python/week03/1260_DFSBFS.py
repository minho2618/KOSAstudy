import sys
from collections import deque
input = sys.stdin.readline


n,m,start = map(int,input().split())
graph = [[] for _ in range(n+1)]
for _ in range(m) :
    u,v = map(int,input().split())
    graph[u].append(v)
    graph[v].append(u)



def dfs(v) :
    visited[v] = True
    print(v+ ' ')
    for i in graph[v] :
        if graph[v] not in visited : 
            dfs(i)

visited = [False] * (n+1)
dfs(start)

def bfs(v) :
    queue = deque()
    queue.add(v)
    visited_q[v] = True 
    while queue : 
        now = queue.popleft()
        print(now + ' ') 
        for i in graph[now] :
            if i not in visited_q :
                queue.append(i)
visited_q= [False] *(n+1)
bfs(start)