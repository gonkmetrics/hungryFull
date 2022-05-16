/**
 * 
 */
 
	function toggleLike() {
		var likeState = $("#likeState").val();
		$.ajax({
			type : "POST",
			url : "registeruser.action",
			data : "uname=" + uname + "&udeg=" + udeg + "&uemail=" + uemail	+ "&upass=" + upass,
			success : function(data) {
				var ht = data.msg;
				$("#resp").html(ht);
			},
			error : function(data) {
				alert("Some error occured.");
			}
		});
	}
	
	function likeState() {		
		$.ajax({			
			type:"GET",
			url:"report.action",
			success: function(result){
				var tblData="";
				$.each(result.beanList, function() {					
					tblData += "<tr><td>" + this.uname + "</td>" + 
					"<td>" + this.uemail + "</td>" + 
					"<td>" + this.upass + "</td>" + 
					"<td>" + this.udeg + "</td>" +
					"<td>"+
					"<button onclick='fetchOldRecord(this);' class='btn btn-sm btn-info' data-toggle='modal' data-target='#updateModal'>Update</button>"+
					"<button onclick='deleteUser(this);' class='btn btn-sm btn-danger'>Delete</button>"+
					"</td></tr>" ;
				});
				$("#tbody").html(tblData);
			},
			error: function(result){
				alert("Some error occured.");
			}
		});
	}