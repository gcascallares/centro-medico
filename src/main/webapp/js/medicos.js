$(document).ready(function() {
	
	var id = $("#especialidadId").val();
	
	
	
	$("#botonSiguienteMedico").click(function(){
		var medicoId = $("#medicos option:selected").val();
		window.location.assign("/proyecto-limpio-spring/turno/"+ id + "/medico/"+ medicoId);
	});
	
	$("#atras").click(function(){
		window.location.assign("/proyecto-limpio-spring/turno/"+ id);
	});
	
});