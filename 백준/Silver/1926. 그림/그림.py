import sys
from collections import deque

#sys.stdin = open("input.txt")


n, m = map(int, input().split())

martix = []
check = [[0] * m for i in range(n)]

for i in range(n):
    martix.append(list(map(int, input().split())))

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
dq = deque()
res = -100000
count = 0
for i in range(n):
    for j in range(m):
        if martix[i][j] == 1:
            count += 1
            start = [i, j]
            martix[i][j] = 0
            dq.append(start)
            tmp = 1

            while dq:
                now = dq.popleft()
                for k in range(4):
                    next_x = now[0] + dx[k]
                    next_y = now[1] + dy[k]
                    if next_x < 0 or next_x >= n or next_y < 0 or next_y >= m:
                        continue
                    if martix[next_x][next_y] == 1:
                        tmp += 1
                        martix[next_x][next_y] = 0
                        dq.append([next_x, next_y])
            if tmp > res:
                res = tmp

if count != 0:
    print(count)
    print(res)
else:
    print(0)
    print(0)
