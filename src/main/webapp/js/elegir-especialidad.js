$(document).ready(function() {
	
	var id = $("#especialidad option:selected").val();
	
	$("#botonSiguienteEspecialidad").click(function(){
		window.location.assign("/proyecto-limpio-spring/turno/"+ id);
	});
	
	var especialidadId = $("#especialidad").val();
	
	$("#botonMedico").click(function(){
		window.location.assign("/turno/medico"+ especialidadId);
	});
	
	
});