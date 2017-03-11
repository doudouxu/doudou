function addcar(productId){


	$.get("/shopping/AddCarServlet",{proId : productId+""},function(data){		
		$("div.head #number").text(data.number);		
	});
  
	/*$.ajax({
		url:"/shopping/AddCarServlet?proId="+productId,
		method:"GET",
		dataType:"json",
		error:function(xhr, status, error) {
			alert(status + " " + error);
		},
		success:function(data){
			if(data.code!="200"){
				alert("Error:" + data.message);
			}else{
				var number = data.number;
				$("div.head #number").text(number);
			}
		}
	});*/
}

