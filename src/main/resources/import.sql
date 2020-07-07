--INSERT INTO `clients` (name, last_name, email) VALUES ('user', 'user1', 'prueba@gmail.com');
--INSERT INTO `clients` (name, last_name, email) VALUES ('user 2', 'last name user 2', 'prueba@gmail.com');
--INSERT INTO `clients` (name, last_name, email) VALUES ('user 3', 'last name', 'prueba@gmail.com');
--INSERT INTO `clients` (name, last_name, email) VALUES ('user 4', 'last', 'prueba@gmail.com');
--INSERT INTO `clients` (name, last_name, email) VALUES ('user 5', 'user', 'prueba@gmail.com');
INSERT INTO `users` (username, password, enabled) VALUES ('andres','$2a$10$Xt3pyjQZi13N7FelTm8EgeEAG9kceETlHzqKuWI/wk.TJAWfu0RKS',1);
INSERT INTO `users` (username, password, enabled) VALUES ('admin','$2a$10$YsbSGz9kR3.HoeMyPkxJ/.xiVK12ohT1hEqYMtLe90/GyOXK8SiIm',1);

INSERT INTO `authorities` (user_id, authority) VALUES (1,'ROLE_USER');
INSERT INTO `authorities` (user_id, authority) VALUES (2,'ROLE_ADMIN');
INSERT INTO `authorities` (user_id, authority) VALUES (2,'ROLE_USER');