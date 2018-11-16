$(document).ready(function() {
	
	
	
	$("#botonSiguienteConsultorio").click(function(){
		var idConsultorio = $("#consultorio option:selected").val();
		var idMedico = $("#medicoId").val();
		window.location.assign(window.context +"/"+ idMedico +"/index-medico/"+ idConsultorio);
	});
	
	
	
	
});