$(document).ready(function() {
	
	
	
	$("#botonSiguienteConsultorio").click(function(){
		var idConsultorio = $("#consultorio option:selected").val();
		var idMedico = $("#medicoId").val();
		window.location.assign("/proyecto-limpio-spring/"+ idMedico +"/index-medico/"+ idConsultorio);
	});
	
	
	
	
});