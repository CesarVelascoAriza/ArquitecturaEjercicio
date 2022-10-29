insert into tipo_transacciones(tipo_transaccion) values('Retiro');
insert into tipo_transacciones(tipo_transaccion) values('Consignación');
insert into tipo_transacciones(tipo_transaccion) values('Consulta');
insert into tipo_cuentas(tipo_cuenta) values ('Corriente');
insert into tipo_cuentas(tipo_cuenta) values ('Ahorros');
insert into clientes(numero_documento, nombre,apellido, correo, direccion) values (1, 'cliente 1', 'apellido 1', 'cliente1@gmail.com','direccion 1');
insert into clientes(numero_documento, nombre,apellido, correo, direccion) values (2, 'cliente 2', 'apellido 2', 'cliente2@gmail.com','direccion 2');
insert into clientes(numero_documento, nombre,apellido, correo, direccion) values (3, 'cliente 3', 'apellido 3', 'cliente3@gmail.com','direccion 3');
insert into clientes(numero_documento, nombre,apellido, correo, direccion) values (4, 'cliente 4', 'apellido 4', 'cliente4@gmail.com','direccion 4');
insert into clientes(numero_documento, nombre,apellido, correo, direccion) values (5, 'cliente 5', 'apellido 5', 'cliente5@gmail.com','direccion 5');
insert into clientes(numero_documento, nombre,apellido, correo, direccion) values (6, 'cliente 6', 'apellido 6', 'cliente6@gmail.com','direccion 6');

insert into cuentas(fecha_creacion,saldo,cliente,tipo_cuenta) values (NOW(),90000,1,1);
insert into cuentas(fecha_creacion,saldo,cliente,tipo_cuenta) values (NOW(),100000,2,1);
insert into cuentas(fecha_creacion,saldo,cliente,tipo_cuenta) values (NOW(),110000,3,1);
insert into cuentas(fecha_creacion,saldo,cliente,tipo_cuenta) values (NOW(),120000,4,1);
insert into cuentas(fecha_creacion,saldo,cliente,tipo_cuenta) values (NOW(),130000,5,1);
insert into cuentas(fecha_creacion,saldo,cliente,tipo_cuenta) values (NOW(),140000,6,1);
insert into cuentas(fecha_creacion,saldo,cliente,tipo_cuenta) values (NOW(),0,1,2);


insert into transacciones(fecha_creacion, monto, cliente_id,cuenta_id,tipo_id) values (NOW(),0,1,1,1);