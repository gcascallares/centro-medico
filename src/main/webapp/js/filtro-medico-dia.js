$(document).ready(function() {
	
	var id = $("#especialidadId").val();
	
	$("#botonMedico").click(function(){
		window.location.assign("/proyecto-limpio-spring/turno/"+ id + "/medicos");
	});	
	$("#botonDia").click(function(){
		window.location.assign("/proyecto-limpio-spring/turno/"+ id + "/dias");
	});
	$("#atras").click(function(){
		window.location.assign("/proyecto-limpio-spring/turno");
	});
	
	
});