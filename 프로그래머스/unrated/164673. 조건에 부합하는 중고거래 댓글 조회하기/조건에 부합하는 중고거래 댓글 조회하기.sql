-- 코드를 입력하세요
SELECT b.title,b.board_id,r.reply_id,r.writer_id,r.contents,
TO_CHAR(r.created_date ,'yyyy-mm-dd') as created_date 
from USED_GOODS_BOARD b inner join USED_GOODS_REPLY r 
on b.board_id = r.board_id 
WHERE TO_CHAR(b.created_date,'yyyy-mm') ='2022-10'
order by r.created_date,b.title;
