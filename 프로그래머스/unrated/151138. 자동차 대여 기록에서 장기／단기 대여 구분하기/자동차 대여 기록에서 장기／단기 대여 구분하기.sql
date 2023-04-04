select history_id, car_id,
    TO_CHAR(start_date,'YYYY-MM-DD') "START_DATE",
    TO_CHAR(end_date,'YYYY-MM-DD') "END_DATE",
case when end_date - start_date +1 >= 30 then '장기 대여'
else '단기 대여' end as "RENT_TYPE"
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE TO_CHAR(start_date,'YYYY-MM') = '2022-09'
order by 1 desc;