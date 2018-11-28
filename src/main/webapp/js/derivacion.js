$(document).ready(function() {
		
	var usuarioId = $("#usuario").val();
	
	$("#derivacion").attr("href", window.context +"/derivacion/"+ usuarioId);
	
	
	 $("#fechaDerivacion").click(function(){
		 
		 var especialidadId = $("#especialidad").val();
		 var medicoId = $("#medico").val();
		 
		 window.location.assign(window.context +"/derivacion/"+ especialidadId + "/medico/" + medicoId);
	
	        
		});
	 
});