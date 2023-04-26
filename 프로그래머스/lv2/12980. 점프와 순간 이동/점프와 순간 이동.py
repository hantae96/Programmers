def solution(n):
    # 반절 만큼 구하고, 거기에서 텔레포트 한번 뛰면 최소다.
    
    jump = 0
    
    while n > 0:
        jump += n % 2
        n = n//2
        
    return jump