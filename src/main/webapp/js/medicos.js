$(document).ready(function() {
	
	var id = $("#especialidadId").val();
	
	var medicoId = $("#medicos option:selected").val();
	
	$("#botonSiguienteMedico").click(function(){
		window.location.assign("/proyecto-limpio-spring/turno/"+ id + "/medico/"+ medicoId);
	});
	
	$("#atras").click(function(){
		window.location.assign("/proyecto-limpio-spring/turno/"+ id);
	});
	
});