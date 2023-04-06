SELECT b.category, sum(s.sales) as total_sales 
FROM book b 
INNER JOIN book_sales s ON b.book_id = s.book_id
WHERE TO_CHAR(s.sales_date,'YYYY-MM') = '2022-01'
GROUP BY b.category
ORDER BY b.category ASC;