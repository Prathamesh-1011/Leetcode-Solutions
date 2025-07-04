# Write your MySQL query statement below
with cte as (
  SELECT 
    product_id,
    new_price,
    ROW_NUMBER() OVER (
      PARTITION BY product_id 
      ORDER BY change_date DESC
    ) AS rn
  FROM Products
  WHERE change_date <= '2019-08-16'
)
select P.product_id, COALESCE(C.new_price,10) as Price from (select distinct product_id  from Products ) P
left join cte C
on P.product_id  = C.product_id and C.rn = 1