
INSERT INTO especificaciones_tecnicas (descripcion, componentes) VALUES ( 'DESCRIPCION 1', 'COMPONENTE 1');
INSERT INTO especificaciones_tecnicas (descripcion, componentes) VALUES ( 'DESCRIPCION 2', 'COMPONENTE 2');
INSERT INTO especificaciones_tecnicas (descripcion, componentes) VALUES ( 'DESCRIPCION 3', 'COMPONENTE 3');
INSERT INTO especificaciones_tecnicas (descripcion, componentes) VALUES ( 'DESCRIPCION 4', 'COMPONENTE 4');
INSERT INTO especificaciones_tecnicas (descripcion, componentes) VALUES ( 'DESCRIPCION 5', 'COMPONENTE 5');
INSERT INTO especificaciones_tecnicas (descripcion, componentes) VALUES ( 'DESCRIPCION 6', 'COMPONENTE 6');


INSERT INTO productos (nombre,cantidad,precio,create_at,especificacion_id) VALUES('PRODUCTO 1',10,10000,NOW(),1);
INSERT INTO productos (nombre,cantidad,precio,create_at,especificacion_id) VALUES('PRODUCTO 2',20,20000,NOW(),2);
INSERT INTO productos (nombre,cantidad,precio,create_at,especificacion_id) VALUES('PRODUCTO 3',30,30000,NOW(),3);
INSERT INTO productos (nombre,cantidad,precio,create_at,especificacion_id) VALUES('PRODUCTO 4',40,40000,NOW(),4);
INSERT INTO productos (nombre,cantidad,precio,create_at,especificacion_id) VALUES('PRODUCTO 5',40,40000,NOW(),5);
INSERT INTO productos (nombre,cantidad,precio,create_at,especificacion_id) VALUES('PRODUCTO 6',40,40000,NOW(),6);

INSERT INTO clientes (nombre, direccion) VALUES ('cliente 1', 'direccion 1');
INSERT INTO clientes (nombre, direccion) VALUES ('cliente 2', 'direccion 2');
INSERT INTO clientes (nombre, direccion) VALUES ('cliente 3', 'direccion 3');
INSERT INTO clientes (nombre, direccion) VALUES ('cliente 4', 'direccion 4');
INSERT INTO clientes (nombre, direccion) VALUES ('cliente 5', 'direccion 5');
INSERT INTO clientes (nombre, direccion) VALUES ('cliente 6', 'direccion 6');

INSERT INTO ventas(cantidad, valor, fecha, producto_id , cliente_id) VALUES( 10,100000,NOW(),1,1);
INSERT INTO ventas(cantidad, valor, fecha, producto_id , cliente_id ) VALUES( 20,200000,NOW(),2,2);
INSERT INTO ventas(cantidad, valor, fecha, producto_id , cliente_id) VALUES( 30,300000,NOW(),3,3);
INSERT INTO ventas(cantidad, valor, fecha, producto_id , cliente_id) VALUES( 40,400000,NOW(),4,4);
INSERT INTO ventas(cantidad, valor, fecha, producto_id , cliente_id) VALUES( 50,500000,NOW(),5,5);
INSERT INTO ventas(cantidad, valor, fecha, producto_id , cliente_id) VALUES( 60,600000,NOW(),6,6);
