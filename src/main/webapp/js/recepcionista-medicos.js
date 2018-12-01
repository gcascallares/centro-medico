$(document).ready(function() {
	
	var id = $("#especialidadId").val();
	
	$("#siguiente").click(function(){
		
		var medicoId = $("#medicos option:selected").val();
		
		//Validacion Medico
		
        if(medicoId != 0){
        	
        	$("#mensajeMedico").fadeOut();
            
        	window.location.assign(window.context + "/elegirdia/"+ idPaciente + "/"+ especialidadId + "/" + medicoId);
            
        	}
        
        else{
            
        	$("#mensajeMedico").fadeIn("slow");
            return false;
            
            }
		
	});
	
	$("#atras").click(function(){
		window.history.back();
	});	
	
});