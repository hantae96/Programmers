import datetime as dt

def datetoday(date):
    year,month,day = map(int,date.split("."))
    # 날짜를 일로 변환한다.
    return (year*12*28) + (month*28) + day
    

def solution(today, terms, privacies):
    answer = []
    today = datetoday(today)


    # 약관 테이블 생성
    terms_table = {}
    for term in terms:
        key,value = term.split()
        # 월단위로 넣지말고 일단위(28)로 추가
        terms_table[key] = int(value)*28
        
    for idx,privacy in enumerate(privacies):
        date,term = privacy.split()
        # 날짜를 일로 변환한다.
        end_day = datetoday(date) + terms_table[term]
        
        if end_day <= today:
            answer.append(idx+1)

    return answer

today = "2022.05.19"
terms = ["A 6", "B 12", "C 3"]
privacies = ["2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"]
print(solution(today,terms,privacies))