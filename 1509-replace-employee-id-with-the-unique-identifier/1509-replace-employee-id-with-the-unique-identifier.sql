# Write your MySQL query statement below
select EmployeeUNI.unique_id, Employees.name
from Employees
left JOIN EmployeeUNI
on EmployeeUNI.id=Employees.id