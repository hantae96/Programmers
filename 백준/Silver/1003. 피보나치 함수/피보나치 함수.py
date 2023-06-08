import sys

#sys.stdin = open("input.txt")


def fibo(n):
    zero = [1, 0]
    one = [0, 1]

    length = len(zero)
    if n >= length:
        for i in range(length, n + 1):
            zero.append(zero[i - 1] + zero[i - 2])
            one.append(one[i - 1] + one[i - 2])

    print(f"{zero[n]} {one[n]}")


T = int(input())

for _ in range(T):
    n = int(input())
    fibo(n)
