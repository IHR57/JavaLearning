-- table; employee: id, name, manager_id
SELECT t1.name, t2.name AS manager_name FROM tbl_employee t1 INNER JOIN tbl_employee t2
WHERE t1.manager_id = t2.id;