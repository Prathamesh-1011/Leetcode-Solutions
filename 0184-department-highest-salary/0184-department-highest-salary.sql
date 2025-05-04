# Write your MySQL query statement below
select d.name as Department  , e.name as Employee , e.salary as Salary 
from department  d, 
employee e where e.departmentid = d.id and (e.departmentid , e.salary) in (
    select departmentid, max(salary) as salary  from employee  
    group by departmentid 
) 