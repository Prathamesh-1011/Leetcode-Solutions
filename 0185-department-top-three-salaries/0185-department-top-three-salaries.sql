# Write your MySQL query statement below
with cte1 as
(
select d.name as dname,e.name as ename,salary from Employee e
inner join Department d on
e.departmentId=d.id order by dname,salary desc
),cte2 as(
select * ,dense_rank() over(partition by dname order by salary desc) as rk from cte1)

select dname as Department,ename as Employee,salary as Salary from cte2 where rk<=3