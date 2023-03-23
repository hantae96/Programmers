import sys

sys.stdin = open("CodingTest/이코테/Chapter_3/input.txt")
n = int(input())
control = list(input().split())

control_map = {"L":[0,-1],"R":[0,1],"U":[-1,0],"D":[1,0]}

now = [0,0]

for idx,move in enumerate(control):
    next = [i+j for i,j in zip(now,control_map.get(move))]
    if (-1<next[0]<n) and (-1<next[1]<n):
        now = next
        
now = [i+1 for i in now]
print(now)  