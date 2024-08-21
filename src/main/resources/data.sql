
--INSERT STATUS ORDER
INSERT INTO TB_STATUS (code,description) VALUES ('BOK', 'Booked');
INSERT INTO TB_STATUS (code,description) VALUES ('PRO', 'In progress');
INSERT INTO TB_STATUS (code,description) VALUES ('COM', 'Completed');
INSERT INTO TB_STATUS (code,description) VALUES ('DEL', 'Deleted');

--INSERT ORDERS
--Booked
INSERT INTO TB_ORDER (code, status_id, creation_date,creation_user, deleted, deletion_date, modification_date, price) VALUES ( 'f8c3de3d-1fea-4d7c-a8b0-29f63c4c3454',1,'2024-08-20 10:30:00','User 1', FALSE, NULL, NULL,10.00);
INSERT INTO TB_ORDER (code, status_id, creation_date,creation_user, deleted, deletion_date, modification_date, price) VALUES ( '018b2f19-e79e-7d6a-a56d-29feb6211b04',1,'2024-08-20 15:30:00','User 2', FALSE, NULL, NULL,30.00);
--In progress
INSERT INTO TB_ORDER (code, status_id, creation_date,creation_user, deleted, deletion_date, modification_date, price) VALUES ( '0c58d644-558a-4e7d-bc09-61a751f642f3',2,'2024-08-21 08:30:00','User 3', FALSE, NULL, NULL,10.00);

--Completed
INSERT INTO TB_ORDER (code, status_id, creation_date,creation_user, deleted, deletion_date, modification_date, price) VALUES ( '0753bb70-1682-41aa-af6b-8c0d007f0d27',3,'2024-08-21 07:30:00','User 4', FALSE, NULL, NULL,10.00);
INSERT INTO TB_ORDER (code, status_id, creation_date,creation_user, deleted, deletion_date, modification_date, price) VALUES ( '496788a6-e1f0-4ae7-9227-c4a8c2beb82e',3,'2024-08-21 06:30:00','User 5', FALSE, NULL, NULL,30.00);

    
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

INSERT INTO TB_ORDER_PIZZA (order_id,pizza_id) VALUES (3, 1);
INSERT INTO TB_ORDER_PIZZA (order_id,pizza_id) VALUES (3, 4);
INSERT INTO TB_ORDER_PIZZA (order_id,pizza_id) VALUES (3, 7);
INSERT INTO TB_ORDER_PIZZA (order_id,pizza_id) VALUES (3, 2);

INSERT INTO TB_ORDER_PIZZA (order_id,pizza_id) VALUES (4, 2);
INSERT INTO TB_ORDER_PIZZA (order_id,pizza_id) VALUES (4, 2);
INSERT INTO TB_ORDER_PIZZA (order_id,pizza_id) VALUES (4, 3);
INSERT INTO TB_ORDER_PIZZA (order_id,pizza_id) VALUES (4, 4);

INSERT INTO TB_ORDER_PIZZA (order_id,pizza_id) VALUES (5, 1);
INSERT INTO TB_ORDER_PIZZA (order_id,pizza_id) VALUES (5, 2);
INSERT INTO TB_ORDER_PIZZA (order_id,pizza_id) VALUES (5, 3);
INSERT INTO TB_ORDER_PIZZA (order_id,pizza_id) VALUES (5, 4);
