insert into roles(nombre) values ('ROLE_USER');
insert into roles(nombre) values ('ROLE_ADMIN');

insert into usuarios (username,password,enabled,nombre,apellido,email) values('user1','$2a$10$sdBbasDLx.kya8u2m7dKFuzv.blkG0MTpEXKcQwBYQGfMtZ07C4e.',1,'usuario 1','apellido 1','usuarios1@gmail.com');
insert into usuarios (username,password,enabled,nombre,apellido,email) values('user2','$2a$10$sdBbasDLx.kya8u2m7dKFuzv.blkG0MTpEXKcQwBYQGfMtZ07C4e.',1,'usuario 2','apellido 3','usuarios2@gmail.com');
insert into usuarios (username,password,enabled,nombre,apellido,email) values('user3','$2a$10$wCscVNP6i.YxejFRde1QdOsXh9P1K6pkvt0DothXENABEffp40cYK',1,'usuario 3','apellido 3','usuarios3@gmail.com');
insert into usuarios (username,password,enabled,nombre,apellido,email) values('user4','$2a$10$HUH1elsg.4owFQXTA6BWEOffPL.z0JWsucdoyXvbYS/wrq5RHWIcC',1,'usuario 4','apellido 4','usuarios4@gmail.com');
insert into usuarios (username,password,enabled,nombre,apellido,email) values('user5','$2a$10$BTElbz0sHgM7NcfEH5.LXehArKwU99kRq67lUj59H6Uxvq5KJhLHe',1,'usuario 5','apellido 5','usuarios5@gmail.com');
insert into usuarios (username,password,enabled,nombre,apellido,email) values('user6','$2a$10$JMhYLNGMqXX/valOwNZUdui/6RIj2DdSNtadFybwDDDRbKViZNcti',1,'usuario 6','apellido 6','usuarios6@gmail.com');
insert into usuarios (username,password,enabled,nombre,apellido,email) values('user6','$2a$10$FT7Jq/pWm2SCu6egmuNB7OTC6k7icck7F/CLO43b1r6Xb7cN3ZiWe',1,'usuario 7','apellido 7','usuarios7@gmail.com');
insert into usuarios (username,password,enabled,nombre,apellido,email) values('user8','$2a$10$QOJId7nkR5aMsf.5sttYpuHxgjcOaXK/NaAFKxS7x5onAYc2HTuiW',1,'usuario 8','apellido 8','usuarios8@gmail.com');


insert into usuario_roles(usuario_id,role_id) values(1,1);
insert into usuario_roles(usuario_id,role_id) values(1,2);
insert into usuario_roles(usuario_id,role_id) values(2,2);
insert into usuario_roles(usuario_id,role_id) values(3,1);
insert into usuario_roles(usuario_id,role_id) values(4,1);
insert into usuario_roles(usuario_id,role_id) values(5,1);
insert into usuario_roles(usuario_id,role_id) values(6,1);
insert into usuario_roles(usuario_id,role_id) values(7,1);
insert into usuario_roles(usuario_id,role_id) values(8,1);
