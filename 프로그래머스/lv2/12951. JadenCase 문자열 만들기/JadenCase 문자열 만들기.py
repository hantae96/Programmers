def solution(s):
    answer = ''
    
    words = list(s.split())
    for i in range(len(words)):
        if words[i][0].isalpha():
            tmp = ""
            tmp += words[i][0].upper()
            tmp += words[i][1:].lower()
            answer += tmp
        else:
            tmp = ""
            tmp += words[i][0]
            tmp += words[i][1:].lower()
            answer += tmp
        answer+= " "
    answer = answer.rstrip()
    return answer