import sys

n, k = map(int, input().split())
arr = []

for _ in range(n):
    arr.append(int(input()))

idx = n - 1
money = 0
answer = 0

while k > 0:
    while arr[idx] > k:
        idx -= 1
    tmp = arr[idx]

    i = 1

    count = k // tmp
    answer += count
    tmp = tmp * count
    k = k % tmp

print(answer)
