SELECT case when count(*) = 1 then 'true'
       else 'false'
       end as result
FROM member_tbl WHERE id='testId';