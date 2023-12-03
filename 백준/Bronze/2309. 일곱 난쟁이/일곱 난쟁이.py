import sys
from itertools import combinations,permutations;
input = sys.stdin.readline
#sys.stdin = open("input.txt","r")

lst = []
for _ in range(9):
    lst.append(int(input()))

combi = combinations(lst,7)
for i in combi:
    if sum(i) == 100:
        for j in sorted(i):
            print(j)
        break