$(document).ready(function() {
	
	if ($('#horario').val() === null ){
		$("#mensajeVacio").text("No hay turnos disponibles para la fecha seleccionada, intente con otra");
		$('#horario').css("display","none");
		$('#reservar').css("display","none");
	}
	
	$("#actualizar").click(function(){
			
			var horario = $("input[name='horario']:checked").val(); 
			var turnoId = $("#turnoId").val(); 
			var fecha = $("#fecha").val();
			var especialidadId = $("#especialidadId").val();
			var medicoId = $("#medicoId").val();
			
			if(typeof horario === 'undefined'){
				  alert("Debe elegir un turno")
				}
			else{
		    	window.location.href = window.context + "/misTurnos/actualizar/" + turnoId + "/" + especialidadId + "/" + medicoId + "/" + fecha + "/" + horario;
			}
	            
		});
	
	$("#atras").click(function(){
		window.history.back();
	});
	
	
});