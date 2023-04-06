-- 코드를 입력하세요
SELECT book_id,TO_CHAR(PUBLISHED_DATE,'YYYY-MM-DD') from BOOK where CATEGORY = '인문' and to_char(PUBLISHED_DATE,'YYYY') = '2021'
order by PUBLISHED_DATE asc;