$(document).ready(function() {
	
	$("#siguiente").click(function(){
		
		var id = $("#especialidad option:selected").val();
		
		//Validacion Especialidad
		
        if(id != 0){
        	
        	$("#mensajeEspecialidad").fadeOut();
            
            window.location.assign(window.context +"/turno/"+ id);
            
        	}
        
        else{
            
        	$("#mensajeEspecialidad").fadeIn("slow");
            return false;
            
            }
	});
	
	
	$("#atras").click(function(){
		window.history.back();
	});	
	
});