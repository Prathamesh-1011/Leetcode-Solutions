# Write your MySQL query statement below
with a as (select requester_id from RequestAccepted 
union all select accepter_id from RequestAccepted )

select requester_id as id, count(*) as num from a group by requester_id
order by num desc
limit 1