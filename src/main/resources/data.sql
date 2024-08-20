
--INSERT STATUS ORDER
INSERT INTO TB_STATUS (code,description) VALUES ('BOK', 'Booked');
INSERT INTO TB_STATUS (code,description) VALUES ('PRO', 'In progress');
INSERT INTO TB_STATUS (code,description) VALUES ('COM', 'Completed');
INSERT INTO TB_STATUS (code,description) VALUES ('DEL', 'Deleted');

--INSERT ORDERS
INSERT INTO TB_ORDER (code, status_id, creation_date, deleted, deletion_date, modification_date, price) VALUES ( 'f8c3de3d-1fea-4d7c-a8b0-29f63c4c3454',1,'2024-08-20 10:30:00', FALSE, NULL, NULL,10.00);
INSERT INTO TB_ORDER (code, status_id, creation_date, deleted, deletion_date, modification_date, price) VALUES ( '018b2f19-e79e-7d6a-a56d-29feb6211b04',1,'2024-08-20 15:30:00', FALSE, NULL, NULL,30.00);


--INSERT PIZZAS
INSERT INTO TB_PIZZA (code,name,description,price) VALUES ('MAG', 'Margherita', 'Base rossa, con mozzarella, olive e basilico',7.00);
INSERT INTO TB_PIZZA (code,name,description,price) VALUES ('DIA', 'Diavola','Base rossa, con mozzarella e salame piccante',8.00);
INSERT INTO TB_PIZZA (code,name,description,price) VALUES ('CAP', 'Capricciosa','Base rossa, con mozzarella...',9.00);
INSERT INTO TB_PIZZA (code,name,description,price) VALUES ('NAP', 'Napoli','Base rossa, con mozzarella...',9.00);
INSERT INTO TB_PIZZA (code,name,description,price) VALUES ('EST', 'Estate', 'Base bianca, con mozzarella, rucola grana e pomodori',10.00);
INSERT INTO TB_PIZZA (code,name,description,price) VALUES ('AME', 'Americana', 'Base rossa, con mozzarella, wurstel e patatine',9.00);
INSERT INTO TB_PIZZA (code,name,description,price) VALUES ('SEF', 'Salsiccia e friarielli','Base rossa, con mozzarella...',12.00);
INSERT INTO TB_PIZZA (code,name,description,price) VALUES ('VEG', 'Vegetariana', 'Base rossa, con mozzarella...', 10.00);
INSERT INTO TB_PIZZA (code,name,description,price) VALUES ('BIA', 'Bianca', 'Base bianca, con mozzarella,',7.00);
INSERT INTO TB_PIZZA (code,name,description,price) VALUES ('BUF', 'Bufala', 'Base rossa, con mozzarella di bufala e olive',12.00);


--INSERT ORDER_PIZZA
INSERT INTO TB_ORDER_PIZZA (order_id,pizza_id) VALUES (1, 1);
INSERT INTO TB_ORDER_PIZZA (order_id,pizza_id) VALUES (1, 2);
INSERT INTO TB_ORDER_PIZZA (order_id,pizza_id) VALUES (1, 3);
INSERT INTO TB_ORDER_PIZZA (order_id,pizza_id) VALUES (2, 4);
INSERT INTO TB_ORDER_PIZZA (order_id,pizza_id) VALUES (2, 5);
INSERT INTO TB_ORDER_PIZZA (order_id,pizza_id) VALUES (2, 6);
INSERT INTO TB_ORDER_PIZZA (order_id,pizza_id) VALUES (2, 7);
INSERT INTO TB_ORDER_PIZZA (order_id,pizza_id) VALUES (2, 8);
