def solution(n):
    answer = 0
    
    n_count = str(bin(n)[2:]).count("1")
    i = 1
    while True:
        next_num = n+i
        if str(bin(next_num)[2:]).count("1") == n_count:
            return next_num
        else:
            i+=1