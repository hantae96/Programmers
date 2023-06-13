import sys
from collections import defaultdict

#sys.stdin = open("input.txt")


n = int(input())
arr1 = list(map(int, input().split()))
m = int(input())
arr2 = list(map(int, input().split()))

check = defaultdict(int)

for i in arr1:
    check[i] = 0

for j in arr2:
    if j in check.keys():
        check[j] = 1

for i in arr2:
    if check[i] == 1:
        print(1, end=" ")
    else:
        print(0, end=" ")
