# Write your MySQL query statement below
SELECT DISTINCT s.tweet_id
FROM Tweets s
WHERE LENGTH(s.content) > 15;