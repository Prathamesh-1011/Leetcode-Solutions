# Write your MySQL query statement below
SELECT * FROM users
WHERE mail REGEXP '^[a-zA-Z][a-zA-Z0-9._-]*@leetcode\\.com$'
AND Binary RIGHT(mail, 4) = '.com';