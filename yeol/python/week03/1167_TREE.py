import sys
from collections import deque
input = sys.stdin.readline


N = int(input())
A = [[] for _ in range(N+1)]
for _ in range(N):
    data = list(map(int, input().split()))
    node = data[0]
    # -1 이전까지의 데이터를 한 번에 처리
    i = 1
    while i < len(data) - 1 and data[i] != -1:
        A[node].append((data[i], data[i+1]))
        i += 2

def BFS(start):
    queue = deque()
    queue.append(start)
    visited = [False] * (N + 1)
    visited[start] = True
    distance = [0] * (N + 1)

    while queue:
        current = queue.popleft()
        for neighbor, weight in A[current]:
            if not visited[neighbor]:
                visited[neighbor] = True
                distance[neighbor] = distance[current] + weight
                queue.append(neighbor)
    
    max_dist = max(distance)
    max_node = distance.index(max_dist)
    return max_node, max_dist


# 첫 번째 BFS: 아무 노드이지만, 노드 1은 항상 포함되어 있으니까 1부터 시작하자”
max_node, _ = BFS(1)

# 두 번째 BFS: 가장 먼 노드에서 시작해서 나오는 최대 거리 = 지름
_, max_dist = BFS(max_node)

print(max_dist)
# 이 문제가 트리구조라는 점을 가만하여, 트리 구조는 사이클이 없다.

# 아래는 시작노드가 어디서부터인지 모르니까 한번에 지름 노드를 구하려고 했다. 
# 모든 지점을 다 찾다보면 가장 먼 지점으로부터 가장 먼 지점까지를 찾을 수 있을테니까 => BFS
'''
imax = -1
for i in range(1, N + 1):
    distance = [0] * (N + 1)
    BFS(i, distance)
    imax = max(imax, max(distance))

print(imax)

'''
