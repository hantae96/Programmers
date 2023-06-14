import sys
from collections import defaultdict

#sys.stdin = open("input.txt")

n = int(input())

arr1 = list(map(int, input().split()))
arr2 = sorted(arr1[::])
answer = []
dict = defaultdict(int)

idx = 0
for i in range(len(arr2)):
    if arr2[i] not in dict.keys():
        dict[arr2[i]] = idx
        idx += 1

for i in arr1:
    print(dict[i], end=" ")
