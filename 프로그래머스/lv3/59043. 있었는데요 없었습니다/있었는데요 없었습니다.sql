-- 코드를 입력하세요
SELECT i.ANIMAL_ID,i.name from ANIMAL_INS i inner join ANIMAL_OUTS o on i.ANIMAL_ID = o.ANIMAL_ID
where i.datetime > o.datetime
order by i.datetime asc;