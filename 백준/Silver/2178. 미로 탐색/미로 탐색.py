import sys
from collections import deque

#sys.stdin = open("input.txt")


def bfs():
    dq = deque()
    dq.append([0, 0])

    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    while dq:
        x, y = dq.popleft()
        for i in range(4):
            next_x = x + dx[i]
            next_y = y + dy[i]
            if -1 < next_x < n and -1 < next_y < m and martix[next_x][next_y] == 1:
                martix[next_x][next_y] = martix[x][y] + 1
                dq.append([next_x, next_y])

    return martix[n - 1][m - 1]


n, m = map(int, input().split())

martix = []
for i in range(n):
    martix.append(list(map(int, input())))

print(bfs())
