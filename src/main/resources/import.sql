insert into especialidad (id,intervalo,nombreEspecialidad) values (1,30,'Cardiolog�a'),(2,45,'Radiolog�a'),(3,15,'Laboratorio');
insert into medico (id,horaDesde,horaHasta,minutoDesde,minutoHasta,nombre,especialidad_id) values (1,8,16,0,30,'Juan Perez',1),(2,12,16,0,30,'Daniela Martinez',2),(3,9,12,0,0,'Ernesto Baba',3);
insert into consultorio (id,numero,medico_id) values (1,100,1),(2,101,2),(3,102,3),(4,103,2),(5,104,1),(6,105,null);	
