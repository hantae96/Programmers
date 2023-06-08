import sys
n = int(input())
arr = sorted(list(map(int, input().split())))

answer = 0

for i in range(1, n + 1):
    answer += sum(arr[:i])

print(answer)
