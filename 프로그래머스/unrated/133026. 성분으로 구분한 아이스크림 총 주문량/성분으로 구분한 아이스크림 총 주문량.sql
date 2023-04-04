-- 코드를 입력하세요
SELECT i.INGREDIENT_TYPE, sum(total_order) as total_order from FIRST_HALF f inner join ICECREAM_INFO i on f.flavor = i.flavor
group by INGREDIENT_TYPE;