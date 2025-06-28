# Write your MySQL query statement below
WITH delivery_base AS
(SELECT delivery_id
,customer_id
,order_date
,customer_pref_delivery_date
,RANK() OVER (PARTITION BY customer_id ORDER BY order_date ASC) AS rnk
FROM delivery)

,delivery_cnt AS
(SELECT COUNT(CASE WHEN rnk = 1 AND order_date = customer_pref_delivery_date THEN customer_id END) AS immediate_cnt 
,COUNT(CASE WHEN rnk = 1 THEN customer_id END) AS scheduled_cnt
FROM delivery_base)

SELECT ROUND((immediate_cnt/scheduled_cnt)*100,2) AS immediate_percentage FROM delivery_cnt