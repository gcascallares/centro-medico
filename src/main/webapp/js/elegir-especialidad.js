$( document ).ready(function() {
	$("#botonSiguienteEspecialidad").click(function(){
		var id = $("#especialidad option:selected").val();
		window.location.assign("/turno/"+id);
	});
});