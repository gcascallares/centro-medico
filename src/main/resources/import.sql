insert into especialidad (id,intervalo,nombreEspecialidad) values (1,30,'Cardiología'),(2,45,'Radiología'),(3,15,'Laboratorio');
insert into medico (id,horaDesde,horaHasta,minutoDesde,minutoHasta,nombre,especialidad_id) values (1,8,16,0,30,'Juan Perez',1),(2,12,16,0,30,'Daniela Martinez',2),(3,9,12,0,0,'Ernesto Baba',3),(4,10,17,0,0,'Lucas Pratto',2);
insert into consultorio (id,numero,medico_id) values (1,100,1),(2,101,null),(3,102,3),(4,103,null),(5,104,1),(6,105,null),(7,106,2);	
insert into paciente (apellido, dni, nombre,email) values ("Messi", 111, "Lionel",'lioEl10Messi@dios.com.ar');
insert into recepcionista (nombre) values ("Jalan");
insert into diaslaborales (id,nombre) values (1,'Lunes'),(2,'Martes'),(3,'Miercoles'),(4,'Jueves'),(5,'Viernes');
insert into dias_medicos(dia_id,medico_id) values (1,1),(3,1),(1,2),(2,2),(1,3),(5,3),(2,4),(3,4);
insert into usuario(dni,password,medico_id,recepcionista_id,paciente_id,rol) values (111,'111',null,null,1,'paciente'),('333','333',null,1,null,'recepcionista'),('222','222',1,null,null,'medico');
insert into turno (id, estado, fecha, horario, medico_id, paciente_id) values (1,"En espera", "22-11-2018", "16:00", 1, 1), (2,"En espera", "22-11-2018", "13:00", 1, 1),(3,"Atendido", "16-11-2018", "16:00", 2, 1);