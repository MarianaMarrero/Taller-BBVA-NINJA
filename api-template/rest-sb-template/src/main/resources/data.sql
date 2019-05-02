DELETE from training;
INSERT INTO training (id, name) VALUES('1','Conexion a BD');
INSERT INTO training (id, name) VALUES('2','Lineaminetos Logs');
INSERT INTO training (id, name) VALUES('3','Lineaminetos Spring Cloud Config');
INSERT INTO training (id, name) VALUES('4','Manejo de excepciones');
INSERT INTO training (id, name) VALUES('5','Logging de APIs');

DELETE from employee;
INSERT INTO employee (id, name) VALUES('1','Juan Perez');
INSERT INTO employee (id, name) VALUES('2','Lourdes Martinez');
INSERT INTO employee (id, name) VALUES('3','Jose Fuentes');
INSERT INTO employee (id, name) VALUES('4','Jorge Alvarez');


DELETE from employee_training;
INSERT INTO employee_training (id_employee, id_training) VALUES('1',1);
INSERT INTO employee_training (id_employee, id_training) VALUES('1',2);
INSERT INTO employee_training (id_employee, id_training) VALUES('1',3);
INSERT INTO employee_training (id_employee, id_training) VALUES('1',4);
INSERT INTO employee_training (id_employee, id_training) VALUES('1',5);
INSERT INTO employee_training (id_employee, id_training) VALUES('2',1);
INSERT INTO employee_training (id_employee, id_training) VALUES('2',2);
INSERT INTO employee_training (id_employee, id_training) VALUES('2',3);
;