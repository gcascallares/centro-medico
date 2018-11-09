$(document).ready(function() {
	
	
	
	$("#botonSiguienteConsultorio").click(function(){
		var id = $("#consultorio option:selected").val();
		window.location.assign("/proyecto-limpio-spring/index-medico/"+ id);
	});
	
	
	
	
});