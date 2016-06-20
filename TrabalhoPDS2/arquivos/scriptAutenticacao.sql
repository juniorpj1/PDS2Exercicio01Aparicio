CREATE DATABASE dbSeguranca;
USE DATABASE dbSeguranca;

INSERT INTO tb_sistema(NM_SISTEMA, DS_URL) 
VALUES('Sistema Pedido','http://localhost:8080/TrabalhoPDS2/'),
	('Seguranca','http://localhost:8080/Seguranca');
       
INSERT INTO tb_usuario(DS_LOGIN, FL_ATIVO, DS_EMAIL,DS_SENHA) 
VALUES 	('aparicio',1,'apariciojunior11@gmail.com','fASDfrNWVl4ouxTlod7bJApawlYfjtMYxUonn7apZl4='),
		('bruno',1,'bruno@gmail.com','YLytd8Q8SrmEDYqkS2wY5pLmyOXk9ANRVhxBJ08Rl8g=');

INSERT INTO tb_role(NM_ROLE, CD_SISTEMA) 
VALUES ('PED_admin',1),
	   ('PED_cadastro',1),
('PED_consulta',1),
('SEG_admin',2),
('SEG_cadastro',2),
('SEG_consulta',2);

INSERT INTO tb_usuario_role(CD_ROLE,DS_LOGIN)
VALUES (1,'bruno'),
	   (4,'bruno'),
       (3,'aparicio'),
       (6,'aparicio');
       
       
    -- a123 = fASDfrNWVl4ouxTlod7bJApawlYfjtMYxUonn7apZl4=
	-- b123 = YLytd8Q8SrmEDYqkS2wY5pLmyOXk9ANRVhxBJ08Rl8g=