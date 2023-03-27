import datetime as dt

def solution(today, terms, privacies):
    answer = []
    today = dt.datetime.strptime(today,"%Y.%m.%d")

    # 약관 테이블 생성
    terms_table = {}
    for term in terms:
        key,value = term.split()
        # 월단위로 넣지말고 일단위(28)로 추가
        terms_table[key] = int(value)*28

    for idx,privacy in enumerate(privacies):
        date,term = privacy.split()
        year,month,day = map(int,date.split("."))
        
        day += terms_table[term]
        if (day > 28):
            month += day//28
            day = day % 28
            if(day == 0): day = 1
        if (month > 12):
            year += month//12
            month = month % 12
            if (month == 0): month = 1


        end_day = dt.datetime(year,month,day) - dt.timedelta(days=1)
        # end_day = dt.datetime(year,month,day)
        if end_day < today:
            answer.append(idx+1)

    return answer



today = "2022.02.28"
terms =  ["A 12"]	
privacies = ["2019.12.01 A"]
print(solution(today,terms,privacies))