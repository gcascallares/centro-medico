$(document).ready(function() {
		
	var usuarioId = $("#usuario").val();
	
	$("#derivacion").attr("href", window.context +"/derivacion/"+ usuarioId);
	 
});