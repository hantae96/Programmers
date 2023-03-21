n,m,k = 5,8,3
array = [2,4,5,4,6]

array=sorted(array,reverse=True)
big = array[0]
little = array[1]

result = big*k*(m//k) + little*(m%k)
print(result)