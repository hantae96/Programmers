import sys

#sys.stdin = open("input.txt")

n = int(input())
arr = [int(input()) for _ in range(n)]

dp = [1, 2, 4]

for i in range(3, 11):
    dp.append(dp[i - 3] + dp[i - 2] + dp[i - 1])

for i in arr:
    print(dp[i - 1])
