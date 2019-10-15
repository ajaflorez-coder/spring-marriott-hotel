/*Ejecutar solo antes de correr spring*/

use master
go

drop database marriott
go

create database marriott
go

use marriott
go

/*Ejecutar despues de correr spring*/

insert into tipos values(1,'vip')
insert into tipos values(2,'economico')
insert into tipos values(3,'matrimonial')
insert into tipos values(4,'personal')
select *from tipos

insert into habitaciones values('Cuarto 3 - Piso 3',2,'sin baño',100.50,2)
go
select *from habitaciones

insert into vendedores values('V01','psje los azahares 145','henry quintanilla','cajero',1500.50,7894561)
go
select *from vendedores

insert into clientes values('4567891','1994-12-14','lima','key cuevas','usuario preferencial','m')
go
select *from clientes

insert into alquileres values('a','2019-03-05','2019-03-20','se fue sin pagar y se llevo espejo',200.50,1,1,'V01')
go
select *from alquileres