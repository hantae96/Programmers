-- 코드를 입력하세요
SELECT pt_name,pt_no,gend_cd,age,NVL(tlno,'NONE') as TLNO
from patient
where age < 13 and GEND_CD = 'W'
order by age desc,pt_name asc;