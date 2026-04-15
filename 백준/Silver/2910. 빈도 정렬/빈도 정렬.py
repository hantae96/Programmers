

n, c = map(int,input().split())

arr = list(map(int,input().split()))


dict = {}

for i,v in enumerate(arr):
  if v not in dict:
    dict[v] = [i,1]
  else:
    dict[v] = [dict[v][0],dict[v][1]+1]


sorted_arr = sorted(arr, key = lambda x : (-dict[x][1] , dict[x][0]))


for i,v in enumerate(sorted_arr):
  print(v,end=" ")