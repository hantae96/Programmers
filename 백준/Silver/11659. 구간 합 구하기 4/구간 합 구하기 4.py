import sys
input = sys.stdin.readline
# sys.stdin = open("input.txt","r")


n,m = map(int,input().split())
lst = list(map(int,input().split()))
sum_list = [lst[0]]
for i in range(1,len(lst)):
    sum_list.append(sum_list[i-1] + lst[i])


for i in range(m):
    s,e = [int(x) -1 for x in input().split()]
    if (s == 0):
        print(sum_list[e])
    else:
        print(sum_list[e] - sum_list[s-1])

    