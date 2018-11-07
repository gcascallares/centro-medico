$(document).ready(function() {
	
	var id = $("#especialidad option:selected").val();
	
	$("#botonSiguienteEspecialidad").click(function(){
		window.location.assign("/proyecto-limpio-spring/turno/"+ id);
	});
});