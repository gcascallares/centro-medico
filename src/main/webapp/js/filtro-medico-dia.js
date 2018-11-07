$(document).ready(function() {
	
	var id = $("#especialidadId").val();
	
	$("#botonMedico").click(function(){
		window.location.assign("/proyecto-limpio-spring/turno/"+ id + "/medico");
	});	
	$("#botonDia").click(function(){
		window.location.assign("/proyecto-limpio-spring/turno/"+ id + "/dia");
	});
	
	
});