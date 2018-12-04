$(document).ready(function() {
	
	var id = $("#especialidadId").val();
<<<<<<< HEAD
	
	$("#botonMedico").click(function(){
		window.location.assign(window.context +"/turno/"+ id + "/medicos");
	});	
=======
	var turnoId = $("#turnoId").val();
	
	$("#botonMedico").click(function(){
		window.location.assign(window.context +"/turno/"+ id + "/medicos");
	});	
	
>>>>>>> branch 'master' of https://github.com/ignacrescenzo/centro-medico.git
	$("#botonDia").click(function(){
		window.location.assign(window.context +"/turno/"+ id + "/dias");
	});
	
	$("#atras").click(function(){
		window.history.back();
	});	
	
	
});