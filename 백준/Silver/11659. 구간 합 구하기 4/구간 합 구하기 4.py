import sys

#sys.stdin = open("input.txt")
input = sys.stdin.readline

n, m = map(int, input().split())

arr = list(map(int, input().split()))

dp = [arr[0]]
for i in range(1, len(arr)):
    dp.append(dp[i - 1] + arr[i])

dp.insert(0, 0)

for _ in range(m):
    s, e = map(int, input().split())
    print(dp[e] - dp[s - 1])
