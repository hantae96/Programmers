import sys
from collections import deque

#sys.stdin = open("input.txt")


def bfs(x, y):
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    dq = deque()
    dq.append((x, y))

    while dq:
        x, y = dq.popleft()
        matrix[x][y] = 0

        for i in range(4):
            n_x = x + dx[i]
            n_y = y + dy[i]
            if -1 < n_x < M and -1 < n_y < N and matrix[n_x][n_y] == 1:
                matrix[n_x][n_y] = 0
                dq.append((n_x, n_y))


T = int(input())


# 행렬만들기
for i in range(T):
    M, N, K = map(int, input().split())
    matrix = [[0] * (N) for _ in range(M)]
    cnt = 0

    for j in range(K):
        x, y = map(int, input().split())
        matrix[x][y] = 1

    for a in range(M):
        for b in range(N):
            if matrix[a][b] == 1:
                bfs(a, b)
                cnt += 1

    print(cnt)
