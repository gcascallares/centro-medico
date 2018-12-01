$(document).ready(function() {
	
	var id = $("#especialidadId").val();
	var turnoId = $("#turnoId").val();
	
	$("#botonMedico").click(function(){
		window.location.assign(window.context +"/turno/"+ id + "/medicos");
	});	
	
	$("#botonDia").click(function(){
		window.location.assign(window.context +"/turno/"+ id + "/dias");
	});
	
	$("#atras").click(function(){
		window.history.back();
	});	
	
	
});