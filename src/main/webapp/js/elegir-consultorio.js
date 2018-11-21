$(document).ready(function() {
	
	
	
	$("#botonSiguienteConsultorio").click(function(){
		var idConsultorio = $("#consultorio option:selected").val();
		var idMedico = $("#medicoId").val();
		window.location.assign(window.context +"/"+ idMedico +"/index-medico/"+ idConsultorio);
	});
	
	if ($('#consultorio').val() === null ){
		$("#mensajeVacio").text("No hay consultorios disponibles en este momento...");
		$('#consultorio').css("display","none");
		$('#botonSiguienteConsultorio').css("display","none");
	}
	
	
	
	
});