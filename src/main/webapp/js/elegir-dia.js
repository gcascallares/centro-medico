$(document).ready(function() {
	
	var especialidadId = $("#especialidadId").val();
	var medicoId = $("#medicoId").val();
	
	$( function() {
	    $("#datepicker").datepicker();
	  } );
	
	var fecha = $('#datepicker').datepicker({ dateFormat: 'dd-mm-yy' }).val();
	
	 $("#atras").click(function(){
			window.location.assign("/proyecto-limpio-spring/turno/"+ especialidadId + "/medico/"+ medicoId);
		});	
	 
	 $("#botonSiguiente").click(function(){
			window.location.assign("/proyecto-limpio-spring/turno/"+ especialidadId + "/medico/"+ medicoId +"/"+ fecha);
		});	
	 
	
});