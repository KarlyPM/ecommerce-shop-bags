/*NOMBRE DATABASE: ProyectoBD */
CREATE TABLE MARCA (
	ID_MARCA SERIAL NOT NULL,
	DESCRIPCION CHARACTER VARYING NOT NULL,
	CONSTRAINT MARCAR_PK PRIMARY KEY (ID_MARCA)

);

INSERT INTO MARCA (DESCRIPCION) VALUES ('NIKE');
INSERT INTO MARCA (DESCRIPCION) VALUES ('TETON SPORTS');
INSERT INTO MARCA (DESCRIPCION) VALUES ('BALENCIAGA');
INSERT INTO MARCA (DESCRIPCION) VALUES ('SAMSONITE');
INSERT INTO MARCA (DESCRIPCION) VALUES ('BALENCIAGA');
INSERT INTO MARCA (DESCRIPCION) VALUES ('Herschel');
INSERT INTO MARCA (DESCRIPCION) VALUES ('Louis Vuitton');
INSERT INTO MARCA (DESCRIPCION) VALUES ('Tavelpro');

---------------------------------------------------

CREATE TABLE PROVEEDOR(
	ID_PROVEEDOR SERIAL NOT NULL,
	NOMBRE CHARACTER VARYING NOT NULL,
	CONTACTO CHARACTER VARYING NOT NULL,
	DIRECCION CHARACTER VARYING NOT NULL,
	CELULAR CHARACTER VARYING NOT NULL,
	
	CONSTRAINT PROVEEDOR_PK PRIMARY KEY (ID_PROVEEDOR)
		
);

insert into PROVEEDOR (ID_PROVEEDOR, NOMBRE, CONTACTO, DIRECCION, CELULAR) values (1, 'Langosh, Kerluke and Sipes', 'Rodrique McPhilemy', '83236 Myrtle Terrace', '993-363-7964');
insert into PROVEEDOR (ID_PROVEEDOR, NOMBRE, CONTACTO, DIRECCION, CELULAR) values (2, 'Nicolas, Bednar and Heidenreich', 'Hailey Mertel', '187 7th Alley', '737-127-3282');
insert into PROVEEDOR (ID_PROVEEDOR, NOMBRE, CONTACTO, DIRECCION, CELULAR) values (3, 'Schiller LLC', 'Aluin Trevance', '168 Waxwing Park', '514-267-8935');
insert into PROVEEDOR (ID_PROVEEDOR, NOMBRE, CONTACTO, DIRECCION, CELULAR) values (4, 'Towne, Kunze and Kohler', 'Umeko Aloigi', '410 Stephen Crossing', '826-238-9483');
insert into PROVEEDOR (ID_PROVEEDOR, NOMBRE, CONTACTO, DIRECCION, CELULAR) values (5, 'Boehm Group', 'Tootsie Mathew', '0 Fuller Parkway', '878-510-3244');
insert into PROVEEDOR (ID_PROVEEDOR, NOMBRE, CONTACTO, DIRECCION, CELULAR) values (6, 'Jacobs Group', 'Robinett Egger', '7 Waxwing Alley', '507-758-3970');
insert into PROVEEDOR (ID_PROVEEDOR, NOMBRE, CONTACTO, DIRECCION, CELULAR) values (7, 'Bashirian-Emmerich', 'Danie Biddles', '06 Independence Circle', '257-447-9185');
insert into PROVEEDOR (ID_PROVEEDOR, NOMBRE, CONTACTO, DIRECCION, CELULAR) values (8, 'Blick, Block and Welch', 'Leanora Cornall', '00 Lakewood Trail', '152-854-1311');
insert into PROVEEDOR (ID_PROVEEDOR, NOMBRE, CONTACTO, DIRECCION, CELULAR) values (9, 'Feest-Brekke', 'Reinaldo Yegorshin', '765 Hayes Court', '926-271-3101');
insert into PROVEEDOR (ID_PROVEEDOR, NOMBRE, CONTACTO, DIRECCION, CELULAR) values (10, 'Paucek, Heidenreich and Homenick', 'Lona Bernhardi', '66433 Charing Cross Court', '179-659-8557');
insert into PROVEEDOR (ID_PROVEEDOR, NOMBRE, CONTACTO, DIRECCION, CELULAR) values (11, 'Mills-Schulist', 'Dru Haighton', '77763 Reinke Circle', '693-895-9814');
insert into PROVEEDOR (ID_PROVEEDOR, NOMBRE, CONTACTO, DIRECCION, CELULAR) values (12, 'Parisian, Okuneva and Okuneva', 'Darcy Ellershaw', '75 Nancy Park', '825-898-1290');
insert into PROVEEDOR (ID_PROVEEDOR, NOMBRE, CONTACTO, DIRECCION, CELULAR) values (13, 'Dicki-O''Hara', 'Stearn Waddilow', '9 Thompson Parkway', '166-554-0744');
insert into PROVEEDOR (ID_PROVEEDOR, NOMBRE, CONTACTO, DIRECCION, CELULAR) values (14, 'Schinner, Von and Keeling', 'Gaultiero Elacoate', '0740 Packers Point', '134-459-7055');
insert into PROVEEDOR (ID_PROVEEDOR, NOMBRE, CONTACTO, DIRECCION, CELULAR) values (15, 'Mitchell, Lang and Nienow', 'Lorie Jacquot', '96 Dryden Place', '154-639-8332');
	
	
--------------------------------------------------

CREATE TABLE CATEGORIA (
	ID_CATEGORIA SERIAL NOT NULL,
	DESCRIPCION CHARACTER VARYING NOT NULL,
	CONSTRAINT CATEGORIA_PK PRIMARY KEY (ID_CATEGORIA )
);

INSERT INTO CATEGORIA (ID_CATEGORIA, DESCRIPCION) VALUES(1,'Carteras de mano');
INSERT INTO CATEGORIA (ID_CATEGORIA, DESCRIPCION) VALUES(2,'Mochilas');
INSERT INTO CATEGORIA (ID_CATEGORIA, DESCRIPCION) VALUES(3,'Bolsos Deportivos');
INSERT INTO CATEGORIA (ID_CATEGORIA, DESCRIPCION) VALUES(4,'Bolso de camping');
INSERT INTO CATEGORIA (ID_CATEGORIA, DESCRIPCION) VALUES(5,'Luggage');

--------------------------------------------------
CREATE TABLE USUARIO(
	ID_USUARIO SERIAL NOT NULL,
	NOMBRE CHARACTER VARYING NOT NULL,
	APELLIDO CHARACTER VARYING NOT NULL,
	CORREO_ELECTRONICO CHARACTER VARYING NOT NULL,
	CONTRASENA CHARACTER VARYING NOT NULL,
	TIPO_USUARIO CHARACTER VARYING,
	
	CONSTRAINT USUARIO_PK PRIMARY KEY (ID_USUARIO)	
);

insert into USUARIO (NOMBRE, APELLIDO, CORREO_ELECTRONICO, CONTRASENA, TIPO_USUARIO) values ('Admin1', 'Crennell', 'Admin1', '123', 'Administrador');

----------------------------------------------------
CREATE TABLE PRODUCTO(
	ID_PRODUCTO SERIAL NOT NULL,
	NOMBRE CHARACTER VARYING NOT NULL,
	DESCRIPCION CHARACTER VARYING NOT NULL,
	PRECIO_UNITARIO FLOAT NOT NULL,
	IMAGEN BYTEA,
	imagennombre CHARACTER VARYING,
	STOCK INTEGER NOT NULL,
	ID_MARCA INTEGER,
	ID_PROVEEDOR INTEGER,
	ID_CATEGORIA INTEGER,
	
	CONSTRAINT PRODUCTO_PK PRIMARY KEY (ID_PRODUCTO),
	CONSTRAINT MARCA_FK FOREIGN KEY (ID_MARCA) REFERENCES MARCA(ID_MARCA),
	CONSTRAINT PROVEEDOR_FK FOREIGN KEY (ID_PROVEEDOR) REFERENCES PROVEEDOR(ID_PROVEEDOR),
	CONSTRAINT CATEGORIA_FK FOREIGN KEY (ID_CATEGORIA) REFERENCES CATEGORIA(ID_CATEGORIA)
	
	
);
/*AGREGAR RUTA

INSERT INTO PRODUCTO (ID_PRODUCTO, NOMBRE,DESCRIPCION,PRECIO_UNITARIO,imagennombre,IMAGEN,
					  STOCK, ID_MARCA,ID_PROVEEDOR,ID_CATEGORIA)
VALUES(1,'Pathways 3.0 Expandible','Cubierta 100% policarbonato, protectores de esquinas de aluminio',79.85,
	   'Pathways.jpeg', 
	   pg_read_binary_file('D:...\web\resources\imagen\Pathways.jpeg'),
	   10,7,5,5);  
*/ 
---------------------------------------------------------------------------------------------
CREATE TABLE PAGO(
	ID_PAGO SERIAL NOT NULL,
	METODO_PAGO CHARACTER VARYING NOT NULL,
	NOMBRE_TITULAR CHARACTER VARYING NOT NULL,
	FECHA_EXPEDICION DATE NOT NULL,
	NUMERO_TARJETA CHARACTER VARYING NOT NULL,
	CONSTRAINT PAGO_PK PRIMARY KEY (ID_PAGO)

);
-------------------------------------------------------------------------------------------------
CREATE TABLE PEDIDO(
	ID_PEDIDO SERIAL NOT NULL,
	DESCRI_DIRECCION CHARACTER VARYING NOT NULL,
	CODIGO_POSTAL INTEGER NOT NULL,
	CIUDAD CHARACTER VARYING NOT NULL,	
	TOTAL FLOAT NOT NULL,
	ID_USUARIO INTEGER,
	ID_PAGO INTEGER,

	CONSTRAINT PEDIDO_PK PRIMARY KEY (ID_PEDIDO),
	CONSTRAINT PEDIDO_USER_FK FOREIGN KEY (ID_USUARIO) REFERENCES USUARIO(ID_USUARIO),	
	CONSTRAINT PAGO_FK FOREIGN KEY(ID_PAGO) REFERENCES PAGO(ID_PAGO)

);

insert into USUARIO (NOMBRE, APELLIDO, CORREO_ELECTRONICO, CONTRASENA, TIPO_USUARIO) values ('Admin2', 'Bilbey', 'Admin2', '123', 'Administrador');
insert into USUARIO (NOMBRE, APELLIDO, CORREO_ELECTRONICO, CONTRASENA, TIPO_USUARIO) values ('Bendicty', 'Yurin', 'byurin2@google.com.au', 'lqSS9axeMOd', 'Cliente');
insert into USUARIO (NOMBRE, APELLIDO, CORREO_ELECTRONICO, CONTRASENA, TIPO_USUARIO) values ('Meredeth', 'Furst', 'mfurst3@plala.or.jp', '1tmdo9K2kX', 'Cliente');
insert into USUARIO (NOMBRE, APELLIDO, CORREO_ELECTRONICO, CONTRASENA, TIPO_USUARIO) values ('Mindy', 'Becke', 'mbecke4@cpanel.net', 'DAbRSNJ', 'Cliente');
insert into USUARIO (NOMBRE, APELLIDO, CORREO_ELECTRONICO, CONTRASENA, TIPO_USUARIO) values ('Eran', 'Menico', 'emenico5@nasa.gov', 'mwGxUCZQiCr3', 'Cliente');
insert into USUARIO (NOMBRE, APELLIDO, CORREO_ELECTRONICO, CONTRASENA, TIPO_USUARIO) values ('Willi', 'Teape', 'wteape6@go.com', 'dsNJfgr', 'Cliente');
insert into USUARIO (NOMBRE, APELLIDO, CORREO_ELECTRONICO, CONTRASENA, TIPO_USUARIO) values ('Jodi', 'Harkin', 'jharkin7@paginegialle.it', 'P7c3uJj', 'Cliente');
insert into USUARIO (NOMBRE, APELLIDO, CORREO_ELECTRONICO, CONTRASENA, TIPO_USUARIO) values ('Bondie', 'Angel', 'bangel8@artisteer.com', 'eeksBI', 'Cliente');
insert into USUARIO (NOMBRE, APELLIDO, CORREO_ELECTRONICO, CONTRASENA, TIPO_USUARIO) values ('Mendel', 'Oman', 'moman9@sakura.ne.jp', 'soGDfQG', 'Cliente');


/*POSIBLES MEJORAS
--------------------------------------------------------------------------------------------------

CREATE TABLE CABEZERA_FACTURA(
	ID_CABEZERA_FACTURA SERIAL NOT NULL,
	DESCRI_DIRECCION CHARACTER VARYING NOT NULL,
	CODIGO_POSTAL INTEGER NOT NULL,
	CIUDAD CHARACTER VARYING NOT NULL,
	ID_PAGO INTEGER,
	ID_USUARIO INTEGER
	
	CONSTRAINT CABEZERA_FACTURA_PK PRIMARY KEY (ID_CABEZERA_FACTURA),
	CONSTRAINT CABERZARA_USER_FK FOREIGN KEY (ID_USUARIO) REFERENCES USUARIO(ID_USUARIO),
	CONSTRAINT PAGO_FK FOREIGN KEY(ID_PAGO) REFERENCES PAGO(ID_PAGO)
);
-------------------------------------------------------------------------------------------------
CREATE TABLE DETALLE_FACTURA(
	ID_DETALLE_FACTURA SERIAL NOT NULL,
	TOTAL FLOAT NOT NULL,
	ID_CABEZERA_FACTURA INTEGER,
	ID_PRODUCTO INTEGER,

	CONSTRAINT FACTURA_PK PRIMARY KEY (ID_DETALLE_FACTURA),
	CONSTRAINT CABEZERA_FK FOREIGN KEY(ID_CABEZERA_FACTURA) REFERENCES CABEZERA_FACTURA(ID_CABEZERA_FACTURA),
	CONSTRAINT PRODUCTO_FK FOREIGN KEY(ID_PRODUCTO) REFERENCES PRODUCTO(ID_PRODUCTO)
	
);

*/