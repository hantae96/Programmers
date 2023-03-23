def solution(s, skip, index):
    answer = ''
    skip_table = [ord(i) for i in skip]
    
    # 한칸씩 옮겨야되니까 for 문 쓰면 안되고 
    # while 문을 통해서 하나씩 인덱스를 옮겨야함
    
    for char in s:
        i = index
        asc_char = ord(char)

        while i > 0:
            # 122 -> z 가 넘어가면 다시 a 로 변환
            if asc_char+1 > 122:
                asc_char = (asc_char)%122 + 96

            ## 아스키 코드를 1 더하고, 그 수가 122를 넘어갈수있기때문에 반드시 검사를 먼저 해줘야된다.
            if asc_char+1 not in skip_table:
                i-=1
            
            asc_char += 1

        if asc_char > 122:
            asc_char = (asc_char)%122 + 96

        answer = answer + chr(asc_char)
        
    return answer


s = "z"	
skip = "abcdefghijklmnopqrstuvwxy"
index = 1
print(solution(s,skip,index))