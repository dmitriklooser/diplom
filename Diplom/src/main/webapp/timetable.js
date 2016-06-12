function onSubmit(formID){
	var form = document.getElementById(formID);
	var actionElm = document.getElementById("action"); 
	 actionElm.value= "GO";
	form.submit();
}

function onReset(formID){
	var form = document.getElementById(formID);
	var actionElm = document.getElementById("action"); 
	 actionElm.value= "RESET";
	form.submit();
}

function onDelete(formID){
	var form = document.getElementById(formID);
	var actionElm = document.getElementById("action"); 
	 actionElm.value= "DELETE";
	form.submit();
}

function onAdd(formID){
	var form = document.getElementById(formID);
	var actionElm = document.getElementById("action"); 
	 actionElm.value= "ADD";
	form.submit();
}