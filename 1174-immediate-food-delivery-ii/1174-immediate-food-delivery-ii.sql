# Write your MySQL query statement below

select round(sum(case when order_date = customer_pref_delivery_date then 1 else 0 end)/count( customer_id)*100, 2) immediate_percentage from delivery
where (customer_id, order_date) in 
(
select customer_id, min(order_date) first_order from delivery
group by customer_id
)