<<<<<<< HEAD
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
	 
	
=======
$(document).ready(function() {
    
	$.datepicker.regional['es'] = {
			 closeText: 'Cerrar',
			 prevText: '< Ant',
			 nextText: 'Sig >',
			 currentText: 'Hoy',
			 monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
			 monthNamesShort: ['Ene','Feb','Mar','Abr', 'May','Jun','Jul','Ago','Sep', 'Oct','Nov','Dic'],
			 dayNames: ['Domingo', 'Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado'],
			 dayNamesShort: ['Dom','Lun','Mar','Mié','Juv','Vie','Sáb'],
			 dayNamesMin: ['Do','Lu','Ma','Mi','Ju','Vi','Sá'],
			 weekHeader: 'Sm',
			 dateFormat: 'dd/mm/yy',
			 firstDay: 1,
			 isRTL: false,
			 showMonthAfterYear: false,
			 yearSuffix: ''
			 };
			 $.datepicker.setDefaults($.datepicker.regional['es']);
			$(function () {
				$("#datepicker").datepicker({
					beforeShowDay: $.datepicker.noWeekends 
				});
				
			});
		
	var especialidadId = $("#especialidadId").val();
	var medicoId = $("#medicoId").val();
	
	 $("#atras").click(function(){
			window.location.assign("/proyecto-limpio-spring/turno/"+ especialidadId + "/medico/"+ medicoId);
		});	
	 
	 $("#botonSiguiente").click(function(){
		var fecha = $('#datepicker').datepicker({ dateFormat: 'dd-mm-yy' }).val();;
		fecha = fecha.replace("/","-");
		fecha = fecha.replace("/","-");
		fecha = fecha.replace("/","-");
		 window.location.assign("/proyecto-limpio-spring/turno/"+ especialidadId + "/medico/"+ medicoId +"/"+ fecha);
		});	
	 
	
>>>>>>> branch 'master' of https://github.com/ignacrescenzo/centro-medico.git
});