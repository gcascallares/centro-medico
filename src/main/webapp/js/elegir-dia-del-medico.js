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
			 dayNamesMin: ['Do','Lu','Ma','Mi','Ju','Vi','Sa'],
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
					beforeShowDay: function(date) {
				        var day = date.getDay();
				        return [(day == window.dias[0] || day == window.dias[1] || 
				        		day == window.dias[2] || day == window.dias[3]
				        		|| day == window.dias[4])];
				    } 
						
				});
				
			});
		
	var especialidadId = $("#especialidadId").val();
	var medicoId = $("#medicoId").val();
	
	 $("#atras").click(function(){
			window.history.back();
		});	
	 
	 $("#siguiente").click(function(){
		 
		var fechaValida = $("#datepicker").val();
		
		//Validacion Fecha
		
        if(fechaValida != 0){
        	
        	$("#mensajeDia").fadeOut();
            
        	var fecha = $('#datepicker').datepicker({ dateFormat: 'dd-mm-yy' }).val();;
    		fecha = fecha.replace("/","-");
    		fecha = fecha.replace("/","-");
    		fecha = fecha.replace("/","-");
    		window.location.assign(window.context +"/turno/"+ especialidadId + "/medico/"+ medicoId +"/"+ fecha);
            
        	}
        
        else{
            
        	$("#mensajeDia").fadeIn("slow");
            return false;
            
            }
		
		});	
	 
});