insert into especialidad (id,intervalo,nombreEspecialidad) values (1,30,'Cardiología'),(2,45,'Radiología'),(3,15,'Laboratorio');
insert into medico (id,horaDesde,horaHasta,minutoDesde,minutoHasta,nombre,especialidad_id) values (1,8,16,0,30,'Juan Perez',1),(2,12,16,0,30,'Daniela Martinez',2),(3,9,12,0,0,'Ernesto Baba',3);
insert into consultorios (id,numero) values (1,100),(2,101),(3,102),(4,103),(5,104);
insert into turno (id, dia, estado, horario, medico_id, paciente_id) values (1, "martes", 2, "12:20", 1, null),(2, "martes", 2, "10:20", 1, null) ;