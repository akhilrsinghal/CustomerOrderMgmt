 $(document).ready(function() {
	$('#btn').click(function(e) {
		 alert("TEst");
	        var customer = new Object();
	        customer.custName = $('#custName').val();
	        customer.phNumber = $('#custMobile').val();
	        customer.emailId = $('#custEmail').val();
	        customer.custAddress = $('#custAddress').val();
	        var isValid = true;
	        $('input[name="customer"]').each(function() {
	          //  if ($.trim($(this).val()) == '') {
	       	   if(customer.custName == '' || customer.phNumber == '' || customer.custAddress == ''){
	       		   $('#customer_error_message').html("All Fields are required.").show().delay(1000).fadeOut("slow");
	                isValid = false;
	                $(this).css({
	                    "border": "1px solid red"
	                });
	            }
	            else {
	                $(this).css({
	                    "border": "",
	                    "background": ""
	                });
	            }
	        });
	        
	       if (isValid == false){
	           e.preventDefault();
	       }
	        else{
	        $.ajax({
	            url: 'http://localhost:8080/CustomerService/resources/customer/addCustomer',
	            type: 'POST',
	            headers: {
	                'Content-Type': 'application/json'
	            }, 
	            contentType: 'application/json',
	            Accept : 'application/json',
	            dataType: 'json',
	            data: JSON.stringify(customer),
	            success: function (data, textStatus, xhr) {
	            	getCustomerAjax();
	            	$.bootstrapGrowl('Customer added Susseccfully.',{
	                    type: 'success',
	                    delay: 2000,
	                    align: 'center'
	                });
	            },
	            error: function (xhr, textStatus, errorThrown) {
	                //console.log('Error ddddin Operation');
	            }
	        });
	    }
	});
	 
	 getCustomerAjax();
	 
	 $("#custMobile").keypress(function (e) {
	     //if the letter is not digit then display error and don't type anything
	     if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57)) {
	        //display error message
	        $("#ph_error_message").html("Digits Only").show().delay(1000).fadeOut("slow");
	               return false;
	    }
	   });
	 
	 function getCustomerAjax() { 
			$.ajax({
			    method  : "GET",
			    url     : 'http://localhost:8080/CustomerService/resources/customer/getCustomer',
			   headers: {
			       'Content-Type': 'application/json'
			   }, 
			   contentType: 'application/json',
			   Accept : 'application/json',
			   dataType: 'json',
			    success: function(response) {
			    	var dataset1 = [];
			    //	var graphData = [];
				  	var customerList = '';
				 	  $.each(response.customer, function(i, contact) {
				 		  var row = []
				 		    /* row.push(contact.id); */
				 		 	row.push('<a href="#" class="customerRecord" data="'+contact.id+'">'+contact.custName+'</a>');
					 		//row.push(contact.custName);
					 		row.push(contact.phNumber);
					 		row.push(contact.emailId);
					 		row.push(contact.custAddress);
					 		row.push((new Date(contact.createdDate)).toLocaleString());
					 		dataset1.push(row);
					 		customerList += '<option value=' + contact.id + '>' + contact.custName + '</option>';
			       });  
				 	 $("#customerDropDown").append(customerList);
				 	$('.selectpicker').selectpicker('refresh');
				 	 
				 	function customerChart(dataset1, CustomerName){
			        	var chart = new CanvasJS.Chart("customerchartContainer", {
		 	    	 	animationEnabled: true,
		 	    	 	theme: "light2",
		 	    	 	//backgroundColor: "#5bc0de",
		 	    	 	 title: {
		 	    	 		text: CustomerName
		 	    	 	}, 
		 	    	 	axisX:{
		 	    	        title: "Month",
		 	    	        intervalType: "month",        
		 	    	        labelAngle: -20
		 	    	      },
		 	    	 	axisY: {
		 	    	 		title: "Amount",
		 	    	 		titleFontSize: 24
		 	    	 	},
		 	    	 	legend:{
		 	    	        verticalAlign: "bottom",
		 	    	        horizontalAlign: "center"
		 	    	      },
		 	    	 	data: [{
		 	    	 		type: "doughnut",
		 	    	 		indexLabelFontSize: 17,
		 	    	 		indexLabel: "{label} - #percent%",
		 	    	 		toolTipContent: "<b>{label}:</b> {y} (#percent%)",
		 	    	 		yValueFormatString: "#,### Rs",
		 	    	 		toolTipContent: "{y}",
		 	    	 		showInLegend: true,
		 	    	 		dataPoints: dataset1
		 	    	 	}]
		 	    	 });
			        	chart.render();
			         }
				 	$('#customer').DataTable( {
				 				"destroy": true,
				 				"order": [[ 4, "desc" ]],
								data:dataset1,
					     		drawCallback: function( settings ) {
					     			 $(".customerRecord").on('click',function(){
					     				var custId = $(this).attr('data');
					     				var html;
					     					   $.ajax({
					     					         method  : "GET",
					     					         url     : 'http://localhost:8080/CustomerService/resources/customer/getCustomerRecord?customerId='+custId,
					     					        headers: {
					     				                'Content-Type': 'application/json'
					     				            }, 
					     				            contentType: 'application/json',
					     				            Accept : 'application/json',
					     				            dataType: 'json',
					     					         success: function(response) {
					     					        	var metrics = [];
					     					        	var CustomerName = '';
						     					         if(response.customerRecord == undefined){
						     					        	response.customerRecord = 0; 
						     					        	metrics = [{y:'No Data Available',label: 'No Data Available'}];
						     					        	
						     					         }
						     					         else{
						     					        		/* html = "<div class = 'col-md-5'>"+
						     									 		"<h4>Monthly Sales Data</h4>"+
						     											"<div id='customerChart'></div></div>";  */
						     											 metrics = [{y:response.customerRecord.totalAmount,legendText:'Total Amount',label:'Total Amount'},
						     					         							{y:response.customerRecord.depositedAmount,legendText:'Deposited Amount',label:'Deposited Amount'},
						     					         							{y:response.customerRecord.remainingAmount,legendText:'Remaining Amount',label:'Remaining Amount'}];
						     											CustomerName = "Customer: "+response.customerRecord.custName;
						     					         }
						     					        customerChart(metrics, CustomerName);
					     					        	 /* BootstrapDialog.show({
									     					title: 'Customer Record',
									     					id:"cust",
									     					message:html,
									     					cssClass: 'login-dialog',
									     					closable: true,
													        closeByBackdrop: true,
													        closeByKeyboard: true,
													        onshown: function(){
													        	customerChart(metrics);
													        },
													        buttons: [{
							     					               label: 'Cancel', 
							     					               action: function(dialogRef) {
							     					               	dialogRef.close();
							     					               }
							     					  		 }]
					     					        	}); */
					     							},
			     					error : function(e) {
			     					}
		     					});
					     	       });
					     	    }
			  		 });
				},
				error : function(e) {
				}
			});
		}
 });