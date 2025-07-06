# Write your MySQL query statement below
select
    id,
    IF(MOD(id, 2) = 1, lead(student, 1, student) over(), lag(student) over()) as "student"
from Seat;