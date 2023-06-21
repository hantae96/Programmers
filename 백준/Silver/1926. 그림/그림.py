import sys
from collections import deque


def bfs(x, y):
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    dq = deque()

    matrix[x][y] = 0
    dq.append((x, y))
    cnt = 1

    while dq:
        (x, y) = dq.popleft()
        for i in range(4):
            n_x = x + dx[i]
            n_y = y + dy[i]
            if (-1 < n_x < n) and (-1 < n_y < m):
                if matrix[n_x][n_y] == 1:
                    matrix[n_x][n_y] = 0
                    dq.append((n_x, n_y))
                    cnt += 1

    return cnt


#sys.stdin = open("input.txt")
n, m = map(int, input().split())
matrix = [list(map(int, input().split())) for i in range(n)]

cnt = 0
size = []
for i in range(n):
    for j in range(m):
        if matrix[i][j] == 1:
            cnt += 1
            size.append(bfs(i, j))


if len(size) != 0:
    print(cnt)
    print(max(size))
else:
    print(0)
    print(0)
