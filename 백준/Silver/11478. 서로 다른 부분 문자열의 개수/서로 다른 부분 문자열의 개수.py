import sys
from itertools import combinations, permutations

#ys.stdin = open("input.txt")


string = input()
s = set()

end = 1
for i in range(len(string) + 1):
    for j in range(i + 1, len(string) + 1):
        s.add(string[i:j])

print(len(s))
