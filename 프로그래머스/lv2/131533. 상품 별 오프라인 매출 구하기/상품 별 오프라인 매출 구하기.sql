-- 코드를 입력하세요
SELECT p.PRODUCT_CODE, sum(p.price*sales_amount)as sales From PRODUCT p inner join OFFLINE_SALE o on p.PRODUCT_ID = o.PRODUCT_ID
group by p.PRODUCT_CODE
order by sales desc,PRODUCT_CODE asc;