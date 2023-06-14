import sys
from collections import defaultdict

#sys.stdin = open("input.txt")

n = int(input())

i = 1
arr = []
while i < n:
    tmp = 0
    j = i
    while j > 0:
        tmp += j % 10
        j = j // 10
    tmp += i

    if tmp == n:
        arr.append(i)
    i += 1

if len(arr) != 0:
    print(min(arr))
else:
    print(0)
