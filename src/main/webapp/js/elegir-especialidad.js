$(document).ready(function() {
	
	$("#botonSiguienteEspecialidad").click(function(){
		var id = $("#especialidad option:selected").val();
		window.location.assign(window.context +"/turno/"+ id);
	});
	
	$("#atras").click(function(){
		window.history.back();
	});	
	
});