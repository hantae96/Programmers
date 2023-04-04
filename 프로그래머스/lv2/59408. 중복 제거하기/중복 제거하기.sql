-- 코드를 입력하세요
SELECT count(name) count from (select name from animal_ins group by name)a 

