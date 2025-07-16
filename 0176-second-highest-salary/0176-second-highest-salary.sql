# Write your MySQL query statement below
SELECT (
    SELECT DISTINCT SALARY 
    FROM EMPLOYEE 
    ORDER BY SALARY DESC 
    LIMIT  1 ,1
) AS SecondHighestSalary;