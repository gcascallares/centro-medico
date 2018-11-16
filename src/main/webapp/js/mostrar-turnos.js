$(document).ready(function() {
	if ($('#horario').val() === null ){
		$("#mensajeVacio").text("No hay turnos disponibles para la fecha seleccionada, intente con otra");
		$('#horario').css("display","none");
		$('#reservar').css("display","none");
	}
		
	
	$("#botonSiguienteEspecialidad").click(function(){
		var id = $("#especialidad option:selected").val();
		window.location.href=window.context+"/turno/"+ id;
	});
	
	$("#atras").click(function(){
		window.history.back();
	});
	
	
});