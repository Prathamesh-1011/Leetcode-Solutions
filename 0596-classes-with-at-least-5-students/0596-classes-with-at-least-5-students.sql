# Write your MySQL query statement below
select class from courses
group by class
having count(class) > 5 or count(class) = 5;