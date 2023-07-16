# Write your MySQL query statement below
select max(salary) SecondHighestSalary from Employee where salary not in (select max(salary) from Employee);
