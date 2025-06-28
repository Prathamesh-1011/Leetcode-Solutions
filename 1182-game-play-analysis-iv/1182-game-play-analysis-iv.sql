# Write your MySQL query statement below
WITH first_login AS (
    SELECT player_id, MIN(event_date) AS first_date
    FROM Activity
    GROUP BY player_id
),
next_day_login AS (
    SELECT  count(a.player_id) as total_count
    FROM Activity a
    JOIN first_login f
      ON a.player_id = f.player_id
     AND DATEDIFF(a.event_date, f.first_date) = 1
)
select round(total_count/count(distinct player_id),2) as fraction   from Activity A,next_day_login N