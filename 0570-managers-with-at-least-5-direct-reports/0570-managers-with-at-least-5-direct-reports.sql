# Write your MySQL query statement below
SELECT name
FROM Employee e1
INNER JOIN (SELECT managerId, count(*) AS countMng
            FROM Employee
            GROUP BY ManagerId
            Having count(*) >= 5) e2
ON e1.id = e2.managerId