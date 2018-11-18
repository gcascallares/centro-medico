$(document).ready(function() {
	 
	 
	 var id = $("#especialidadId").val();
	 var fecha = $("#fecha").val();
	 var idDiaElegido = $("#especialidadId").val();
		
	 $("#siguiente").click(function(){
		 
		 	var medicoId = $("#medicos option:selected").val();
		 
			//Validacion Especialidad
			
	        if(medicoId != 0){
	        	
	        	$("#mensajeMedico").fadeOut();
	            
				window.location.assign(window.context +"/turno/"+ id + "/dia/" + fecha + "/" + idDiaElegido + "/" + medicoId);
	            
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