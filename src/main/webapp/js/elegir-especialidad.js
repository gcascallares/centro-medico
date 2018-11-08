$(document).ready(function() {
	
	
	
	$("#botonSiguienteEspecialidad").click(function(){
		var id = $("#especialidad option:selected").val();
		window.location.assign("/proyecto-limpio-spring/turno/"+ id);
	});
	
	var especialidadId = $("#especialidad").val();
	
	$("#botonMedico").click(function(){
		window.location.assign("/turno/medico"+ especialidadId);
	});
	
	
});