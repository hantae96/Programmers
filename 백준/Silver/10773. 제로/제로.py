n = int(input())

tmp = []
for i in range(n):
    tmp.append(int(input()))

stack = []
for i in tmp:
    if i != 0:
        stack.append(i)
    else:
        stack.pop()

print(sum(stack))
