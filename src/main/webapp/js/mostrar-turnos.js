$(document).ready(function() {
	if ($('#horario').val() === null ){
		$("#mensajeVacio").text("No hay turnos disponibles para la fecha seleccionada, intente con otra");
		$('#horario').css("display","none");
		$('#reservar').css("display","none");
	}
		
	
	$("#reservar").click(function(){
		
		var horario = $("input[name='horario']:checked").val(); 
		var turnoId = $("turnoId").val(); 
		var fecha = $("fecha").val();
  
    	window.location.href = window.context+"/derivacion/"+ turnoId + fecha + horario;
            
	});
	
	$("#atras").click(function(){
		window.history.back();
	});
	
	
});