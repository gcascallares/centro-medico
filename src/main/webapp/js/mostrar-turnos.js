$(document).ready(function() {
	
	if ($('#horario').val() === null ){
		$("#mensajeVacio").text("No hay turnos disponibles para la fecha seleccionada, intente con otra");
		$('#horario').css("display","none");
		$('#reservar').css("display","none");
	}
		
	$("#atras").click(function(){
		window.history.back();
	});
	
	
});