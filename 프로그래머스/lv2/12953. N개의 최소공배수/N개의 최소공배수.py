import math

def lcm(a, b):
    return int(a * b / math.gcd(a, b))

def solution(arr):
    answer = 1
    
    for i in arr:
        answer = lcm(answer,i)
    
    return answer