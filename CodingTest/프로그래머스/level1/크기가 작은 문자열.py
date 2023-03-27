def solution(t, p):
    answer = 0
    
    length = len(p)
    numbers = []
    
    for i in range(len(t)-length+1):
        print(i)
        tmp = str(t[i:i+length]) 
        numbers.append(tmp)
        
    print(numbers)
    
    return answer


t = "500220839878"
p = "7"	
print(solution(t,p))
