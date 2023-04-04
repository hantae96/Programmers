select substr(price,1,1) * 10000 price_group, count(*) as products from product
group by substr(price,1,1) * 10000
order by substr(price,1,1) * 10000 asc;