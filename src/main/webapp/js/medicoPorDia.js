$(document).ready(function() {
	 
	 
	 var id = $("#especialidadId").val();
	 var fecha = $("#fecha").val();
	 var idDiaElegido = $("#especialidadId").val();
		
	 $("#botonSiguienteMedico").click(function(){
		 var medicoId = $("#medicos option:selected").val();
			window.location.assign("/proyecto-limpio-spring/turno/"+ id + "/dia/" + fecha + "/" + idDiaElegido + "/" + medicoId);
		});
	
});