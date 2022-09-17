insert into roles(nombre) values ('ROLE_USER');
insert into roles(nombre) values ('ROLE_ADMIN');

insert into usuarios (username,password,enabled,nombre,apellido,email) values('user1','123466',1,'usuario 1','apellido 1','usuarios1@gmail.com');
insert into usuarios (username,password,enabled,nombre,apellido,email) values('user2','13666',1,'usuario 2','apellido 3','usuarios2@gmail.com');
insert into usuarios (username,password,enabled,nombre,apellido,email) values('user3','14466',1,'usuario 3','apellido 3','usuarios3@gmail.com');
insert into usuarios (username,password,enabled,nombre,apellido,email) values('user4','153466',1,'usuario 4','apellido 4','usuarios4@gmail.com');
insert into usuarios (username,password,enabled,nombre,apellido,email) values('user5','163466',1,'usuario 5','apellido 5','usuarios5@gmail.com');
insert into usuarios (username,password,enabled,nombre,apellido,email) values('user6','173466',1,'usuario 6','apellido 6','usuarios6@gmail.com');
insert into usuarios (username,password,enabled,nombre,apellido,email) values('user6','183466',1,'usuario 7','apellido 7','usuarios7@gmail.com');
insert into usuarios (username,password,enabled,nombre,apellido,email) values('user8','193466',1,'usuario 8','apellido 8','usuarios8@gmail.com');

insert into usuario_roles(usuario_id,role_id) values(1,1);
insert into usuario_roles(usuario_id,role_id) values(1,2);
insert into usuario_roles(usuario_id,role_id) values(2,2);
insert into usuario_roles(usuario_id,role_id) values(3,1);
insert into usuario_roles(usuario_id,role_id) values(4,1);
insert into usuario_roles(usuario_id,role_id) values(5,1);
insert into usuario_roles(usuario_id,role_id) values(6,1);
insert into usuario_roles(usuario_id,role_id) values(7,1);
insert into usuario_roles(usuario_id,role_id) values(8,1);
