-- 코드를 입력하세요
SELECT u.user_id,u.nickname,sum(b.price) total_sales from USED_GOODS_BOARD b inner join USED_GOODS_USER u on b.writer_id = u.user_id
where b.status = 'DONE'
GROUP BY u.user_id,u.nickname
having sum(b.price) >= 700000
order by total_sales asc;