import sys
from collections import deque

#sys.stdin = open("input.txt")

v = int(input())
# 네트워크 쌍 개수
e = int(input())
graph = [[] for _ in range(v + 1)]
for _ in range(e):
    a, b = map(int, input().split())
    # 연결된 컴퓨터의 정보가 언제가 1부터 등장한다는 보장 x
    graph[a].append(b)
    graph[b].append(a)

visited = [0] * (v + 1)

### BFS
dq = deque()
dq.append(1)
visited[1] = 1


while dq:
    node = dq.popleft()

    for i in graph[node]:
        if visited[i] == 0:
            visited[i] = 1
            dq.append(i)

print(sum(visited) - 1)
