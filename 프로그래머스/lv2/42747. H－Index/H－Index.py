def solution(citations):
    answer = 0
    
    citations = sorted(citations)

    for i in range(len(citations)):
        if len(citations) -i <= citations[i]:
            return len(citations) -i
    return 0