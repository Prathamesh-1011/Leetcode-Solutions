# Write your MySQL query statement below

with c1 as (

select distinct reports_to  , count(employee_id) over ( partition by reports_to ) as count,
round(avg(age) over ( partition by reports_to ),0) as average_age 

from employees)

select employee_id  ,name , count as reports_count , average_age
from employees b right join c1 a on b.employee_id  =a.reports_to 
where  a.reports_to is not null  