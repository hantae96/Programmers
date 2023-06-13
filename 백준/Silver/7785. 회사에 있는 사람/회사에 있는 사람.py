import sys
from collections import defaultdict

#sys.stdin = open("input.txt")


n = int(input())

check = defaultdict(int)
for _ in range(n):
    name, c = input().split()
    if c == "enter":
        check[name] = 1
    else:
        check[name] = 0


answer = []
for i in check:
    if check[i] == 1:
        answer.append(i)

answer = sorted(answer, reverse=True)
for i in answer:
    print(i)
