-- 코드를 입력하세요
select count(name) as count from(
select name,count(name) from ANIMAL_INS group by name);