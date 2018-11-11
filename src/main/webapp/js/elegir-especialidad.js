$(document).ready(function() {
	
	$("#botonSiguienteEspecialidad").click(function(){
		var id = $("#especialidad option:selected").val();
		window.location.assign("/proyecto-limpio-spring/turno/"+ id);
	});
	
});