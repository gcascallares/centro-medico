$(document).ready(function() {
	
	$("#siguiente").click(function(){
		
		var especialidadId = $("#especialidad option:selected").val();
		
		//Validacion Especialidad
		
        if(especialidadId != 0){
        	
        	$("#mensajeEspecialidad").fadeOut();
            
            window.location.assign(window.context +"/elegirmedico/"+ idPaciente + "/"+ especialidadId);
            
        	}
        
        else{
            
        	$("#mensajeEspecialidad").fadeIn("slow");
            return false;
            
            }
	});

});