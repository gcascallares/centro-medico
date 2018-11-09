$(document).ready(function() {
	
	var id = $("#especialidadId").val();
	
	$("#botonSiguienteMedico").click(function(){
		var medicoId = $("#medicos option:selected").val();
		window.location.assign("/proyecto-limpio-spring/turno/"+ id + "/medico/"+medicoId);
	});
	
	/*var especialidadId = $("#especialidad").val();
	
	$("#botonMedico").click(function(){
		window.location.assign("/turno/medico"+ especialidadId);
	});*/
	
	
});