insert into especialidad (id,intervalo,nombreEspecialidad) values (1,30,'Cardiología'),(2,45,'Radiología'),(3,15,'Laboratorio');
insert into medico (id,horaDesde,horaHasta,minutoDesde,minutoHasta,nombre,especialidad_id) values (1,8,16,0,30,'Juan Perez',1),(2,12,16,0,30,'Daniela Martinez',2),(3,9,12,0,0,'Ernesto Baba',3),(4,10,17,0,0,'Lucas Pratto',2);
insert into consultorio (id,numero,medico_id) values (1,100,1),(2,101,2),(3,102,3),(4,103,2),(5,104,1),(6,105,null),(7,106,null);	
insert into paciente (apellido, dni, nombre) values ("ana", 111, "alan");
insert into recepcionista (nombre) values ("Jalan");
insert into diaslaborales (id,nombre) values (1,'Lunes'),(2,'Martes'),(3,'Miercoles'),(4,'Jueves'),(5,'Viernes');
insert into dias_medicos(dia_id,medico_id) values (1,1),(3,1),(1,2),(2,2),(1,3),(5,3),(2,4),(3,4);
insert into usuario(email,password,medico_id,recepcionista_id,paciente_id,rol) values ('a@a.com','123456',null,null,1,'paciente'),('b@b.com','123456',null,1,null,'recepcionista');
insert into turno (id, estado, fecha, horario, medico_id, paciente_id) values (1,"en_espera", "15-11-2018", "16:00", 1, 1), (2,"en_espera", "15-11-2018", "13:00", 1, 1),(3,"atendido", "16-11-2018", "16:00", 2, 1);