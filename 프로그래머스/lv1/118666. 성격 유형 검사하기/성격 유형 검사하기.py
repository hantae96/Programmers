def solution(survey, choices):
    answer = ''
    score_table = [3,2,1,0,1,2,3]
    test_table = ["RT","CF","JM","AN"]
    personality = {"A":0,"N":0,"C":0,"F":0,"M":0,"J":0,"R":0,"T":0}

    for exam in zip(survey,choices):
        test = exam[0]
        choice=exam[1]

        if choice > 4 :
            personality[test[1]] += score_table[choice-1]
        elif choice <4:
            personality[test[0]] += score_table[choice-1]

    # 점수 까진 다 구했고
    # survey 별로 이제 큰 수를 하나 씩골라서 하나의 문자열로 만들면됨
    # 반복문 순회하면서 survey 를 하나씩 두 변수에 담고 큰 값을 answer에 넣으면 될듯
    # 근데 사전순이니까 일단 정렬하고! 그담에 순회하자
    print(personality)
    key_set = list(personality.keys())

    for test in test_table:
        if personality[test[0]] > personality[test[1]]:
            answer = answer + test[0]
        elif personality[test[0]] < personality[test[1]]:
            answer = answer + test[1]
        else:
            tmp = [test[0],test[1]]
            tmp.sort()
            answer = answer + tmp[0]

    
    return answer
